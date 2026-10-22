package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. Use the field
 * can_set_sticker_set optionally returned in getChat requests to check if the bot can use this
 * method. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatstickerset">setChatStickerSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetChatStickerSet implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("sticker_set_name")
    private final String stickerSetName;

    /**
     * Creates a new {@code SetChatStickerSet} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in
     *     the format &#64;supergroupusername)
     * @param stickerSetName Name of the sticker set to be set as the group sticker set
     */
    @JsonCreator
    public SetChatStickerSet(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("sticker_set_name") String stickerSetName) {
        this.chatId = chatId;
        this.stickerSetName = stickerSetName;
    }

    @Override
    public String apiMethod() {
        return "setChatStickerSet";
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

    /**
     * Name of the sticker set to be set as the group sticker set
     */
    public String stickerSetName() {
        return stickerSetName;
    }

    public SetChatStickerSet withChatId(ChatId chatId) {
        return new SetChatStickerSet(chatId, stickerSetName);
    }

    public SetChatStickerSet withStickerSetName(String stickerSetName) {
        return new SetChatStickerSet(chatId, stickerSetName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetChatStickerSet)) {
            return false;
        }
        SetChatStickerSet that = (SetChatStickerSet) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.stickerSetName, that.stickerSetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.stickerSetName);
    }

    @Override
    public String toString() {
        return "SetChatStickerSet[chatId=" + this.chatId
                + ", stickerSetName=" + this.stickerSetName
                + "]";
    }
}
