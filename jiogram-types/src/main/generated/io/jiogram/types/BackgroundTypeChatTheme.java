package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundTypeType;

/**
 * The background is taken directly from a built-in chat theme.
 *
 * @param type Type of the background, always 'chat_theme'
 * @param themeName Name of the chat theme, which is usually an emoji
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypechattheme">BackgroundTypeChatTheme in the Bot API</a>
 */
public record BackgroundTypeChatTheme(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
    @JsonProperty("theme_name") String themeName
) implements BackgroundType {

    public static BackgroundTypeChatTheme of(String themeName) {
        return new BackgroundTypeChatTheme(BackgroundTypeType.CHAT_THEME, themeName);
    }

    public BackgroundTypeChatTheme withThemeName(String themeName) {
        return new BackgroundTypeChatTheme(type, themeName);
    }
}
