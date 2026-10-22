package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Poll;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to stop a poll which was sent by the bot. On success, the stopped Poll is
 * returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message to be edited was sent
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageId Identifier of the original message with the poll
 * @param replyMarkup A JSON-serialized object for a new message inline keyboard.
 * @see <a href="https://core.telegram.org/bots/api#stoppoll">stopPoll in the Bot API</a>
 */
public record StopPoll(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Poll> {

    @Override
    public String apiMethod() {
        return "stopPoll";
    }

    @Override
    public String apiReturnType() {
        return "Poll";
    }

    public static StopPoll of(ChatId chatId, long messageId) {
        return new StopPoll(null, chatId, messageId, null);
    }
}
