package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BackgroundTypeChatTheme(
    @JsonProperty("type") String type,
    @JsonProperty("theme_name") String themeName
) implements BackgroundType {}
