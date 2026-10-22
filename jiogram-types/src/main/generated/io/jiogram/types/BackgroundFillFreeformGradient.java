package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;
import java.util.List;

/**
 * The background is a freeform gradient that rotates after every message in the chat.
 *
 * @param type Type of the background fill, always 'freeform_gradient'
 * @param colors A list of the 3 or 4 base colors that are used to generate the freeform gradient in
 *     the RGB24 format
 * @see <a href="https://core.telegram.org/bots/api#backgroundfillfreeformgradient">BackgroundFillFreeformGradient in the Bot API</a>
 */
public record BackgroundFillFreeformGradient(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundFillType type,
    @JsonProperty("colors") List<Long> colors
) implements BackgroundFill {

    public static BackgroundFillFreeformGradient of(List<Long> colors) {
        return new BackgroundFillFreeformGradient(BackgroundFillType.FREEFORM_GRADIENT, colors);
    }

    public BackgroundFillFreeformGradient withColors(List<Long> colors) {
        return new BackgroundFillFreeformGradient(type, colors);
    }
}
