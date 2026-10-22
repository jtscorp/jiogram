package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.dispatcher.EventType;
import io.jiogram.methods.GetUpdates;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.BusinessMessagesDeleted;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.ChatBoostRemoved;
import io.jiogram.types.ChatBoostUpdated;
import io.jiogram.types.ChatJoinRequest;
import io.jiogram.types.ChatMemberUpdated;
import io.jiogram.types.ChosenInlineResult;
import io.jiogram.types.InaccessibleMessage;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.ManagedBotUpdated;
import io.jiogram.types.Message;
import io.jiogram.types.MessageReactionCountUpdated;
import io.jiogram.types.MessageReactionUpdated;
import io.jiogram.types.PaidMediaPurchased;
import io.jiogram.types.PollAnswer;
import io.jiogram.types.PreCheckoutQuery;
import io.jiogram.types.ShippingQuery;
import io.jiogram.types.Update;
import io.jiogram.types.UpdateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A {@link SmartLifecycle} component that runs the Telegram long-polling loop.
 * Continuously fetches updates via {@link GetUpdates} and dispatches them
 * through the {@link Dispatcher}.
 */
public class PollingRunner implements SmartLifecycle {

    private static final Logger log = LoggerFactory.getLogger(PollingRunner.class);

    private static final Duration CONFIRM_TIMEOUT = Duration.ofSeconds(5);

    private final Bot bot;
    private final Dispatcher dispatcher;
    private final JiogramProperties properties;

    private final AtomicBoolean running = new AtomicBoolean(false);
    /** True while a batch is being dispatched; a stop then lets it finish. */
    private final AtomicBoolean processing = new AtomicBoolean(false);
    /** First update id not yet processed; 0 before the first batch. */
    private final AtomicLong offset = new AtomicLong(0);
    /** The offset last sent to Telegram, which confirms every update below it. */
    private final AtomicLong requestedOffset = new AtomicLong(0);
    private volatile Disposable subscription;
    private volatile Sinks.Empty<Void> loopTerminated;
    private volatile CountDownLatch stopped;

    public PollingRunner(Bot bot, Dispatcher dispatcher, JiogramProperties properties) {
        this.bot = bot;
        this.dispatcher = dispatcher;
        this.properties = properties;
    }

    @Override
    public void start() {
        if (running.compareAndSet(false, true)) {
            log.info("Starting Telegram polling for bot {}", bot.id());

            JiogramProperties.PollingProperties polling = properties.polling();
            long timeout = polling != null ? polling.timeout() : 30;
            int limit = polling != null ? polling.limit() : 100;
            long backoff = polling != null ? polling.backoff() : 1000;
            List<UpdateType> allowedUpdates = polling != null ? polling.allowedUpdates() : null;
            int concurrency = polling != null ? Math.max(1, polling.concurrency()) : 1;

            Sinks.Empty<Void> terminated = Sinks.empty();
            loopTerminated = terminated;
            subscription = Flux.defer(() -> {
                    long currentOffset = offset.get();
                    requestedOffset.set(currentOffset);
                    GetUpdates request = new GetUpdates(
                        currentOffset == 0 ? null : currentOffset,
                        (long) limit,
                        timeout,
                        allowedUpdates
                    );
                    return bot.execute(request)
                        .flatMapMany(updates -> processUpdates(updates, concurrency));
                })
                .repeat(() -> running.get())
                .retryWhen(Retry.backoff(Long.MAX_VALUE, Duration.ofMillis(backoff))
                    .maxBackoff(Duration.ofSeconds(30))
                    // Restart the backoff after a successful poll instead of growing it for the
                    // lifetime of the process.
                    .transientErrors(true)
                    .doBeforeRetry(signal ->
                        log.warn("Polling error, retrying (attempt {}): {}",
                            signal.totalRetries() + 1, signal.failure().getMessage())
                    )
                    .filter(throwable -> running.get()))
                .doFinally(signal -> terminated.tryEmitEmpty())
                .subscribe(null, e -> log.warn("Polling stopped with an error: {}", e.getMessage()));

            keepJvmAlive();
        }
    }

