package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.UserChatBoosts;
import java.util.Objects;

/**
 * Use this method to get the list of boosts added to a chat by a user. Requires administrator
 * rights in the chat. Returns a UserChatBoosts object.
 *
 * @see <a href="https://core.telegram.org/bots/api#getuserchatboosts">getUserChatBoosts in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetUserChatBoosts implements TelegramMethod<UserChatBoosts> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    /**
     * Creates a new {@code GetUserChatBoosts} instance.
     *
     * @param chatId Unique identifier for the chat or username of the channel (in the format
     *     &#64;channelusername)
     * @param userId Unique identifier of the target user
     */
    @JsonCreator
    public GetUserChatBoosts(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId) {
        this.chatId = chatId;
        this.userId = userId;
    }

    @Override
    public String apiMethod() {
        return "getUserChatBoosts";
    }

    @Override
    public String apiReturnType() {
        return "UserChatBoosts";
    }

    /**
     * Unique identifier for the chat or username of the channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Unique identifier of the target user
     */
    public long userId() {
        return userId;
    }

    public GetUserChatBoosts withChatId(ChatId chatId) {
        return new GetUserChatBoosts(chatId, userId);
    }

    public GetUserChatBoosts withUserId(long userId) {
        return new GetUserChatBoosts(chatId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetUserChatBoosts)) {
            return false;
        }
        GetUserChatBoosts that = (GetUserChatBoosts) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId);
    }

    @Override
    public String toString() {
        return "GetUserChatBoosts[chatId=" + this.chatId
                + ", userId=" + this.userId
                + "]";
    }
}
