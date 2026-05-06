package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundTypeType;

public record BackgroundTypeChatTheme(
    @JsonProperty("type") BackgroundTypeType type,
    @JsonProperty("theme_name") String themeName
) implements BackgroundType {}
