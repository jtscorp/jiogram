package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;

/**
 * The background is filled using the selected color.
 *
 * @param type Type of the background fill, always 'solid'
 * @param color The color of the background fill in the RGB24 format
 * @see <a href="https://core.telegram.org/bots/api#backgroundfillsolid">BackgroundFillSolid in the Bot API</a>
 */
public record BackgroundFillSolid(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundFillType type,
    @JsonProperty("color") long color
) implements BackgroundFill {

    public static BackgroundFillSolid of(long color) {
        return new BackgroundFillSolid(BackgroundFillType.SOLID, color);
    }

    public BackgroundFillSolid withColor(long color) {
        return new BackgroundFillSolid(type, color);
    }
}
