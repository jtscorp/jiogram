package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to unban a previously banned user in a supergroup or channel. The user will not
 * return to the group or channel automatically, but will be able to join via link, etc. The bot
 * must be an administrator for this to work. By default, this method guarantees that after the call
 * the user is not a member of the chat, but will be able to join it. So if the user is a member of
 * the chat they will also be removed from the chat. If you don't want this, use the parameter
 * only_if_banned. Returns True on success.
 *
 * @param chatId Unique identifier for the target group or username of the target supergroup or
 *     channel (in the format &#64;channelusername)
 * @param userId Unique identifier of the target user
 * @param onlyIfBanned Do nothing if the user is not banned
 * @see <a href="https://core.telegram.org/bots/api#unbanchatmember">unbanChatMember in the Bot API</a>
 */
public record UnbanChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("only_if_banned") @Nullable Boolean onlyIfBanned
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unbanChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static UnbanChatMember of(ChatId chatId, long userId) {
        return new UnbanChatMember(chatId, userId, null);
    }
}
