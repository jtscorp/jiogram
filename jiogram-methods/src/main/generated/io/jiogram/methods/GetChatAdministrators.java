package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatMember;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;

/**
 * Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of
 * ChatMember objects.
 *
 * @see <a href="https://core.telegram.org/bots/api#getchatadministrators">getChatAdministrators in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetChatAdministrators implements TelegramMethod<List<ChatMember>> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code GetChatAdministrators} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup or
     *     channel (in the format &#64;channelusername)
     */
    @JsonCreator
    public GetChatAdministrators(
            @JsonProperty("chat_id") ChatId chatId) {
        this.chatId = chatId;
    }

    @Override
    public String apiMethod() {
        return "getChatAdministrators";
    }

    @Override
    public String apiReturnType() {
        return "Array of ChatMember";
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel (in the
     * format &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    public GetChatAdministrators withChatId(ChatId chatId) {
        return new GetChatAdministrators(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetChatAdministrators)) {
            return false;
        }
        GetChatAdministrators that = (GetChatAdministrators) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "GetChatAdministrators[chatId=" + this.chatId
                + "]";
    }
}
