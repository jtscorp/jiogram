package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.methods.GetUpdates;
import io.jiogram.types.InaccessibleMessage;
import io.jiogram.types.Message;
import io.jiogram.types.PollAnswer;
import io.jiogram.types.Update;
import io.jiogram.types.UpdateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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

    private final Bot bot;
    private final Dispatcher dispatcher;
    private final JiogramProperties properties;

    private final AtomicBoolean running = new AtomicBoolean(false);
    private final AtomicLong offset = new AtomicLong(0);
    private volatile Disposable subscription;
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

            subscription = Flux.defer(() -> {
                    Long currentOffset = offset.get() == 0 ? null : offset.get();
                    GetUpdates request = new GetUpdates(
                        currentOffset,
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
                .subscribe();

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
        Thread.ofPlatform().name("jiogram-polling-keep-alive").daemon(false).start(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
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

        // Confirmed to Telegram by the next getUpdates call.
        offset.set(updates.stream().mapToLong(Update::updateId).max().getAsLong() + 1);

        // Plain grouping instead of Flux.groupBy, which can stall when groups outnumber concurrency.
        Map<Object, List<Update>> byChat = new LinkedHashMap<>();
        for (Update update : updates) {
            byChat.computeIfAbsent(sequenceKey(update), key -> new ArrayList<>()).add(update);
        }

        return Flux.fromIterable(byChat.values())
            .flatMap(chatUpdates -> Flux.fromIterable(chatUpdates).concatMap(this::dispatch), concurrency);
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
        Message message = firstNonNull(update.message(), update.editedMessage(), update.channelPost(),
            update.editedChannelPost(), update.businessMessage(), update.editedBusinessMessage());
        if (message != null) {
            return message.chat().id();
        }
        if (update.callbackQuery() != null) {
            return switch (update.callbackQuery().message()) {
                case Message m -> m.chat().id();
                case InaccessibleMessage m -> m.chat().id();
                case null -> update.callbackQuery().from().id();
            };
        }
        if (update.myChatMember() != null) return update.myChatMember().chat().id();
        if (update.chatMember() != null) return update.chatMember().chat().id();
        if (update.chatJoinRequest() != null) return update.chatJoinRequest().chat().id();
        if (update.messageReaction() != null) return update.messageReaction().chat().id();
        if (update.messageReactionCount() != null) return update.messageReactionCount().chat().id();
        if (update.chatBoost() != null) return update.chatBoost().chat().id();
        if (update.removedChatBoost() != null) return update.removedChatBoost().chat().id();
        if (update.deletedBusinessMessages() != null) return update.deletedBusinessMessages().chat().id();
        if (update.inlineQuery() != null) return update.inlineQuery().from().id();
        if (update.chosenInlineResult() != null) return update.chosenInlineResult().from().id();
        if (update.shippingQuery() != null) return update.shippingQuery().from().id();
        if (update.preCheckoutQuery() != null) return update.preCheckoutQuery().from().id();
        if (update.purchasedPaidMedia() != null) return update.purchasedPaidMedia().from().id();
        if (update.businessConnection() != null) return update.businessConnection().user().id();
        if (update.pollAnswer() != null) {
            PollAnswer answer = update.pollAnswer();
            if (answer.user() != null) return answer.user().id();
            if (answer.voterChat() != null) return answer.voterChat().id();
        }
        return "update:" + update.updateId();
    }

    @SafeVarargs
    private static <T> T firstNonNull(T... values) {
        for (T value : values) {
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    @Override
    public void stop() {
        if (running.compareAndSet(true, false)) {
            log.info("Stopping Telegram polling for bot {}", bot.id());
            if (subscription != null) {
                subscription.dispose();
                subscription = null;
            }
            if (stopped != null) {
                stopped.countDown();
                stopped = null;
            }
        }
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
