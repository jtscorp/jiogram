package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

public record BusinessIntro(
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("message") @Nullable String message,
    @JsonProperty("sticker") @Nullable Sticker sticker
) {}
