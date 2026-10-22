package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the description of a group, a supergroup or a channel. The bot must be
 * an administrator in the chat for this to work and must have the appropriate administrator rights.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatdescription">setChatDescription in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetChatDescription implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("description")
    private final @Nullable String description;

    /**
     * Creates a new {@code SetChatDescription} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param description New chat description, 0-255 characters
     */
    @JsonCreator
    public SetChatDescription(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("description") @Nullable String description) {
        this.chatId = chatId;
        this.description = description;
    }

    @Override
    public String apiMethod() {
        return "setChatDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatDescription of(ChatId chatId) {
        return new SetChatDescription(chatId, null);
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * New chat description, 0-255 characters
     */
    public @Nullable String description() {
        return description;
    }

    public SetChatDescription withChatId(ChatId chatId) {
        return new SetChatDescription(chatId, description);
    }

    public SetChatDescription withDescription(@Nullable String description) {
        return new SetChatDescription(chatId, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetChatDescription)) {
            return false;
        }
        SetChatDescription that = (SetChatDescription) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.description);
    }

    @Override
    public String toString() {
        return "SetChatDescription[chatId=" + this.chatId
                + ", description=" + this.description
                + "]";
    }
}
