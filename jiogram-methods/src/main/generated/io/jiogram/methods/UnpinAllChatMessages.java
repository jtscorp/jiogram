package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to clear the list of pinned messages in a chat. In private chats and channel
 * direct messages chats, no additional rights are required to unpin all pinned messages.
 * Conversely, the bot must be an administrator with the 'can_pin_messages' right or the
 * 'can_edit_messages' right to unpin all pinned messages in groups and channels respectively.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#unpinallchatmessages">unpinAllChatMessages in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UnpinAllChatMessages implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code UnpinAllChatMessages} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     */
    @JsonCreator
    public UnpinAllChatMessages(
            @JsonProperty("chat_id") ChatId chatId) {
        this.chatId = chatId;
    }

    @Override
    public String apiMethod() {
        return "unpinAllChatMessages";
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

    public UnpinAllChatMessages withChatId(ChatId chatId) {
        return new UnpinAllChatMessages(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UnpinAllChatMessages)) {
            return false;
        }
        UnpinAllChatMessages that = (UnpinAllChatMessages) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "UnpinAllChatMessages[chatId=" + this.chatId
                + "]";
    }
}
