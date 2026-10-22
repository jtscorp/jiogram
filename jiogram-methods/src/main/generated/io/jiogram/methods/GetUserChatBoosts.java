package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserChatBoosts;

/**
 * Use this method to get the list of boosts added to a chat by a user. Requires administrator
 * rights in the chat. Returns a UserChatBoosts object.
 *
 * @param chatId Unique identifier for the chat or username of the channel (in the format
 *     &#64;channelusername)
 * @param userId Unique identifier of the target user
 * @see <a href="https://core.telegram.org/bots/api#getuserchatboosts">getUserChatBoosts in the Bot API</a>
 */
public record GetUserChatBoosts(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId
) implements TelegramMethod<UserChatBoosts> {

    @Override
    public String apiMethod() {
        return "getUserChatBoosts";
    }

    @Override
    public String apiReturnType() {
        return "UserChatBoosts";
    }

    public GetUserChatBoosts withChatId(ChatId chatId) {
        return new GetUserChatBoosts(chatId, userId);
    }

    public GetUserChatBoosts withUserId(long userId) {
        return new GetUserChatBoosts(chatId, userId);
    }
}
