package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to get the number of members in a chat. Returns Int on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getchatmembercount">getChatMemberCount in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetChatMemberCount implements TelegramMethod<Long> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code GetChatMemberCount} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup or
     *     channel (in the format &#64;channelusername)
     */
    @JsonCreator
    public GetChatMemberCount(
            @JsonProperty("chat_id") ChatId chatId) {
        this.chatId = chatId;
    }

    @Override
    public String apiMethod() {
        return "getChatMemberCount";
    }

    @Override
    public String apiReturnType() {
        return "Int";
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel (in the
     * format &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    public GetChatMemberCount withChatId(ChatId chatId) {
        return new GetChatMemberCount(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetChatMemberCount)) {
            return false;
        }
        GetChatMemberCount that = (GetChatMemberCount) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "GetChatMemberCount[chatId=" + this.chatId
                + "]";
    }
}
