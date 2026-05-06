package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PollType;
import org.jspecify.annotations.Nullable;

public record KeyboardButtonPollType(
    @JsonProperty("type") @Nullable PollType type
) {}
