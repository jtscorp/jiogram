package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard.
 * If the button that originated the query was attached to a message sent by the bot, the field
 * message will be present. If the button was attached to a message sent via the bot (in inline
 * mode), the field inline_message_id will be present. Exactly one of the fields data or
 * game_short_name will be present.
 * <br>NOTE: After the user presses a callback button, Telegram clients will display a progress bar
 * until you call answerCallbackQuery. It is, therefore, necessary to react by calling
 * answerCallbackQuery even if no notification to the user is needed (e.g., without specifying any
 * of the optional parameters).
 *
 * @param id Unique identifier for this query
 * @param from Sender
 * @param message Message sent by the bot with the callback button that originated the query
 * @param inlineMessageId Identifier of the message sent via the bot in inline mode, that originated
 *     the query.
 * @param chatInstance Global identifier, uniquely corresponding to the chat to which the message
 *     with the callback button was sent. Useful for high scores in games.
 * @param data Data associated with the callback button. Be aware that the message originated the
 *     query can contain no callback buttons with this data.
 * @param gameShortName Short name of a Game to be returned, serves as the unique identifier for the
 *     game
 * @see <a href="https://core.telegram.org/bots/api#callbackquery">CallbackQuery in the Bot API</a>
 */
public record CallbackQuery(
    @JsonProperty("id") String id,
    @JsonProperty("from") User from,
    @JsonProperty("message") @Nullable MaybeInaccessibleMessage message,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("chat_instance") String chatInstance,
    @JsonProperty("data") @Nullable String data,
    @JsonProperty("game_short_name") @Nullable String gameShortName
) {

    public static CallbackQuery of(String id, User from, String chatInstance) {
        return new CallbackQuery(id, from, null, null, chatInstance, null, null);
    }

    public CallbackQuery withId(String id) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withFrom(User from) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withMessage(@Nullable MaybeInaccessibleMessage message) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withInlineMessageId(@Nullable String inlineMessageId) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withChatInstance(String chatInstance) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withData(@Nullable String data) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }

    public CallbackQuery withGameShortName(@Nullable String gameShortName) {
        return new CallbackQuery(id, from, message, inlineMessageId, chatInstance, data, gameShortName);
    }
}
