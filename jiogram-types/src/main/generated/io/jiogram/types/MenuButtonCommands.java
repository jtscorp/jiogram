package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;

public record MenuButtonCommands(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MenuButtonType type
) implements MenuButton {}
