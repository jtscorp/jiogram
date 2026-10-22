package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatFullInfo;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to get up-to-date information about the chat. Returns a ChatFullInfo object on
 * success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getchat">getChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetChat implements TelegramMethod<ChatFullInfo> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code GetChat} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup or
     *     channel (in the format &#64;channelusername)
     */
    @JsonCreator
    public GetChat(
            @JsonProperty("chat_id") ChatId chatId) {
        this.chatId = chatId;
    }

    @Override
    public String apiMethod() {
        return "getChat";
    }

    @Override
    public String apiReturnType() {
        return "ChatFullInfo";
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup or channel (in the
     * format &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    public GetChat withChatId(ChatId chatId) {
        return new GetChat(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetChat)) {
            return false;
        }
        GetChat that = (GetChat) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "GetChat[chatId=" + this.chatId
                + "]";
    }
}
