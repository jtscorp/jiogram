package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BackgroundTypeChatTheme.class, name = "chat_theme"),
    @JsonSubTypes.Type(value = BackgroundTypeFill.class, name = "fill"),
    @JsonSubTypes.Type(value = BackgroundTypePattern.class, name = "pattern"),
    @JsonSubTypes.Type(value = BackgroundTypeWallpaper.class, name = "wallpaper")
})
public interface BackgroundType {}
