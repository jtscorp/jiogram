package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.methods.GetUpdates;
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
import java.util.List;
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

            subscription = Flux.defer(() -> {
                    Long currentOffset = offset.get() == 0 ? null : offset.get();
                    GetUpdates request = new GetUpdates(
                        currentOffset,
                        (long) limit,
                        timeout,
                        allowedUpdates
                    );
                    return bot.execute(request)
                        .flatMapMany(updates -> processUpdates(updates));
                })
                .repeat(() -> running.get())
                .retryWhen(Retry.backoff(Long.MAX_VALUE, Duration.ofMillis(backoff))
                    .maxBackoff(Duration.ofSeconds(30))
                    .doBeforeRetry(signal ->
                        log.warn("Polling error, retrying (attempt {}): {}",
                            signal.totalRetries() + 1, signal.failure().getMessage())
                    )
                    .filter(throwable -> running.get()))
                .subscribe();
        }
    }

    private Flux<Void> processUpdates(List<Update> updates) {
        if (updates == null || updates.isEmpty()) {
            return Flux.empty();
        }

        return Flux.fromIterable(updates)
            .concatMap(update -> {
                offset.set(update.updateId() + 1);
                return dispatcher.feedUpdate(bot, update)
                    .onErrorResume(e -> {
                        log.error("Error dispatching update {}: {}",
                            update.updateId(), e.getMessage(), e);
                        return Mono.empty();
                    });
            });
    }

    @Override
    public void stop() {
        if (running.compareAndSet(true, false)) {
            log.info("Stopping Telegram polling for bot {}", bot.id());
            if (subscription != null) {
                subscription.dispose();
                subscription = null;
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
