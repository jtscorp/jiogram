package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes the position of a clickable area within a story.
 *
 * @param xPercentage The abscissa of the area's center, as a percentage of the media width
 * @param yPercentage The ordinate of the area's center, as a percentage of the media height
 * @param widthPercentage The width of the area's rectangle, as a percentage of the media width
 * @param heightPercentage The height of the area's rectangle, as a percentage of the media height
 * @param rotationAngle The clockwise rotation angle of the rectangle, in degrees; 0-360
 * @param cornerRadiusPercentage The radius of the rectangle corner rounding, as a percentage of the
 *     media width
 * @see <a href="https://core.telegram.org/bots/api#storyareaposition">StoryAreaPosition in the Bot API</a>
 */
public record StoryAreaPosition(
    @JsonProperty("x_percentage") double xPercentage,
    @JsonProperty("y_percentage") double yPercentage,
    @JsonProperty("width_percentage") double widthPercentage,
    @JsonProperty("height_percentage") double heightPercentage,
    @JsonProperty("rotation_angle") double rotationAngle,
    @JsonProperty("corner_radius_percentage") double cornerRadiusPercentage
) {}
