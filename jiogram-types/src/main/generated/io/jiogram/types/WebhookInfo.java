package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UpdateType;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes the current status of a webhook.
 *
 * @see <a href="https://core.telegram.org/bots/api#webhookinfo">WebhookInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class WebhookInfo {

    @JsonProperty("url")
    private final String url;

    @JsonProperty("has_custom_certificate")
    private final boolean hasCustomCertificate;

    @JsonProperty("pending_update_count")
    private final long pendingUpdateCount;

    @JsonProperty("ip_address")
    private final @Nullable String ipAddress;

    @JsonProperty("last_error_date")
    private final @Nullable Long lastErrorDate;

    @JsonProperty("last_error_message")
    private final @Nullable String lastErrorMessage;

    @JsonProperty("last_synchronization_error_date")
    private final @Nullable Long lastSynchronizationErrorDate;

    @JsonProperty("max_connections")
    private final @Nullable Long maxConnections;

    @JsonProperty("allowed_updates")
    private final @Nullable List<UpdateType> allowedUpdates;

    /**
     * Creates a new {@code WebhookInfo} instance.
     *
     * @param url Webhook URL, may be empty if webhook is not set up
     * @param hasCustomCertificate True, if a custom certificate was provided for webhook
     *     certificate checks
     * @param pendingUpdateCount Number of updates awaiting delivery
     * @param ipAddress Currently used webhook IP address
     * @param lastErrorDate Unix time for the most recent error that happened when trying to deliver
     *     an update via webhook
     * @param lastErrorMessage Error message in human-readable format for the most recent error that
     *     happened when trying to deliver an update via webhook
     * @param lastSynchronizationErrorDate Unix time of the most recent error that happened when
     *     trying to synchronize available updates with Telegram datacenters
     * @param maxConnections The maximum allowed number of simultaneous HTTPS connections to the
     *     webhook for update delivery
     * @param allowedUpdates A list of update types the bot is subscribed to. Defaults to all update
     *     types except chat_member
     */
    @JsonCreator
    public WebhookInfo(
            @JsonProperty("url") String url,
            @JsonProperty("has_custom_certificate") boolean hasCustomCertificate,
            @JsonProperty("pending_update_count") long pendingUpdateCount,
            @JsonProperty("ip_address") @Nullable String ipAddress,
            @JsonProperty("last_error_date") @Nullable Long lastErrorDate,
            @JsonProperty("last_error_message") @Nullable String lastErrorMessage,
            @JsonProperty("last_synchronization_error_date") @Nullable Long lastSynchronizationErrorDate,
            @JsonProperty("max_connections") @Nullable Long maxConnections,
            @JsonProperty("allowed_updates") @Nullable List<UpdateType> allowedUpdates) {
        this.url = url;
        this.hasCustomCertificate = hasCustomCertificate;
        this.pendingUpdateCount = pendingUpdateCount;
        this.ipAddress = ipAddress;
        this.lastErrorDate = lastErrorDate;
        this.lastErrorMessage = lastErrorMessage;
        this.lastSynchronizationErrorDate = lastSynchronizationErrorDate;
        this.maxConnections = maxConnections;
        this.allowedUpdates = allowedUpdates;
    }

    public static WebhookInfo of(String url, boolean hasCustomCertificate, long pendingUpdateCount) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, null, null, null, null, null, null);
    }

    /**
     * Webhook URL, may be empty if webhook is not set up
     */
    public String url() {
        return url;
    }

    /**
     * True, if a custom certificate was provided for webhook certificate checks
     */
    public boolean hasCustomCertificate() {
        return hasCustomCertificate;
    }

    /**
     * Number of updates awaiting delivery
     */
    public long pendingUpdateCount() {
        return pendingUpdateCount;
    }

    /**
     * Currently used webhook IP address
     */
    public @Nullable String ipAddress() {
        return ipAddress;
    }

    /**
     * Unix time for the most recent error that happened when trying to deliver an update via
     * webhook
     */
    public @Nullable Long lastErrorDate() {
        return lastErrorDate;
    }

    /**
     * Error message in human-readable format for the most recent error that happened when trying to
     * deliver an update via webhook
     */
    public @Nullable String lastErrorMessage() {
        return lastErrorMessage;
    }

    /**
     * Unix time of the most recent error that happened when trying to synchronize available updates
     * with Telegram datacenters
     */
    public @Nullable Long lastSynchronizationErrorDate() {
        return lastSynchronizationErrorDate;
    }

    /**
     * The maximum allowed number of simultaneous HTTPS connections to the webhook for update
     * delivery
     */
    public @Nullable Long maxConnections() {
        return maxConnections;
    }

    /**
     * A list of update types the bot is subscribed to. Defaults to all update types except
     * chat_member
     */
    public @Nullable List<UpdateType> allowedUpdates() {
        return allowedUpdates;
    }

    public WebhookInfo withUrl(String url) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    public WebhookInfo withHasCustomCertificate(boolean hasCustomCertificate) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    public WebhookInfo withPendingUpdateCount(long pendingUpdateCount) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    public WebhookInfo withIpAddress(@Nullable String ipAddress) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    public WebhookInfo withLastErrorDate(@Nullable Long lastErrorDate) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    public WebhookInfo withLastErrorMessage(@Nullable String lastErrorMessage) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    public WebhookInfo withLastSynchronizationErrorDate(@Nullable Long lastSynchronizationErrorDate) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    public WebhookInfo withMaxConnections(@Nullable Long maxConnections) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    public WebhookInfo withAllowedUpdates(@Nullable List<UpdateType> allowedUpdates) {
        return new WebhookInfo(url, hasCustomCertificate, pendingUpdateCount, ipAddress, lastErrorDate, lastErrorMessage, lastSynchronizationErrorDate, maxConnections, allowedUpdates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WebhookInfo)) {
            return false;
        }
        WebhookInfo that = (WebhookInfo) o;
        return Objects.equals(this.url, that.url)
                && this.hasCustomCertificate == that.hasCustomCertificate
                && this.pendingUpdateCount == that.pendingUpdateCount
                && Objects.equals(this.ipAddress, that.ipAddress)
                && Objects.equals(this.lastErrorDate, that.lastErrorDate)
                && Objects.equals(this.lastErrorMessage, that.lastErrorMessage)
                && Objects.equals(this.lastSynchronizationErrorDate, that.lastSynchronizationErrorDate)
                && Objects.equals(this.maxConnections, that.maxConnections)
                && Objects.equals(this.allowedUpdates, that.allowedUpdates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.hasCustomCertificate, this.pendingUpdateCount, this.ipAddress, this.lastErrorDate, this.lastErrorMessage, this.lastSynchronizationErrorDate, this.maxConnections, this.allowedUpdates);
    }

    @Override
    public String toString() {
        return "WebhookInfo[url=" + this.url
                + ", hasCustomCertificate=" + this.hasCustomCertificate
                + ", pendingUpdateCount=" + this.pendingUpdateCount
                + ", ipAddress=" + this.ipAddress
                + ", lastErrorDate=" + this.lastErrorDate
                + ", lastErrorMessage=" + this.lastErrorMessage
                + ", lastSynchronizationErrorDate=" + this.lastSynchronizationErrorDate
                + ", maxConnections=" + this.maxConnections
                + ", allowedUpdates=" + this.allowedUpdates
                + "]";
    }
}
