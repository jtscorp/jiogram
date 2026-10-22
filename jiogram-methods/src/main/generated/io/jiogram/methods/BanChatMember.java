package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups
 * and channels, the user will not be able to return to the chat on their own using invite links,
 * etc., unless unbanned first. The bot must be an administrator in the chat for this to work and
 * must have the appropriate administrator rights. Returns True on success.
 *
 * @param chatId Unique identifier for the target group or username of the target supergroup or
 *     channel (in the format &#64;channelusername)
 * @param userId Unique identifier of the target user
 * @param untilDate Date when the user will be unbanned; Unix time. If user is banned for more than
 *     366 days or less than 30 seconds from the current time they are considered to be banned
 *     forever. Applied for supergroups and channels only.
 * @param revokeMessages Pass True to delete all messages from the chat for the user that is being
 *     removed. If False, the user will be able to see messages in the group that were sent before
 *     the user was removed. Always True for supergroups and channels.
 * @see <a href="https://core.telegram.org/bots/api#banchatmember">banChatMember in the Bot API</a>
 */
public record BanChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("until_date") @Nullable Long untilDate,
    @JsonProperty("revoke_messages") @Nullable Boolean revokeMessages
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "banChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static BanChatMember of(ChatId chatId, long userId) {
        return new BanChatMember(chatId, userId, null, null);
    }
}
