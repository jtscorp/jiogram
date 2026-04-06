package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record KeyboardButtonPollType(
    @JsonProperty("type") @Nullable String type
) {}
