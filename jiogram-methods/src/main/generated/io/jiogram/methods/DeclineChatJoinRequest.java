package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to decline a chat join request. The bot must be an administrator in the chat for
 * this to work and must have the can_invite_users administrator right. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param userId Unique identifier of the target user
 * @see <a href="https://core.telegram.org/bots/api#declinechatjoinrequest">declineChatJoinRequest in the Bot API</a>
 */
public record DeclineChatJoinRequest(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "declineChatJoinRequest";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
