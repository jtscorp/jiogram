package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetCustomEmojiStickerSetThumbnail implements TelegramMethod<Boolean> {
    @JsonProperty("name") private final String name;
    @JsonProperty("custom_emoji_id") @Nullable private final String customEmojiId;

    @JsonCreator
    public SetCustomEmojiStickerSetThumbnail(
            @JsonProperty("name") String name,
            @JsonProperty("custom_emoji_id") @Nullable String customEmojiId
    ) {
        this.name = name;
        this.customEmojiId = customEmojiId;
    }

    public String name() {
        return this.name;
    }

    public String customEmojiId() {
        return this.customEmojiId;
    }

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
