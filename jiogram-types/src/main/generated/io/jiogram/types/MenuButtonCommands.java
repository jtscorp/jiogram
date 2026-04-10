package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuButtonCommands implements MenuButton {
    @JsonProperty("type") private final String type;

    @JsonCreator
    public MenuButtonCommands(
            @JsonProperty("type") String type
    ) {
        this.type = type;
    }

    public String type() {
        return this.type;
    }
}
