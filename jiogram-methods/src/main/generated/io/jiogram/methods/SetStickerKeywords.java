package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record SetStickerKeywords(
    @JsonProperty("sticker") String sticker,
    @JsonProperty("keywords") @Nullable List<String> keywords
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerKeywords";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetStickerKeywords of(String sticker) {
        return new SetStickerKeywords(sticker, null);
    }
}
