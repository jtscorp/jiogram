package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;

public class AddStickerToSet implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("name") private final String name;
    @JsonProperty("sticker") private final InputSticker sticker;

    @JsonCreator
    public AddStickerToSet(
            @JsonProperty("user_id") long userId,
            @JsonProperty("name") String name,
            @JsonProperty("sticker") InputSticker sticker
    ) {
        this.userId = userId;
        this.name = name;
        this.sticker = sticker;
    }

    public long userId() {
        return this.userId;
    }

    public String name() {
        return this.name;
    }

    public InputSticker sticker() {
        return this.sticker;
    }

    @Override
    public String apiMethod() {
        return "addStickerToSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
