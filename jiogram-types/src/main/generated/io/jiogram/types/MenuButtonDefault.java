package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButtonType;

public class MenuButtonDefault implements MenuButton {
    @JsonProperty("type") private final MenuButtonType type;

    @JsonCreator
    public MenuButtonDefault(
            @JsonProperty("type") MenuButtonType type
    ) {
        this.type = type;
    }

    public MenuButtonType type() {
        return this.type;
    }
}
