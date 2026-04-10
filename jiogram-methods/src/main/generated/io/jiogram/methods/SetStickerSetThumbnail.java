package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetStickerSetThumbnail implements TelegramMethod<Boolean> {
    @JsonProperty("name") private final String name;
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("thumbnail") @Nullable private final InputFileOrString thumbnail;
    @JsonProperty("format") private final String format;

    @JsonCreator
    public SetStickerSetThumbnail(
            @JsonProperty("name") String name,
            @JsonProperty("user_id") long userId,
            @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
            @JsonProperty("format") String format
    ) {
        this.name = name;
        this.userId = userId;
        this.thumbnail = thumbnail;
        this.format = format;
    }

    public String name() {
        return this.name;
    }

    public long userId() {
        return this.userId;
    }

    public InputFileOrString thumbnail() {
        return this.thumbnail;
    }

    public String format() {
        return this.format;
    }

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
