package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StickerSet;
import io.jiogram.types.TelegramMethod;

public class GetStickerSet implements TelegramMethod<StickerSet> {
    @JsonProperty("name") private final String name;

    @JsonCreator
    public GetStickerSet(
            @JsonProperty("name") String name
    ) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String apiMethod() {
        return "getStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "StickerSet";
    }
}
