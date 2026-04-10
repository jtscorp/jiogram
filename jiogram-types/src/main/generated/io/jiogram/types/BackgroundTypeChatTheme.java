package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BackgroundTypeChatTheme implements BackgroundType {
    @JsonProperty("type") private final String type;
    @JsonProperty("theme_name") private final String themeName;

    @JsonCreator
    public BackgroundTypeChatTheme(
            @JsonProperty("type") String type,
            @JsonProperty("theme_name") String themeName
    ) {
        this.type = type;
        this.themeName = themeName;
    }

    public String type() {
        return this.type;
    }

    public String themeName() {
        return this.themeName;
    }
}
