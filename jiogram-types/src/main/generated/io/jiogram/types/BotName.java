package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotName(
    @JsonProperty("name") String name
) {}
