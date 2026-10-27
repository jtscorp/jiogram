package io.jiogram.autoconfigure;

import io.jiogram.fsm.FSMStrategy;
import io.jiogram.types.ParseMode;
import io.jiogram.types.UpdateType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.util.unit.DataSize;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * Configuration properties for the Jiogram Telegram bot framework.
 * Bind to the {@code telegram} prefix in application.yml / application.properties.
 * <p>
 * Immutable and constructor-bound; the accessors are named like the properties (no {@code get}
 * prefix), and {@link #toString()} prints {@code Name[component=value, ...]} with the token and
 * the webhook secret masked.
 */
@ConfigurationProperties(prefix = "telegram")
@ConstructorBinding
public final class JiogramProperties {

    /** The bot API token (required). */
    private final String token;

    /** The operating mode: POLLING or WEBHOOK. Defaults to POLLING. */
    private final Mode mode;

    /** Polling configuration. */
    private final PollingProperties polling;

    /** Webhook configuration. */
    private final WebhookProperties webhook;

    /** Telegram Bot API endpoint configuration. */
    private final ApiProperties api;

    /** Default bot properties applied to outgoing requests. */
    private final DefaultsProperties defaults;

    /** FSM (Finite State Machine) configuration. */
    private final FsmProperties fsm;

    /** Handler execution configuration. */
    private final HandlersProperties handlers;

    /**
     * Creates the properties; Spring binds them from the {@code telegram.*} keys.
     *
     * @param token    the bot API token (required)
     * @param mode     the operating mode: POLLING or WEBHOOK
     * @param polling  polling configuration
     * @param webhook  webhook configuration
     * @param api      Telegram Bot API endpoint configuration
     * @param defaults default bot properties applied to outgoing requests
     * @param fsm      FSM (Finite State Machine) configuration
     * @param handlers handler execution configuration
     */
    public JiogramProperties(
            String token,
            @DefaultValue("POLLING") Mode mode,
            @DefaultValue PollingProperties polling,
            @DefaultValue WebhookProperties webhook,
            @DefaultValue ApiProperties api,
            @DefaultValue DefaultsProperties defaults,
            @DefaultValue FsmProperties fsm,
            @DefaultValue HandlersProperties handlers) {
        this.token = token;
        this.mode = mode;
        this.polling = polling;
        this.webhook = webhook;
        this.api = api;
        this.defaults = defaults;
        this.fsm = fsm;
        this.handlers = handlers;
    }

    /** @return the bot API token */
    public String token() {
        return token;
    }

    /** @return the operating mode */
    public Mode mode() {
        return mode;
    }

    /** @return the polling configuration */
    public PollingProperties polling() {
        return polling;
    }

    /** @return the webhook configuration */
    public WebhookProperties webhook() {
        return webhook;
    }

    /** @return the Telegram Bot API endpoint configuration */
    public ApiProperties api() {
        return api;
    }

    /** @return the default bot properties applied to outgoing requests */
    public DefaultsProperties defaults() {
        return defaults;
    }

    /** @return the FSM configuration */
    public FsmProperties fsm() {
        return fsm;
    }

    /** @return the handler execution configuration */
    public HandlersProperties handlers() {
        return handlers;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JiogramProperties)) {
            return false;
        }
        JiogramProperties that = (JiogramProperties) other;
        return Objects.equals(token, that.token)
            && Objects.equals(mode, that.mode)
            && Objects.equals(polling, that.polling)
            && Objects.equals(webhook, that.webhook)
            && Objects.equals(api, that.api)
            && Objects.equals(defaults, that.defaults)
            && Objects.equals(fsm, that.fsm)
            && Objects.equals(handlers, that.handlers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, mode, polling, webhook, api, defaults, fsm, handlers);
    }

    /** Keeps the bot token out of logs and error messages. */
    @Override
    public String toString() {
        return "JiogramProperties[token=" + mask(token) + ", mode=" + mode + ", polling=" + polling
            + ", webhook=" + webhook + ", api=" + api + ", defaults=" + defaults + ", fsm=" + fsm
            + ", handlers=" + handlers + "]";
    }

    private static String mask(String secret) {
        return secret == null ? "null" : "****";
    }

    /** How updates are received. */
    public enum Mode {
        /** Long polling with {@code getUpdates}. */
        POLLING,
        /** Telegram pushes updates to a webhook endpoint of this application. */
        WEBHOOK
    }

    /**
     * Polling configuration properties.
     */
    @ConstructorBinding
    public static final class PollingProperties {

        /** Long-polling timeout in seconds. */
        private final int timeout;

        /** Backoff delay in milliseconds on error. */
        private final long backoff;

        /** Maximum number of updates per poll. */
        private final int limit;

        /** List of update types to receive. */
        private final List<UpdateType> allowedUpdates;

        /**
         * How many chats of one batch are processed in parallel; updates of the same chat are
         * always processed one after another, in order.
         */
        private final int concurrency;

        /** How long stopping waits for the batch being processed to finish before cancelling it. */
        private final Duration shutdownTimeout;

        /**
         * Creates the polling properties.
         *
         * @param timeout         long-polling timeout in seconds
         * @param backoff         backoff delay in milliseconds on error
         * @param limit           maximum number of updates per poll
         * @param allowedUpdates  list of update types to receive
         * @param concurrency     how many chats of one batch are processed in parallel; updates of
         *                        the same chat are always processed one after another, in order
         * @param shutdownTimeout how long stopping waits for the batch being processed to finish
         *                        before cancelling it
         */
        public PollingProperties(
                @DefaultValue("30") int timeout,
                @DefaultValue("1000") long backoff,
                @DefaultValue("100") int limit,
                List<UpdateType> allowedUpdates,
                @DefaultValue("32") int concurrency,
                @DefaultValue("10s") Duration shutdownTimeout) {
            this.timeout = timeout;
            this.backoff = backoff;
            this.limit = limit;
            this.allowedUpdates = allowedUpdates;
            this.concurrency = concurrency;
            this.shutdownTimeout = shutdownTimeout;
        }

        /** @return the long-polling timeout in seconds */
        public int timeout() {
            return timeout;
        }

        /** @return the backoff delay in milliseconds on error */
        public long backoff() {
            return backoff;
        }

        /** @return the maximum number of updates per poll */
        public int limit() {
            return limit;
        }

        /** @return the update types to receive, or {@code null} for Telegram's default */
        public List<UpdateType> allowedUpdates() {
            return allowedUpdates;
        }

        /** @return how many chats of one batch are processed in parallel */
        public int concurrency() {
            return concurrency;
        }

        /** @return how long stopping waits for the batch being processed */
        public Duration shutdownTimeout() {
            return shutdownTimeout;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PollingProperties)) {
                return false;
            }
            PollingProperties that = (PollingProperties) other;
            return timeout == that.timeout
                && backoff == that.backoff
                && limit == that.limit
                && Objects.equals(allowedUpdates, that.allowedUpdates)
                && concurrency == that.concurrency
                && Objects.equals(shutdownTimeout, that.shutdownTimeout);
        }

        @Override
        public int hashCode() {
            return Objects.hash(timeout, backoff, limit, allowedUpdates, concurrency, shutdownTimeout);
        }

        @Override
        public String toString() {
            return "PollingProperties[timeout=" + timeout + ", backoff=" + backoff + ", limit=" + limit
                + ", allowedUpdates=" + allowedUpdates + ", concurrency=" + concurrency
                + ", shutdownTimeout=" + shutdownTimeout + "]";
        }
    }

    /**
     * Webhook configuration properties.
     */
    @ConstructorBinding
    public static final class WebhookProperties {

        /** The public URL where Telegram sends updates. */
        private final String url;

        /** The local endpoint path. */
        private final String path;

        /** The secret token for request validation. */
        private final String secretToken;

        /** Maximum concurrent webhook connections. */
        private final int maxConnections;

        /**
         * Creates the webhook properties.
         *
         * @param url            the public URL where Telegram sends updates
         * @param path           the local endpoint path
         * @param secretToken    the secret token for request validation
         * @param maxConnections maximum concurrent webhook connections
         */
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

        /** @return the public URL where Telegram sends updates */
        public String url() {
            return url;
        }

        /** @return the local endpoint path */
        public String path() {
            return path;
        }

        /** @return the secret token for request validation */
        public String secretToken() {
            return secretToken;
        }

        /** @return the maximum concurrent webhook connections */
        public int maxConnections() {
            return maxConnections;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebhookProperties)) {
                return false;
            }
            WebhookProperties that = (WebhookProperties) other;
            return Objects.equals(url, that.url)
                && Objects.equals(path, that.path)
                && Objects.equals(secretToken, that.secretToken)
                && maxConnections == that.maxConnections;
        }

        @Override
        public int hashCode() {
            return Objects.hash(url, path, secretToken, maxConnections);
        }

        /** Keeps the webhook secret out of logs and error messages. */
        @Override
        public String toString() {
            return "WebhookProperties[url=" + url + ", path=" + path + ", secretToken=" + mask(secretToken)
                + ", maxConnections=" + maxConnections + "]";
        }
    }

    /**
     * Telegram Bot API endpoint configuration.
     */
    @ConstructorBinding
    public static final class ApiProperties {

        public static final DataSize DEFAULT_MAX_RESPONSE_SIZE = DataSize.ofMegabytes(16);

        /** Base URL of the Bot API server. */
        private final String baseUrl;

        /**
         * How long to wait for a response to a request; {@code getUpdates} gets its long-polling
         * timeout on top.
         */
        private final Duration requestTimeout;

        /**
         * Largest response body that is read; a full {@code getUpdates} batch after downtime
         * easily exceeds WebClient's default of 256 KB.
         */
        private final DataSize maxResponseSize;

        /**
         * Creates the API properties.
         *
         * @param baseUrl         base URL of the Bot API server
         * @param requestTimeout  how long to wait for a response to a request; {@code getUpdates}
         *                        gets its long-polling timeout on top
         * @param maxResponseSize largest response body that is read
         */
        @ConstructorBinding
        public ApiProperties(
                @DefaultValue("https://api.telegram.org") String baseUrl,
                @DefaultValue("60s") Duration requestTimeout,
                @DefaultValue("16MB") DataSize maxResponseSize) {
            this.baseUrl = baseUrl;
            this.requestTimeout = requestTimeout;
            this.maxResponseSize = maxResponseSize;
        }

        /** The constructor of 0.2.0, kept for code that creates these properties itself. */
        public ApiProperties(String baseUrl, Duration requestTimeout) {
            this(baseUrl, requestTimeout, DEFAULT_MAX_RESPONSE_SIZE);
        }

        /** @return the base URL of the Bot API server */
        public String baseUrl() {
            return baseUrl;
        }

        /** @return how long to wait for a response to a request */
        public Duration requestTimeout() {
            return requestTimeout;
        }

        /** @return the largest response body that is read */
        public DataSize maxResponseSize() {
            return maxResponseSize;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiProperties)) {
                return false;
            }
            ApiProperties that = (ApiProperties) other;
            return Objects.equals(baseUrl, that.baseUrl)
                && Objects.equals(requestTimeout, that.requestTimeout)
                && Objects.equals(maxResponseSize, that.maxResponseSize);
        }

        @Override
        public int hashCode() {
            return Objects.hash(baseUrl, requestTimeout, maxResponseSize);
        }

        @Override
        public String toString() {
            return "ApiProperties[baseUrl=" + baseUrl + ", requestTimeout=" + requestTimeout
                + ", maxResponseSize=" + maxResponseSize + "]";
        }
    }

    /**
     * Default properties applied to all outgoing bot requests.
     */
    @ConstructorBinding
    public static final class DefaultsProperties {

        /** Default parse mode (HTML, MarkdownV2). */
        private final ParseMode parseMode;

        /** Whether to protect content from forwarding. */
        private final boolean protectContent;

        /** Whether to enable link previews. */
        private final boolean linkPreview;

        /**
         * Creates the default bot properties.
         *
         * @param parseMode      default parse mode (HTML, MarkdownV2)
         * @param protectContent whether to protect content from forwarding
         * @param linkPreview    whether to enable link previews
         */
        public DefaultsProperties(
                ParseMode parseMode,
                @DefaultValue("false") boolean protectContent,
                @DefaultValue("true") boolean linkPreview) {
            this.parseMode = parseMode;
            this.protectContent = protectContent;
            this.linkPreview = linkPreview;
        }

        /** @return the default parse mode */
        public ParseMode parseMode() {
            return parseMode;
        }

        /** @return whether to protect content from forwarding */
        public boolean protectContent() {
            return protectContent;
        }

        /** @return whether to enable link previews */
        public boolean linkPreview() {
            return linkPreview;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DefaultsProperties)) {
                return false;
            }
            DefaultsProperties that = (DefaultsProperties) other;
            return Objects.equals(parseMode, that.parseMode)
                && protectContent == that.protectContent
                && linkPreview == that.linkPreview;
        }

        @Override
        public int hashCode() {
            return Objects.hash(parseMode, protectContent, linkPreview);
        }

        @Override
        public String toString() {
            return "DefaultsProperties[parseMode=" + parseMode + ", protectContent=" + protectContent
                + ", linkPreview=" + linkPreview + "]";
        }
    }

    /**
     * FSM configuration properties.
     */
    @ConstructorBinding
    public static final class FsmProperties {

        /** Whether FSM support is enabled. */
        private final boolean enabled;

        /** The FSM key resolution strategy. */
        private final FSMStrategy strategy;

        /** The storage backend type (memory, redis). */
        private final String storage;

        /** Settings of the Redis storage. */
        private final RedisProperties redis;

        /**
         * Creates the FSM properties.
         *
         * @param enabled  whether FSM support is enabled
         * @param strategy the FSM key resolution strategy
         * @param storage  the storage backend type (memory, redis)
         * @param redis    settings of the Redis storage
         */
        public FsmProperties(
                @DefaultValue("true") boolean enabled,
                @DefaultValue("USER_IN_CHAT") FSMStrategy strategy,
                @DefaultValue("memory") String storage,
                @DefaultValue RedisProperties redis) {
            this.enabled = enabled;
            this.strategy = strategy;
            this.storage = storage;
            this.redis = redis;
        }

        /** @return whether FSM support is enabled */
        public boolean enabled() {
            return enabled;
        }

        /** @return the FSM key resolution strategy */
        public FSMStrategy strategy() {
            return strategy;
        }

        /** @return the storage backend type (memory, redis) */
        public String storage() {
            return storage;
        }

        /** @return the settings of the Redis storage */
        public RedisProperties redis() {
            return redis;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FsmProperties)) {
                return false;
            }
            FsmProperties that = (FsmProperties) other;
            return enabled == that.enabled
                && Objects.equals(strategy, that.strategy)
                && Objects.equals(storage, that.storage)
                && Objects.equals(redis, that.redis);
        }

        @Override
        public int hashCode() {
            return Objects.hash(enabled, strategy, storage, redis);
        }

        @Override
        public String toString() {
            return "FsmProperties[enabled=" + enabled + ", strategy=" + strategy + ", storage=" + storage
                + ", redis=" + redis + "]";
        }
    }

    /**
     * Redis FSM storage settings, used when {@code telegram.fsm.storage=redis}.
     */
    @ConstructorBinding
    public static final class RedisProperties {

        /** First segment(s) of every key. */
        private final String keyPrefix;

        /** How long a state lives after it last changed; unset for no expiry. */
        private final Duration stateTtl;

        /** How long data lives after it last changed; unset for no expiry. */
        private final Duration dataTtl;

        /**
         * Creates the Redis storage settings.
         *
         * @param keyPrefix first segment(s) of every key
         * @param stateTtl  how long a state lives after it last changed; unset for no expiry
         * @param dataTtl   how long data lives after it last changed; unset for no expiry
         */
        public RedisProperties(
                @DefaultValue("jiogram:fsm") String keyPrefix,
                Duration stateTtl,
                Duration dataTtl) {
            this.keyPrefix = keyPrefix;
            this.stateTtl = stateTtl;
            this.dataTtl = dataTtl;
        }

        /** @return the first segment(s) of every key */
        public String keyPrefix() {
            return keyPrefix;
        }

        /** @return how long a state lives after it last changed, or {@code null} for no expiry */
        public Duration stateTtl() {
            return stateTtl;
        }

        /** @return how long data lives after it last changed, or {@code null} for no expiry */
        public Duration dataTtl() {
            return dataTtl;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RedisProperties)) {
                return false;
            }
            RedisProperties that = (RedisProperties) other;
            return Objects.equals(keyPrefix, that.keyPrefix)
                && Objects.equals(stateTtl, that.stateTtl)
                && Objects.equals(dataTtl, that.dataTtl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(keyPrefix, stateTtl, dataTtl);
        }

        @Override
        public String toString() {
            return "RedisProperties[keyPrefix=" + keyPrefix + ", stateTtl=" + stateTtl + ", dataTtl=" + dataTtl + "]";
        }
    }

    /**
     * Handler execution configuration.
     */
    @ConstructorBinding
    public static final class HandlersProperties {

        /**
         * Whether annotated handler methods run off the thread that delivered the update (on
         * virtual threads on Java 21+, else on a bounded elastic pool), so they may block; when
         * false they run on the thread that delivered the update.
         */
        private final boolean virtualThreads;

        /**
         * Creates the handler execution properties.
         *
         * @param virtualThreads whether annotated handler methods run on virtual threads (Java 21+)
         *                       or a bounded elastic pool (older Java), so they may block; when
         *                       false they run on the thread that delivered the update
         */
        public HandlersProperties(@DefaultValue("true") boolean virtualThreads) {
            this.virtualThreads = virtualThreads;
        }

        /** @return whether annotated handler methods run off the delivering thread */
        public boolean virtualThreads() {
            return virtualThreads;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HandlersProperties)) {
                return false;
            }
            HandlersProperties that = (HandlersProperties) other;
            return virtualThreads == that.virtualThreads;
        }

        @Override
        public int hashCode() {
            return Objects.hash(virtualThreads);
        }

        @Override
        public String toString() {
            return "HandlersProperties[virtualThreads=" + virtualThreads + "]";
        }
    }
}
