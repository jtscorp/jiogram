package io.jiogram.autoconfigure;

import io.jiogram.fsm.FSMStrategy;
import io.jiogram.types.ParseMode;
import io.jiogram.types.UpdateType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

/**
 * Configuration properties for the Jiogram Telegram bot framework.
 * Bind to the {@code telegram} prefix in application.yml / application.properties.
 */
@ConfigurationProperties(prefix = "telegram")
public record JiogramProperties(
    /** The bot API token (required). */
    String token,

    /** The operating mode: POLLING or WEBHOOK. Defaults to POLLING. */
    @DefaultValue("POLLING") Mode mode,

    /** Polling configuration. */
    @DefaultValue PollingProperties polling,

    /** Webhook configuration. */
    @DefaultValue WebhookProperties webhook,

    /** Telegram Bot API endpoint configuration. */
    @DefaultValue ApiProperties api,

    /** Default bot properties applied to outgoing requests. */
    @DefaultValue DefaultsProperties defaults,

    /** FSM (Finite State Machine) configuration. */
    @DefaultValue FsmProperties fsm,

    /** Handler execution configuration. */
    @DefaultValue HandlersProperties handlers
) {

    public enum Mode {
        POLLING,
        WEBHOOK
    }

    /**
     * Polling configuration properties.
     *
     * @param timeout        long-polling timeout in seconds
     * @param backoff        backoff delay in milliseconds on error
     * @param limit          maximum number of updates per poll
     * @param allowedUpdates list of update types to receive
     * @param concurrency    how many chats of one batch are processed in parallel; updates of
     *                       the same chat are always processed one after another, in order
     */
    public record PollingProperties(
        @DefaultValue("30") int timeout,
        @DefaultValue("1000") long backoff,
        @DefaultValue("100") int limit,
        List<UpdateType> allowedUpdates,
        @DefaultValue("32") int concurrency
    ) {}

    /**
     * Webhook configuration properties.
     *
     * @param url            the public URL where Telegram sends updates
     * @param path           the local endpoint path
     * @param secretToken    the secret token for request validation
     * @param maxConnections maximum concurrent webhook connections
     */
    public record WebhookProperties(
        String url,
        @DefaultValue("/bot/webhook") String path,
        String secretToken,
        @DefaultValue("40") int maxConnections
    ) {}

    /**
     * Telegram Bot API endpoint configuration.
     *
     * @param baseUrl base URL of the Bot API server
     */
    public record ApiProperties(
        @DefaultValue("https://api.telegram.org") String baseUrl
    ) {}

    /**
     * Default properties applied to all outgoing bot requests.
     *
     * @param parseMode      default parse mode (HTML, MarkdownV2)
     * @param protectContent whether to protect content from forwarding
     * @param linkPreview    whether to enable link previews
     */
    public record DefaultsProperties(
        ParseMode parseMode,
        @DefaultValue("false") boolean protectContent,
        @DefaultValue("true") boolean linkPreview
    ) {}

    /**
     * FSM configuration properties.
     *
     * @param enabled  whether FSM support is enabled
     * @param strategy the FSM key resolution strategy
     * @param storage  the storage backend type (memory, redis)
     */
    public record FsmProperties(
        @DefaultValue("true") boolean enabled,
        @DefaultValue("USER_IN_CHAT") FSMStrategy strategy,
        @DefaultValue("memory") String storage
    ) {}

    /**
     * Handler execution configuration.
     *
     * @param virtualThreads whether annotated handler methods run on virtual threads (so they may
     *                       block); when false they run on the thread that delivered the update
     */
    public record HandlersProperties(
        @DefaultValue("true") boolean virtualThreads
    ) {}
}
