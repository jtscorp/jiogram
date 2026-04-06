package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record SetStickerSetTitle(
    @JsonProperty("name") String name,
    @JsonProperty("title") String title
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerSetTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
