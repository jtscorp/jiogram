package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class SetChatStickerSet implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("sticker_set_name") private final String stickerSetName;

    @JsonCreator
    public SetChatStickerSet(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("sticker_set_name") String stickerSetName
    ) {
        this.chatId = chatId;
        this.stickerSetName = stickerSetName;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String stickerSetName() {
        return this.stickerSetName;
    }

    @Override
    public String apiMethod() {
        return "setChatStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
