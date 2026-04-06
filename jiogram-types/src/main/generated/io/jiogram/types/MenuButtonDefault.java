package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MenuButtonDefault(
    @JsonProperty("type") String type
) implements MenuButton {}
