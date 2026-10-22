package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import io.jiogram.types.UpdateType;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to receive incoming updates using long polling (wiki). Returns an Array of Update
 * objects.
 * <br>Notes
 * <br>1. This method will not work if an outgoing webhook is set up.
 * <br>2. In order to avoid getting duplicate updates, recalculate offset after each server
 * response.
 *
 * @see <a href="https://core.telegram.org/bots/api#getupdates">getUpdates in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetUpdates implements TelegramMethod<List<Update>> {

    @JsonProperty("offset")
    private final @Nullable Long offset;

    @JsonProperty("limit")
    private final @Nullable Long limit;

    @JsonProperty("timeout")
    private final @Nullable Long timeout;

    @JsonProperty("allowed_updates")
    private final @Nullable List<UpdateType> allowedUpdates;

    /**
     * Creates a new {@code GetUpdates} instance.
     *
     * @param offset Identifier of the first update to be returned. Must be greater by one than the
     *     highest among the identifiers of previously received updates. By default, updates
     *     starting with the earliest unconfirmed update are returned. An update is considered
     *     confirmed as soon as getUpdates is called with an offset higher than its update_id. The
     *     negative offset can be specified to retrieve updates starting from -offset update from
     *     the end of the updates queue. All previous updates will be forgotten.
     * @param limit Limits the number of updates to be retrieved. Values between 1-100 are accepted.
     *     Defaults to 100.
     * @param timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling.
     *     Should be positive, short polling should be used for testing purposes only.
     * @param allowedUpdates A JSON-serialized list of the update types you want your bot to
     *     receive. For example, specify ["message", "edited_channel_post", "callback_query"] to
     *     only receive updates of these types. See Update for a complete list of available update
     *     types. Specify an empty list to receive all update types except chat_member,
     *     message_reaction, and message_reaction_count (default). If not specified, the previous
     *     setting will be used. Please note that this parameter doesn't affect updates created
     *     before the call to getUpdates, so unwanted updates may be received for a short period of
     *     time.
     */
    @JsonCreator
    public GetUpdates(
            @JsonProperty("offset") @Nullable Long offset,
            @JsonProperty("limit") @Nullable Long limit,
            @JsonProperty("timeout") @Nullable Long timeout,
            @JsonProperty("allowed_updates") @Nullable List<UpdateType> allowedUpdates) {
        this.offset = offset;
        this.limit = limit;
        this.timeout = timeout;
        this.allowedUpdates = allowedUpdates;
    }

    @Override
    public String apiMethod() {
        return "getUpdates";
    }

    @Override
    public String apiReturnType() {
        return "Array of Update";
    }

    public static GetUpdates of() {
        return new GetUpdates(null, null, null, null);
    }

    /**
     * Identifier of the first update to be returned. Must be greater by one than the highest among
     * the identifiers of previously received updates. By default, updates starting with the
     * earliest unconfirmed update are returned. An update is considered confirmed as soon as
     * getUpdates is called with an offset higher than its update_id. The negative offset can be
     * specified to retrieve updates starting from -offset update from the end of the updates queue.
     * All previous updates will be forgotten.
     */
    public @Nullable Long offset() {
        return offset;
    }

    /**
     * Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to
     * 100.
     */
    public @Nullable Long limit() {
        return limit;
    }

    /**
     * Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be
     * positive, short polling should be used for testing purposes only.
     */
    public @Nullable Long timeout() {
        return timeout;
    }

    /**
     * A JSON-serialized list of the update types you want your bot to receive. For example, specify
     * ["message", "edited_channel_post", "callback_query"] to only receive updates of these types.
     * See Update for a complete list of available update types. Specify an empty list to receive
     * all update types except chat_member, message_reaction, and message_reaction_count (default).
     * If not specified, the previous setting will be used. Please note that this parameter doesn't
     * affect updates created before the call to getUpdates, so unwanted updates may be received for
     * a short period of time.
     */
    public @Nullable List<UpdateType> allowedUpdates() {
        return allowedUpdates;
    }

    public GetUpdates withOffset(@Nullable Long offset) {
        return new GetUpdates(offset, limit, timeout, allowedUpdates);
    }

    public GetUpdates withLimit(@Nullable Long limit) {
        return new GetUpdates(offset, limit, timeout, allowedUpdates);
    }

    public GetUpdates withTimeout(@Nullable Long timeout) {
        return new GetUpdates(offset, limit, timeout, allowedUpdates);
    }

    public GetUpdates withAllowedUpdates(@Nullable List<UpdateType> allowedUpdates) {
        return new GetUpdates(offset, limit, timeout, allowedUpdates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetUpdates)) {
            return false;
        }
        GetUpdates that = (GetUpdates) o;
        return Objects.equals(this.offset, that.offset)
                && Objects.equals(this.limit, that.limit)
                && Objects.equals(this.timeout, that.timeout)
                && Objects.equals(this.allowedUpdates, that.allowedUpdates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.offset, this.limit, this.timeout, this.allowedUpdates);
    }

    @Override
    public String toString() {
        return "GetUpdates[offset=" + this.offset
                + ", limit=" + this.limit
                + ", timeout=" + this.timeout
                + ", allowedUpdates=" + this.allowedUpdates
                + "]";
    }
}
