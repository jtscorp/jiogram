package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotShortDescription(
    @JsonProperty("short_description") String shortDescription
) {}
