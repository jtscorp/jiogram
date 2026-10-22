package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot
 * must be an administrator in the chat for this to work and must have the appropriate administrator
 * rights. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchattitle">setChatTitle in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetChatTitle implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("title")
    private final String title;

    /**
     * Creates a new {@code SetChatTitle} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param title New chat title, 1-128 characters
     */
    @JsonCreator
    public SetChatTitle(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("title") String title) {
        this.chatId = chatId;
        this.title = title;
    }

    @Override
    public String apiMethod() {
        return "setChatTitle";
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
     * New chat title, 1-128 characters
     */
    public String title() {
        return title;
    }

    public SetChatTitle withChatId(ChatId chatId) {
        return new SetChatTitle(chatId, title);
    }

    public SetChatTitle withTitle(String title) {
        return new SetChatTitle(chatId, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetChatTitle)) {
            return false;
        }
        SetChatTitle that = (SetChatTitle) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.title);
    }

    @Override
    public String toString() {
        return "SetChatTitle[chatId=" + this.chatId
                + ", title=" + this.title
                + "]";
    }
}
