package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SetStickerKeywords implements TelegramMethod<Boolean> {
    @JsonProperty("sticker") private final String sticker;
    @JsonProperty("keywords") @Nullable private final List<String> keywords;

    @JsonCreator
    public SetStickerKeywords(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("keywords") @Nullable List<String> keywords
    ) {
        this.sticker = sticker;
        this.keywords = keywords;
    }

    public String sticker() {
        return this.sticker;
    }

    public List<String> keywords() {
        return this.keywords;
    }

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
