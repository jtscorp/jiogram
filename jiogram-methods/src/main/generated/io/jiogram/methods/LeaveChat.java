package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method for your bot to leave a group, supergroup or channel. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup or
 *     channel (in the format &#64;channelusername). Channel direct messages chats aren't supported;
 *     leave the corresponding channel instead.
 * @see <a href="https://core.telegram.org/bots/api#leavechat">leaveChat in the Bot API</a>
 */
public record LeaveChat(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "leaveChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
