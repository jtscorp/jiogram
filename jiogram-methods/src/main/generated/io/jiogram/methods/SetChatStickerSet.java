package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record SetChatStickerSet(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("sticker_set_name") String stickerSetName
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
