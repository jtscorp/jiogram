package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;

/**
 * The background is a gradient fill.
 *
 * @param type Type of the background fill, always 'gradient'
 * @param topColor Top color of the gradient in the RGB24 format
 * @param bottomColor Bottom color of the gradient in the RGB24 format
 * @param rotationAngle Clockwise rotation angle of the background fill in degrees; 0-359
 * @see <a href="https://core.telegram.org/bots/api#backgroundfillgradient">BackgroundFillGradient in the Bot API</a>
 */
public record BackgroundFillGradient(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundFillType type,
    @JsonProperty("top_color") long topColor,
    @JsonProperty("bottom_color") long bottomColor,
    @JsonProperty("rotation_angle") long rotationAngle
) implements BackgroundFill {}
