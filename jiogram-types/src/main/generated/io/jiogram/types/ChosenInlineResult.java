package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Represents a result of an inline query that was chosen by the user and sent to their chat
 * partner.
 * <br>Note: It is necessary to enable inline feedback via &#64;BotFather in order to receive these
 * objects in updates.
 *
 * @param resultId The unique identifier for the result that was chosen
 * @param from The user that chose the result
 * @param location Sender location, only for bots that require user location
 * @param inlineMessageId Identifier of the sent inline message. Available only if there is an
 *     inline keyboard attached to the message. Will be also received in callback queries and can be
 *     used to edit the message.
 * @param query The query that was used to obtain the result
 * @see <a href="https://core.telegram.org/bots/api#choseninlineresult">ChosenInlineResult in the Bot API</a>
 */
public record ChosenInlineResult(
    @JsonProperty("result_id") String resultId,
    @JsonProperty("from") User from,
    @JsonProperty("location") @Nullable Location location,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("query") String query
) {

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
}
