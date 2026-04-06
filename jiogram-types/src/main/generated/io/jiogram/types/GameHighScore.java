package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record GameHighScore(
    @JsonProperty("position") long position,
    @JsonProperty("user") User user,
    @JsonProperty("score") long score
) {}
