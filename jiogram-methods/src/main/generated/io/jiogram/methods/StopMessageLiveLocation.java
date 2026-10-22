package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to stop updating a live location message before live_period expires. On success,
 * if the message is not an inline message, the edited Message is returned, otherwise True is
 * returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message to be edited was sent
 * @param chatId Required if inline_message_id is not specified. Unique identifier for the target
 *     chat or username of the target channel (in the format &#64;channelusername)
 * @param messageId Required if inline_message_id is not specified. Identifier of the message with
 *     live location to stop
 * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of the
 *     inline message
 * @param replyMarkup A JSON-serialized object for a new inline keyboard.
 * @see <a href="https://core.telegram.org/bots/api#stopmessagelivelocation">stopMessageLiveLocation in the Bot API</a>
 */
public record StopMessageLiveLocation(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("message_id") @Nullable Long messageId,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "stopMessageLiveLocation";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static StopMessageLiveLocation of() {
        return new StopMessageLiveLocation(null, null, null, null, null);
    }
}
