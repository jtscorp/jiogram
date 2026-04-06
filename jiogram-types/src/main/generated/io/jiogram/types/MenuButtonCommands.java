package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MenuButtonCommands(
    @JsonProperty("type") String type
) implements MenuButton {}
