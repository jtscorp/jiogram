package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetStickerSetThumbnail(
    @JsonProperty("name") String name,
    @JsonProperty("user_id") long userId,
    @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
    @JsonProperty("format") String format
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerSetThumbnail";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetStickerSetThumbnail of(String name, long userId, String format) {
        return new SetStickerSetThumbnail(name, userId, null, format);
    }
}
