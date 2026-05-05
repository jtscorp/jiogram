package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundTypeType;

public class BackgroundTypeChatTheme implements BackgroundType {
    @JsonProperty("type") private final BackgroundTypeType type;
    @JsonProperty("theme_name") private final String themeName;

    @JsonCreator
    public BackgroundTypeChatTheme(
            @JsonProperty("type") BackgroundTypeType type,
            @JsonProperty("theme_name") String themeName
    ) {
        this.type = type;
        this.themeName = themeName;
    }

    public BackgroundTypeType type() {
        return this.type;
    }

    public String themeName() {
        return this.themeName;
    }
}
