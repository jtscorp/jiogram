package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to set a new profile photo for the chat. Photos can't be changed for private
 * chats. The bot must be an administrator in the chat for this to work and must have the
 * appropriate administrator rights. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatphoto">setChatPhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetChatPhoto implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("photo")
    private final InputFile photo;

    /**
     * Creates a new {@code SetChatPhoto} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param photo New chat photo, uploaded using multipart/form-data
     */
    @JsonCreator
    public SetChatPhoto(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("photo") InputFile photo) {
        this.chatId = chatId;
        this.photo = photo;
    }

    @Override
    public String apiMethod() {
        return "setChatPhoto";
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
     * New chat photo, uploaded using multipart/form-data
     */
    public InputFile photo() {
        return photo;
    }

    public SetChatPhoto withChatId(ChatId chatId) {
        return new SetChatPhoto(chatId, photo);
    }

    public SetChatPhoto withPhoto(InputFile photo) {
        return new SetChatPhoto(chatId, photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetChatPhoto)) {
            return false;
        }
        SetChatPhoto that = (SetChatPhoto) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.photo);
    }

    @Override
    public String toString() {
        return "SetChatPhoto[chatId=" + this.chatId
                + ", photo=" + this.photo
                + "]";
    }
}
