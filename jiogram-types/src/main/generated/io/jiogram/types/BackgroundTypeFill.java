package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;
import io.jiogram.types.BackgroundTypeType;

/**
 * The background is automatically filled based on the selected colors.
 *
 * @param type Type of the background, always 'fill'
 * @param fill The background fill
 * @param darkThemeDimming Dimming of the background in dark themes, as a percentage; 0-100
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypefill">BackgroundTypeFill in the Bot API</a>
 */
public record BackgroundTypeFill(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
    @JsonProperty("fill") BackgroundFill fill,
    @JsonProperty("dark_theme_dimming") long darkThemeDimming
) implements BackgroundType {

    public BackgroundTypeFill withFill(BackgroundFill fill) {
        return new BackgroundTypeFill(type, fill, darkThemeDimming);
    }

    public BackgroundTypeFill withDarkThemeDimming(long darkThemeDimming) {
        return new BackgroundTypeFill(type, fill, darkThemeDimming);
    }
}
