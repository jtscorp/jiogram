package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a result of an inline query that was chosen by the user and sent to their chat
 * partner.
 * <br>Note: It is necessary to enable inline feedback via &#64;BotFather in order to receive these
 * objects in updates.
 *
 * @see <a href="https://core.telegram.org/bots/api#choseninlineresult">ChosenInlineResult in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChosenInlineResult {

    @JsonProperty("result_id")
    private final String resultId;

    @JsonProperty("from")
    private final User from;

    @JsonProperty("location")
    private final @Nullable Location location;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    @JsonProperty("query")
    private final String query;

    /**
     * Creates a new {@code ChosenInlineResult} instance.
     *
     * @param resultId The unique identifier for the result that was chosen
     * @param from The user that chose the result
     * @param location Sender location, only for bots that require user location
     * @param inlineMessageId Identifier of the sent inline message. Available only if there is an
     *     inline keyboard attached to the message. Will be also received in callback queries and
     *     can be used to edit the message.
     * @param query The query that was used to obtain the result
     */
    @JsonCreator
    public ChosenInlineResult(
            @JsonProperty("result_id") String resultId,
            @JsonProperty("from") User from,
            @JsonProperty("location") @Nullable Location location,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("query") String query) {
        this.resultId = resultId;
        this.from = from;
        this.location = location;
        this.inlineMessageId = inlineMessageId;
        this.query = query;
    }

    public static ChosenInlineResult of(String resultId, User from, String query) {
        return new ChosenInlineResult(resultId, from, null, null, query);
    }

    /**
     * The unique identifier for the result that was chosen
     */
    public String resultId() {
        return resultId;
    }

    /**
     * The user that chose the result
     */
    public User from() {
        return from;
    }

    /**
     * Sender location, only for bots that require user location
     */
    public @Nullable Location location() {
        return location;
    }

    /**
     * Identifier of the sent inline message. Available only if there is an inline keyboard attached
     * to the message. Will be also received in callback queries and can be used to edit the
     * message.
     */
    public @Nullable String inlineMessageId() {
        return inlineMessageId;
    }

    /**
     * The query that was used to obtain the result
     */
    public String query() {
        return query;
    }

    public ChosenInlineResult withResultId(String resultId) {
        return new ChosenInlineResult(resultId, from, location, inlineMessageId, query);
    }

    public ChosenInlineResult withFrom(User from) {
        return new ChosenInlineResult(resultId, from, location, inlineMessageId, query);
    }

    public ChosenInlineResult withLocation(@Nullable Location location) {
        return new ChosenInlineResult(resultId, from, location, inlineMessageId, query);
    }

    public ChosenInlineResult withInlineMessageId(@Nullable String inlineMessageId) {
        return new ChosenInlineResult(resultId, from, location, inlineMessageId, query);
    }

    public ChosenInlineResult withQuery(String query) {
        return new ChosenInlineResult(resultId, from, location, inlineMessageId, query);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChosenInlineResult)) {
            return false;
        }
        ChosenInlineResult that = (ChosenInlineResult) o;
        return Objects.equals(this.resultId, that.resultId)
                && Objects.equals(this.from, that.from)
                && Objects.equals(this.location, that.location)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId)
                && Objects.equals(this.query, that.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.resultId, this.from, this.location, this.inlineMessageId, this.query);
    }

    @Override
    public String toString() {
        return "ChosenInlineResult[resultId=" + this.resultId
                + ", from=" + this.from
                + ", location=" + this.location
                + ", inlineMessageId=" + this.inlineMessageId
                + ", query=" + this.query
                + "]";
    }
}
