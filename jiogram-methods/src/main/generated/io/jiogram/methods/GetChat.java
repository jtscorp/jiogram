package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatFullInfo;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to get up-to-date information about the chat. Returns a ChatFullInfo object on
 * success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup or
 *     channel (in the format &#64;channelusername)
 * @see <a href="https://core.telegram.org/bots/api#getchat">getChat in the Bot API</a>
 */
public record GetChat(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<ChatFullInfo> {

    @Override
    public String apiMethod() {
        return "getChat";
    }

    @Override
    public String apiReturnType() {
        return "ChatFullInfo";
    }
}