    /**
     * Polling runs on Reactor's daemon threads, so an application without a web server would
     * exit right after startup. A non-daemon thread waits until {@link #stop()}.
     */
    private void keepJvmAlive() {
        CountDownLatch latch = new CountDownLatch(1);
        stopped = latch;
        Thread keepAlive = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "jiogram-polling-keep-alive");
        keepAlive.setDaemon(false);
        keepAlive.start();
    }

    /**
     * Processes one batch: updates of the same chat run one after another in arrival order
     * (keeping FSM transitions consistent), different chats run in parallel up to
     * {@code concurrency}. The next poll starts when the whole batch is done.
     */
    private Flux<Void> processUpdates(List<Update> updates, int concurrency) {
        if (updates == null || updates.isEmpty()) {
            return Flux.empty();
        }
        long nextOffset = updates.stream().mapToLong(Update::updateId).max().getAsLong() + 1;

        // Plain grouping instead of Flux.groupBy, which can stall when groups outnumber concurrency.
        Map<Object, List<Update>> byChat = new LinkedHashMap<>();
        for (Update update : updates) {
            byChat.computeIfAbsent(sequenceKey(update), key -> new ArrayList<>()).add(update);
        }

        return Flux.fromIterable(byChat.values())
            .flatMap(chatUpdates -> Flux.fromIterable(chatUpdates).concatMap(this::dispatch), concurrency)
            // Advanced only once the whole batch is done: a batch cut short by shutdown is
            // delivered again after a restart instead of being lost.
            .doOnComplete(() -> offset.set(nextOffset))
            .doOnSubscribe(subscription -> processing.set(true))
            .doFinally(signal -> processing.set(false));
    }

    private Mono<Void> dispatch(Update update) {
        return dispatcher.feedUpdate(bot, update)
            .onErrorResume(e -> {
                log.error("Error dispatching update {}: {}",
                    update.updateId(), e.getMessage(), e);
                return Mono.empty();
            });
    }

    /**
     * Updates with equal keys are processed sequentially. The key is the chat the update belongs
     * to (a private chat's id equals the user's id), else the acting user; updates tied to neither
     * get a unique key and run independently.
     */
    static Object sequenceKey(Update update) {
        EventType type = EventType.of(update);
        if (type == null) {
            return "update:" + update.updateId();
        }
        Long key = chatOrUserId(type, type.extract(update));
        return key != null ? key : "update:" + update.updateId();
    }

    /**
     * The id of the chat the event belongs to, else of the acting user, else {@code null}.
     * <p>
     * This switch must list every {@link EventType}: a new event type must decide its ordering
     * here. Java 11 cannot check that at compile time, so the {@code default} branch throws and
     * {@code PollingRunnerTest} calls this method with every constant.
     */
    static Long chatOrUserId(EventType type, Object event) {
        switch (type) {
            case MESSAGE:
            case EDITED_MESSAGE:
            case CHANNEL_POST:
            case EDITED_CHANNEL_POST:
            case BUSINESS_MESSAGE:
            case EDITED_BUSINESS_MESSAGE:
                return ((Message) event).chat().id();
            case CALLBACK_QUERY: {
                CallbackQuery query = (CallbackQuery) event;
                if (query.message() instanceof Message) {
                    return ((Message) query.message()).chat().id();
                }
                if (query.message() instanceof InaccessibleMessage) {
                    return ((InaccessibleMessage) query.message()).chat().id();
                }
                return query.from().id();
            }
            case MY_CHAT_MEMBER:
            case CHAT_MEMBER:
                return ((ChatMemberUpdated) event).chat().id();
            case CHAT_JOIN_REQUEST:
                return ((ChatJoinRequest) event).chat().id();
            case MESSAGE_REACTION:
                return ((MessageReactionUpdated) event).chat().id();
            case MESSAGE_REACTION_COUNT:
                return ((MessageReactionCountUpdated) event).chat().id();
            case CHAT_BOOST:
                return ((ChatBoostUpdated) event).chat().id();
            case REMOVED_CHAT_BOOST:
                return ((ChatBoostRemoved) event).chat().id();
            case DELETED_BUSINESS_MESSAGES:
                return ((BusinessMessagesDeleted) event).chat().id();
            case INLINE_QUERY:
                return ((InlineQuery) event).from().id();
            case CHOSEN_INLINE_RESULT:
                return ((ChosenInlineResult) event).from().id();
            case SHIPPING_QUERY:
                return ((ShippingQuery) event).from().id();
            case PRE_CHECKOUT_QUERY:
                return ((PreCheckoutQuery) event).from().id();
            case PURCHASED_PAID_MEDIA:
                return ((PaidMediaPurchased) event).from().id();
            case BUSINESS_CONNECTION:
                return ((BusinessConnection) event).user().id();
            case MANAGED_BOT:
                return ((ManagedBotUpdated) event).user().id();
            case POLL_ANSWER: {
                PollAnswer answer = (PollAnswer) event;
                // Plain ifs: a nested "? long : null" conditional would unbox the null and throw.
                if (answer.user() != null) {
                    return answer.user().id();
                }
                if (answer.voterChat() != null) {
                    return answer.voterChat().id();
                }
                return null;
            }
            case POLL:
                return null;
            default:
                throw new IllegalStateException("No ordering defined for event type " + type);
        }
    }

    /**
     * Stops polling. A pending {@code getUpdates} call is cancelled right away; a batch being
     * processed may finish first, for up to {@code telegram.polling.shutdown-timeout}. The
     * processed updates are then confirmed to Telegram, so a restart does not receive them again.
     */
    @Override
    public void stop(Runnable callback) {
        if (!running.compareAndSet(true, false)) {
            callback.run();
            return;
        }
        log.info("Stopping Telegram polling for bot {}", bot.id());
        Disposable loop = subscription;
        if (!processing.get()) {
            // Only waiting for Telegram (or for a retry): nothing to finish.
            loop.dispose();
        }
        Duration shutdownTimeout = properties.polling() != null
            ? properties.polling().shutdownTimeout()
            : Duration.ofSeconds(10);
        loopTerminated.asMono()
            .timeout(shutdownTimeout, Mono.fromRunnable(() -> {
                log.warn("Update processing did not finish within {}, cancelling it; "
                    + "the unfinished updates are delivered again after a restart", shutdownTimeout);
                loop.dispose();
            }))
            .then(Mono.defer(this::confirmOffset))
            .doFinally(signal -> {
                CountDownLatch keepAlive = stopped;
                if (keepAlive != null) {
                    keepAlive.countDown();
                }
                callback.run();
            })
            .subscribe();
    }

    @Override
    public void stop() {
        CountDownLatch done = new CountDownLatch(1);
        stop(done::countDown);
        try {
            done.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Telegram forgets updates below the offset of a {@code getUpdates} call. When processed
     * updates have not been confirmed by a poll yet, one short call (no waiting, at most one
     * update, which is not processed and so stays unconfirmed) does it.
     */
    private Mono<Void> confirmOffset() {
        long next = offset.get();
        if (next == 0 || next == requestedOffset.get()) {
            return Mono.empty();
        }
        return bot.execute(new GetUpdates(next, 1L, 0L, null))
            .timeout(CONFIRM_TIMEOUT)
            .doOnSuccess(ignored -> {
                requestedOffset.set(next);
                log.debug("Confirmed processed updates below {}", next);
            })
            .onErrorResume(e -> {
                log.warn("Could not confirm processed updates to Telegram, they may be delivered again: {}",
                    e.getMessage());
                return Mono.empty();
            })
            .then();
    }

    @Override
    public boolean isRunning() {
        return running.get();
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE; // Start last, stop first
    }
}
