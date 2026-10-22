package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UpdateType;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes the current status of a webhook.
 *
 * @param url Webhook URL, may be empty if webhook is not set up
 * @param hasCustomCertificate True, if a custom certificate was provided for webhook certificate
 *     checks
 * @param pendingUpdateCount Number of updates awaiting delivery
 * @param ipAddress Currently used webhook IP address
 * @param lastErrorDate Unix time for the most recent error that happened when trying to deliver an
 *     update via webhook
 * @param lastErrorMessage Error message in human-readable format for the most recent error that
 *     happened when trying to deliver an update via webhook
 * @param lastSynchronizationErrorDate Unix time of the most recent error that happened when trying
 *     to synchronize available updates with Telegram datacenters
 * @param maxConnections The maximum allowed number of simultaneous HTTPS connections to the webhook
 *     for update delivery
 * @param allowedUpdates A list of update types the bot is subscribed to. Defaults to all update
 *     types except chat_member
 * @see <a href="https://core.telegram.org/bots/api#webhookinfo">WebhookInfo in the Bot API</a>
 */
public record WebhookInfo(
    @JsonProperty("url") String url,
    @JsonProperty("has_custom_certificate") boolean hasCustomCertificate,
    @JsonProperty("pending_update_count") long pendingUpdateCount,
    @JsonProperty("ip_address") @Nullable String ipAddress,
    @JsonProperty("last_error_date") @Nullable Long lastErrorDate,
    @JsonProperty("last_error_message") @Nullable String lastErrorMessage,
    @JsonProperty("last_synchronization_error_date") @Nullable Long lastSynchronizationErrorDate,
    @JsonProperty("max_connections") @Nullable Long maxConnections,
    @JsonProperty("allowed_updates") @Nullable List<UpdateType> allowedUpdates
) {

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
}
