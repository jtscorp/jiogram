package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to decline a chat join request. The bot must be an administrator in the chat for
 * this to work and must have the can_invite_users administrator right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#declinechatjoinrequest">declineChatJoinRequest in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeclineChatJoinRequest implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    /**
     * Creates a new {@code DeclineChatJoinRequest} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param userId Unique identifier of the target user
     */
    @JsonCreator
    public DeclineChatJoinRequest(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId) {
        this.chatId = chatId;
        this.userId = userId;
    }

    @Override
    public String apiMethod() {
        return "declineChatJoinRequest";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
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

    public DeclineChatJoinRequest withChatId(ChatId chatId) {
        return new DeclineChatJoinRequest(chatId, userId);
    }

    public DeclineChatJoinRequest withUserId(long userId) {
        return new DeclineChatJoinRequest(chatId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeclineChatJoinRequest)) {
            return false;
        }
        DeclineChatJoinRequest that = (DeclineChatJoinRequest) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId);
    }

    @Override
    public String toString() {
        return "DeclineChatJoinRequest[chatId=" + this.chatId
                + ", userId=" + this.userId
                + "]";
    }
}
