package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatMember;
import io.jiogram.types.TelegramMethod;
import java.util.List;

/**
 * Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of
 * ChatMember objects.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup or
 *     channel (in the format &#64;channelusername)
 * @see <a href="https://core.telegram.org/bots/api#getchatadministrators">getChatAdministrators in the Bot API</a>
 */
public record GetChatAdministrators(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<List<ChatMember>> {

    @Override
    public String apiMethod() {
        return "getChatAdministrators";
    }

    @Override
    public String apiReturnType() {
        return "Array of ChatMember";
    }
}
