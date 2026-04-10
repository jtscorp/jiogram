package io.jiogram.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

/**
 * Configuration properties for the Jiogram Telegram bot framework.
 * Bind to the {@code telegram} prefix in application.yml / application.properties.
 */
@ConfigurationProperties(prefix = "telegram")
@ConstructorBinding
public class JiogramProperties {

    /** The bot API token (required). */
    private final String token;

    /** The operating mode: POLLING or WEBHOOK. Defaults to POLLING. */
    private final Mode mode;

    /** Polling configuration. */
    private final PollingProperties polling;

    /** Webhook configuration. */
    private final WebhookProperties webhook;

    /** Default bot properties applied to outgoing requests. */
    private final DefaultsProperties defaults;

    /** FSM (Finite State Machine) configuration. */
    private final FsmProperties fsm;

    public JiogramProperties(
            String token,
            @DefaultValue("POLLING") Mode mode,
            @DefaultValue PollingProperties polling,
            @DefaultValue WebhookProperties webhook,
            @DefaultValue DefaultsProperties defaults,
            @DefaultValue FsmProperties fsm) {
        this.token = token;
        this.mode = mode;
        this.polling = polling;
        this.webhook = webhook;
        this.defaults = defaults;
        this.fsm = fsm;
    }

    public String token() { return token; }
    public Mode mode() { return mode; }
    public PollingProperties polling() { return polling; }
    public WebhookProperties webhook() { return webhook; }
    public DefaultsProperties defaults() { return defaults; }
    public FsmProperties fsm() { return fsm; }

    public enum Mode {
        POLLING,
        WEBHOOK
    }

    /**
     * Polling configuration properties.
     */
    @ConstructorBinding
    public static class PollingProperties {

        private final int timeout;
        private final long backoff;
        private final int limit;
        private final List<String> allowedUpdates;

        public PollingProperties(
                @DefaultValue("30") int timeout,
                @DefaultValue("1000") long backoff,
                @DefaultValue("100") int limit,
                List<String> allowedUpdates) {
            this.timeout = timeout;
            this.backoff = backoff;
            this.limit = limit;
            this.allowedUpdates = allowedUpdates;
        }

        public int timeout() { return timeout; }
        public long backoff() { return backoff; }
        public int limit() { return limit; }
        public List<String> allowedUpdates() { return allowedUpdates; }
    }

    /**
     * Webhook configuration properties.
     */
    @ConstructorBinding
    public static class WebhookProperties {

        private final String url;
        private final String path;
        private final String secretToken;
        private final int maxConnections;

        public WebhookProperties(
                String url,
                @DefaultValue("/bot/webhook") String path,
                String secretToken,
                @DefaultValue("40") int maxConnections) {
            this.url = url;
            this.path = path;
            this.secretToken = secretToken;
            this.maxConnections = maxConnections;
        }

        public String url() { return url; }
        public String path() { return path; }
        public String secretToken() { return secretToken; }
        public int maxConnections() { return maxConnections; }
    }

    /**
     * Default properties applied to all outgoing bot requests.
     */
    @ConstructorBinding
    public static class DefaultsProperties {

        private final String parseMode;
        private final boolean protectContent;
        private final boolean linkPreview;

        public DefaultsProperties(
                String parseMode,
                @DefaultValue("false") boolean protectContent,
                @DefaultValue("true") boolean linkPreview) {
            this.parseMode = parseMode;
            this.protectContent = protectContent;
            this.linkPreview = linkPreview;
        }

        public String parseMode() { return parseMode; }
        public boolean protectContent() { return protectContent; }
        public boolean linkPreview() { return linkPreview; }
    }

    /**
     * FSM configuration properties.
     */
    @ConstructorBinding
    public static class FsmProperties {

        private final boolean enabled;
        private final String strategy;
        private final String storage;

        public FsmProperties(
                @DefaultValue("true") boolean enabled,
                @DefaultValue("USER_IN_CHAT") String strategy,
                @DefaultValue("memory") String storage) {
            this.enabled = enabled;
            this.strategy = strategy;
            this.storage = storage;
        }

        public boolean enabled() { return enabled; }
        public String strategy() { return strategy; }
        public String storage() { return storage; }
    }
}
