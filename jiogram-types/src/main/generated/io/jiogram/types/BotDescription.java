package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotDescription(
    @JsonProperty("description") String description
) {}
