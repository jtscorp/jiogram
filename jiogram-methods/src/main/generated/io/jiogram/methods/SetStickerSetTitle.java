package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class SetStickerSetTitle implements TelegramMethod<Boolean> {
    @JsonProperty("name") private final String name;
    @JsonProperty("title") private final String title;

    @JsonCreator
    public SetStickerSetTitle(
            @JsonProperty("name") String name,
            @JsonProperty("title") String title
    ) {
        this.name = name;
        this.title = title;
    }

    public String name() {
        return this.name;
    }

    public String title() {
        return this.title;
    }

    @Override
    public String apiMethod() {
        return "setStickerSetTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
