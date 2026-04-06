package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetCustomEmojiStickerSetThumbnail(
    @JsonProperty("name") String name,
    @JsonProperty("custom_emoji_id") @Nullable String customEmojiId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setCustomEmojiStickerSetThumbnail";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetCustomEmojiStickerSetThumbnail of(String name) {
        return new SetCustomEmojiStickerSetThumbnail(name, null);
    }
}
