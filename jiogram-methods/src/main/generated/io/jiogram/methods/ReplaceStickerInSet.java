package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;

public class ReplaceStickerInSet implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("name") private final String name;
    @JsonProperty("old_sticker") private final String oldSticker;
    @JsonProperty("sticker") private final InputSticker sticker;

    @JsonCreator
    public ReplaceStickerInSet(
            @JsonProperty("user_id") long userId,
            @JsonProperty("name") String name,
            @JsonProperty("old_sticker") String oldSticker,
            @JsonProperty("sticker") InputSticker sticker
    ) {
        this.userId = userId;
        this.name = name;
        this.oldSticker = oldSticker;
        this.sticker = sticker;
    }

    public long userId() {
        return this.userId;
    }

    public String name() {
        return this.name;
    }

    public String oldSticker() {
        return this.oldSticker;
    }

    public InputSticker sticker() {
        return this.sticker;
    }

    @Override
    public String apiMethod() {
        return "replaceStickerInSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
