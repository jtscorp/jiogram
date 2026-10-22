package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the type of a background. Currently, it can be one of
 * <br>- BackgroundTypeFill
 * <br>- BackgroundTypeWallpaper
 * <br>- BackgroundTypePattern
 * <br>- BackgroundTypeChatTheme
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundtype">BackgroundType in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = BackgroundTypeUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BackgroundTypeChatTheme.class, name = "chat_theme"),
    @JsonSubTypes.Type(value = BackgroundTypeFill.class, name = "fill"),
    @JsonSubTypes.Type(value = BackgroundTypePattern.class, name = "pattern"),
    @JsonSubTypes.Type(value = BackgroundTypeWallpaper.class, name = "wallpaper")
})
public sealed interface BackgroundType permits BackgroundTypeChatTheme, BackgroundTypeFill, BackgroundTypePattern, BackgroundTypeWallpaper, BackgroundTypeUnknown {}
