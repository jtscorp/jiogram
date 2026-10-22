package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UpdateType;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever
 * there is an update for the bot, we will send an HTTPS POST request to the specified URL,
 * containing a JSON-serialized Update. In case of an unsuccessful request (a request with response
 * HTTP status code different from 2XY), we will repeat the request and give up after a reasonable
 * amount of attempts. Returns True on success.
 * <br>If you'd like to make sure that the webhook was set by you, you can specify secret data in
 * the parameter secret_token. If specified, the request will contain a header
 * 'X-Telegram-Bot-Api-Secret-Token' with the secret token as content.
 * <br>Notes
 * <br>1. You will not be able to receive updates using getUpdates for as long as an outgoing
 * webhook is set up.
 * <br>2. To use a self-signed certificate, you need to upload your public key certificate using
 * certificate parameter. Please upload as InputFile, sending a String will not work.
 * <br>3. Ports currently supported for webhooks: 443, 80, 88, 8443.
 * <br>If you're having any trouble setting up webhooks, please check out this amazing guide to
 * webhooks.
 *
 * @see <a href="https://core.telegram.org/bots/api#setwebhook">setWebhook in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetWebhook implements TelegramMethod<Boolean> {

    @JsonProperty("url")
    private final String url;

    @JsonProperty("certificate")
    private final @Nullable InputFile certificate;

    @JsonProperty("ip_address")
    private final @Nullable String ipAddress;

    @JsonProperty("max_connections")
    private final @Nullable Long maxConnections;

    @JsonProperty("allowed_updates")
    private final @Nullable List<UpdateType> allowedUpdates;

    @JsonProperty("drop_pending_updates")
    private final @Nullable Boolean dropPendingUpdates;

    @JsonProperty("secret_token")
    private final @Nullable String secretToken;

    /**
     * Creates a new {@code SetWebhook} instance.
     *
     * @param url HTTPS URL to send updates to. Use an empty string to remove webhook integration
     * @param certificate Upload your public key certificate so that the root certificate in use can
     *     be checked. See our self-signed guide for details.
     * @param ipAddress The fixed IP address which will be used to send webhook requests instead of
     *     the IP address resolved through DNS
     * @param maxConnections The maximum allowed number of simultaneous HTTPS connections to the
     *     webhook for update delivery, 1-100. Defaults to 40. Use lower values to limit the load on
     *     your bot's server, and higher values to increase your bot's throughput.
     * @param allowedUpdates A JSON-serialized list of the update types you want your bot to
     *     receive. For example, specify ["message", "edited_channel_post", "callback_query"] to
     *     only receive updates of these types. See Update for a complete list of available update
     *     types. Specify an empty list to receive all update types except chat_member,
     *     message_reaction, and message_reaction_count (default). If not specified, the previous
     *     setting will be used. Please note that this parameter doesn't affect updates created
     *     before the call to the setWebhook, so unwanted updates may be received for a short period
     *     of time.
     * @param dropPendingUpdates Pass True to drop all pending updates
     * @param secretToken A secret token to be sent in a header 'X-Telegram-Bot-Api-Secret-Token' in
     *     every webhook request, 1-256 characters. Only characters A-Z, a-z, 0-9, _ and - are
     *     allowed. The header is useful to ensure that the request comes from a webhook set by you.
     */
    @JsonCreator
    public SetWebhook(
            @JsonProperty("url") String url,
            @JsonProperty("certificate") @Nullable InputFile certificate,
            @JsonProperty("ip_address") @Nullable String ipAddress,
            @JsonProperty("max_connections") @Nullable Long maxConnections,
            @JsonProperty("allowed_updates") @Nullable List<UpdateType> allowedUpdates,
            @JsonProperty("drop_pending_updates") @Nullable Boolean dropPendingUpdates,
            @JsonProperty("secret_token") @Nullable String secretToken) {
        this.url = url;
        this.certificate = certificate;
        this.ipAddress = ipAddress;
        this.maxConnections = maxConnections;
        this.allowedUpdates = allowedUpdates;
        this.dropPendingUpdates = dropPendingUpdates;
        this.secretToken = secretToken;
    }

    @Override
    public String apiMethod() {
        return "setWebhook";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetWebhook of(String url) {
        return new SetWebhook(url, null, null, null, null, null, null);
    }

    /**
     * HTTPS URL to send updates to. Use an empty string to remove webhook integration
     */
    public String url() {
        return url;
    }

    /**
     * Upload your public key certificate so that the root certificate in use can be checked. See
     * our self-signed guide for details.
     */
    public @Nullable InputFile certificate() {
        return certificate;
    }

    /**
     * The fixed IP address which will be used to send webhook requests instead of the IP address
     * resolved through DNS
     */
    public @Nullable String ipAddress() {
        return ipAddress;
    }

    /**
     * The maximum allowed number of simultaneous HTTPS connections to the webhook for update
     * delivery, 1-100. Defaults to 40. Use lower values to limit the load on your bot's server, and
     * higher values to increase your bot's throughput.
     */
    public @Nullable Long maxConnections() {
        return maxConnections;
    }

    /**
     * A JSON-serialized list of the update types you want your bot to receive. For example, specify
     * ["message", "edited_channel_post", "callback_query"] to only receive updates of these types.
     * See Update for a complete list of available update types. Specify an empty list to receive
     * all update types except chat_member, message_reaction, and message_reaction_count (default).
     * If not specified, the previous setting will be used. Please note that this parameter doesn't
     * affect updates created before the call to the setWebhook, so unwanted updates may be received
     * for a short period of time.
     */
    public @Nullable List<UpdateType> allowedUpdates() {
        return allowedUpdates;
    }

    /**
     * Pass True to drop all pending updates
     */
    public @Nullable Boolean dropPendingUpdates() {
        return dropPendingUpdates;
    }

    /**
     * A secret token to be sent in a header 'X-Telegram-Bot-Api-Secret-Token' in every webhook
     * request, 1-256 characters. Only characters A-Z, a-z, 0-9, _ and - are allowed. The header is
     * useful to ensure that the request comes from a webhook set by you.
     */
    public @Nullable String secretToken() {
        return secretToken;
    }

    public SetWebhook withUrl(String url) {
        return new SetWebhook(url, certificate, ipAddress, maxConnections, allowedUpdates, dropPendingUpdates, secretToken);
    }

    public SetWebhook withCertificate(@Nullable InputFile certificate) {
        return new SetWebhook(url, certificate, ipAddress, maxConnections, allowedUpdates, dropPendingUpdates, secretToken);
    }

    public SetWebhook withIpAddress(@Nullable String ipAddress) {
        return new SetWebhook(url, certificate, ipAddress, maxConnections, allowedUpdates, dropPendingUpdates, secretToken);
    }

    public SetWebhook withMaxConnections(@Nullable Long maxConnections) {
        return new SetWebhook(url, certificate, ipAddress, maxConnections, allowedUpdates, dropPendingUpdates, secretToken);
    }

    public SetWebhook withAllowedUpdates(@Nullable List<UpdateType> allowedUpdates) {
        return new SetWebhook(url, certificate, ipAddress, maxConnections, allowedUpdates, dropPendingUpdates, secretToken);
    }

    public SetWebhook withDropPendingUpdates(@Nullable Boolean dropPendingUpdates) {
        return new SetWebhook(url, certificate, ipAddress, maxConnections, allowedUpdates, dropPendingUpdates, secretToken);
    }

    public SetWebhook withSecretToken(@Nullable String secretToken) {
        return new SetWebhook(url, certificate, ipAddress, maxConnections, allowedUpdates, dropPendingUpdates, secretToken);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetWebhook)) {
            return false;
        }
        SetWebhook that = (SetWebhook) o;
        return Objects.equals(this.url, that.url)
                && Objects.equals(this.certificate, that.certificate)
                && Objects.equals(this.ipAddress, that.ipAddress)
                && Objects.equals(this.maxConnections, that.maxConnections)
                && Objects.equals(this.allowedUpdates, that.allowedUpdates)
                && Objects.equals(this.dropPendingUpdates, that.dropPendingUpdates)
                && Objects.equals(this.secretToken, that.secretToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.certificate, this.ipAddress, this.maxConnections, this.allowedUpdates, this.dropPendingUpdates, this.secretToken);
    }

    @Override
    public String toString() {
        return "SetWebhook[url=" + this.url
                + ", certificate=" + this.certificate
                + ", ipAddress=" + this.ipAddress
                + ", maxConnections=" + this.maxConnections
                + ", allowedUpdates=" + this.allowedUpdates
                + ", dropPendingUpdates=" + this.dropPendingUpdates
                + ", secretToken=" + this.secretToken
                + "]";
    }
}
