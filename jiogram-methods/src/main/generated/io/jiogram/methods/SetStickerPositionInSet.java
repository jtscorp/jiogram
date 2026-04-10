package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class SetStickerPositionInSet implements TelegramMethod<Boolean> {
    @JsonProperty("sticker") private final String sticker;
    @JsonProperty("position") private final long position;

    @JsonCreator
    public SetStickerPositionInSet(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("position") long position
    ) {
        this.sticker = sticker;
        this.position = position;
    }

    public String sticker() {
        return this.sticker;
    }

    public long position() {
        return this.position;
    }

    @Override
    public String apiMethod() {
        return "setStickerPositionInSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
