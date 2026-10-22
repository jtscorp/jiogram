package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.List;

/**
 * Use this method to delete multiple messages simultaneously. If some of the specified messages
 * can't be found, they are skipped. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageIds A JSON-serialized list of 1-100 identifiers of messages to delete. See
 *     deleteMessage for limitations on which messages can be deleted
 * @see <a href="https://core.telegram.org/bots/api#deletemessages">deleteMessages in the Bot API</a>
 */
public record DeleteMessages(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_ids") List<Long> messageIds
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
