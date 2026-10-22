package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to delete a group sticker set from a supergroup. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. Use the field
 * can_set_sticker_set optionally returned in getChat requests to check if the bot can use this
 * method. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletechatstickerset">deleteChatStickerSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteChatStickerSet implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    /**
     * Creates a new {@code DeleteChatStickerSet} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     */
    @JsonCreator
    public DeleteChatStickerSet(
            @JsonProperty("chat_id") ChatId chatId) {
        this.chatId = chatId;
    }

    @Override
    public String apiMethod() {
        return "deleteChatStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format
     * &#64;supergroupusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    public DeleteChatStickerSet withChatId(ChatId chatId) {
        return new DeleteChatStickerSet(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteChatStickerSet)) {
            return false;
        }
        DeleteChatStickerSet that = (DeleteChatStickerSet) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "DeleteChatStickerSet[chatId=" + this.chatId
                + "]";
    }
}
