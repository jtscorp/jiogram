package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatMember;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to get information about a member of a chat. The method is only guaranteed to
 * work for other users if the bot is an administrator in the chat. Returns a ChatMember object on
 * success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getchatmember">getChatMember in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetChatMember implements TelegramMethod<ChatMember> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("user_id")
    private final long userId;

    /**
     * Creates a new {@code GetChatMember} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup or
     *     channel (in the format &#64;channelusername)
     * @param userId Unique identifier of the target user
     */
    @JsonCreator
    public GetChatMember(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId) {
        this.chatId = chatId;
        this.userId = userId;
    }

    @Override
    public String apiMethod() {
        return "getChatMember";
    }

    @Override
    public String apiReturnType() {
        return "ChatMember";
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel (in the
     * format &#64;channelusername)
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

    public GetChatMember withChatId(ChatId chatId) {
        return new GetChatMember(chatId, userId);
    }

    public GetChatMember withUserId(long userId) {
        return new GetChatMember(chatId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetChatMember)) {
            return false;
        }
        GetChatMember that = (GetChatMember) o;
        return Objects.equals(this.chatId, that.chatId)
                && this.userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.userId);
    }

    @Override
    public String toString() {
        return "GetChatMember[chatId=" + this.chatId
                + ", userId=" + this.userId
                + "]";
    }
}
