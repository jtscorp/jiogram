package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.methods.SetWebhook;
import io.jiogram.types.UpdateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import reactor.core.Disposable;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Registers the configured public webhook URL with Telegram when webhook mode starts.
 */
public class WebhookRegistrar implements SmartLifecycle {

    private static final Logger log = LoggerFactory.getLogger(WebhookRegistrar.class);

    private final Bot bot;
    private final JiogramProperties properties;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private volatile Disposable registration;

    public WebhookRegistrar(Bot bot, JiogramProperties properties) {
        this.bot = bot;
        this.properties = properties;
    }

    @Override
    public void start() {
        if (!running.compareAndSet(false, true)) {
            return;
        }

        JiogramProperties.WebhookProperties webhook = properties.webhook();
        if (webhook == null || webhook.url() == null || webhook.url().isBlank()) {
            log.warn("Webhook mode is enabled but telegram.webhook.url is not configured; skipping setWebhook");
            return;
        }

        List<UpdateType> allowedUpdates = properties.polling() != null
            ? properties.polling().allowedUpdates()
            : null;

        SetWebhook request = new SetWebhook(
            webhook.url(),
            null,
            null,
            (long) webhook.maxConnections(),
            allowedUpdates,
            null,
            webhook.secretToken()
        );

        registration = bot.execute(request)
            .doOnSuccess(ignored -> log.info("Registered Telegram webhook for bot {} at {}", bot.id(), webhook.url()))
            .doOnError(error -> log.error("Failed to register Telegram webhook for bot {}: {}",
                bot.id(), error.getMessage(), error))
            .subscribe();
    }

    @Override
    public void stop() {
        if (running.compareAndSet(true, false) && registration != null) {
            registration.dispose();
            registration = null;
        }
    }

    @Override
    public boolean isRunning() {
        return running.get();
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE - 1;
    }
}
