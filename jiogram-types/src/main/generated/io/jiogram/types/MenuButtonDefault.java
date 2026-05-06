package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;

public record MenuButtonDefault(
    @JsonProperty("type") MenuButtonType type
) implements MenuButton {}
