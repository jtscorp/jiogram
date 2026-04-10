package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class DeleteStickerSet implements TelegramMethod<Boolean> {
    @JsonProperty("name") private final String name;

    @JsonCreator
    public DeleteStickerSet(
            @JsonProperty("name") String name
    ) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String apiMethod() {
        return "deleteStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
