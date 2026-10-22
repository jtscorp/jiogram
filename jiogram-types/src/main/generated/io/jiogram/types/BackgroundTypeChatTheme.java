package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundTypeType;
import java.util.Objects;

/**
 * The background is taken directly from a built-in chat theme.
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypechattheme">BackgroundTypeChatTheme in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BackgroundTypeChatTheme implements BackgroundType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BackgroundTypeType type;

    @JsonProperty("theme_name")
    private final String themeName;

    /**
     * Creates a new {@code BackgroundTypeChatTheme} instance.
     *
     * @param type Type of the background, always 'chat_theme'
     * @param themeName Name of the chat theme, which is usually an emoji
     */
    @JsonCreator
    public BackgroundTypeChatTheme(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
            @JsonProperty("theme_name") String themeName) {
        this.type = type;
        this.themeName = themeName;
    }

    public static BackgroundTypeChatTheme of(String themeName) {
        return new BackgroundTypeChatTheme(BackgroundTypeType.CHAT_THEME, themeName);
    }

    /**
     * Type of the background, always 'chat_theme'
     */
    public BackgroundTypeType type() {
        return type;
    }

    /**
     * Name of the chat theme, which is usually an emoji
     */
    public String themeName() {
        return themeName;
    }

    public BackgroundTypeChatTheme withThemeName(String themeName) {
        return new BackgroundTypeChatTheme(type, themeName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BackgroundTypeChatTheme)) {
            return false;
        }
        BackgroundTypeChatTheme that = (BackgroundTypeChatTheme) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.themeName, that.themeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.themeName);
    }

    @Override
    public String toString() {
        return "BackgroundTypeChatTheme[type=" + this.type
                + ", themeName=" + this.themeName
                + "]";
    }
}
