package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

public class BusinessIntro {
    @JsonProperty("title") @Nullable private final String title;
    @JsonProperty("message") @Nullable private final String message;
    @JsonProperty("sticker") @Nullable private final Sticker sticker;

    @JsonCreator
    public BusinessIntro(
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("message") @Nullable String message,
            @JsonProperty("sticker") @Nullable Sticker sticker
    ) {
        this.title = title;
        this.message = message;
        this.sticker = sticker;
    }

    public String title() {
        return this.title;
    }

    public String message() {
        return this.message;
    }

    public Sticker sticker() {
        return this.sticker;
    }
}
