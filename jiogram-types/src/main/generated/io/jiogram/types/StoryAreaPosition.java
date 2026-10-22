package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes the position of a clickable area within a story.
 *
 * @see <a href="https://core.telegram.org/bots/api#storyareaposition">StoryAreaPosition in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StoryAreaPosition {

    @JsonProperty("x_percentage")
    private final double xPercentage;

    @JsonProperty("y_percentage")
    private final double yPercentage;

    @JsonProperty("width_percentage")
    private final double widthPercentage;

    @JsonProperty("height_percentage")
    private final double heightPercentage;

    @JsonProperty("rotation_angle")
    private final double rotationAngle;

    @JsonProperty("corner_radius_percentage")
    private final double cornerRadiusPercentage;

    /**
     * Creates a new {@code StoryAreaPosition} instance.
     *
     * @param xPercentage The abscissa of the area's center, as a percentage of the media width
     * @param yPercentage The ordinate of the area's center, as a percentage of the media height
     * @param widthPercentage The width of the area's rectangle, as a percentage of the media width
     * @param heightPercentage The height of the area's rectangle, as a percentage of the media
     *     height
     * @param rotationAngle The clockwise rotation angle of the rectangle, in degrees; 0-360
     * @param cornerRadiusPercentage The radius of the rectangle corner rounding, as a percentage of
     *     the media width
     */
    @JsonCreator
    public StoryAreaPosition(
            @JsonProperty("x_percentage") double xPercentage,
            @JsonProperty("y_percentage") double yPercentage,
            @JsonProperty("width_percentage") double widthPercentage,
            @JsonProperty("height_percentage") double heightPercentage,
            @JsonProperty("rotation_angle") double rotationAngle,
            @JsonProperty("corner_radius_percentage") double cornerRadiusPercentage) {
        this.xPercentage = xPercentage;
        this.yPercentage = yPercentage;
        this.widthPercentage = widthPercentage;
        this.heightPercentage = heightPercentage;
        this.rotationAngle = rotationAngle;
        this.cornerRadiusPercentage = cornerRadiusPercentage;
    }

    /**
     * The abscissa of the area's center, as a percentage of the media width
     */
    public double xPercentage() {
        return xPercentage;
    }

    /**
     * The ordinate of the area's center, as a percentage of the media height
     */
    public double yPercentage() {
        return yPercentage;
    }

    /**
     * The width of the area's rectangle, as a percentage of the media width
     */
    public double widthPercentage() {
        return widthPercentage;
    }

    /**
     * The height of the area's rectangle, as a percentage of the media height
     */
    public double heightPercentage() {
        return heightPercentage;
    }

    /**
     * The clockwise rotation angle of the rectangle, in degrees; 0-360
     */
    public double rotationAngle() {
        return rotationAngle;
    }

    /**
     * The radius of the rectangle corner rounding, as a percentage of the media width
     */
    public double cornerRadiusPercentage() {
        return cornerRadiusPercentage;
    }

    public StoryAreaPosition withXPercentage(double xPercentage) {
        return new StoryAreaPosition(xPercentage, yPercentage, widthPercentage, heightPercentage, rotationAngle, cornerRadiusPercentage);
    }

    public StoryAreaPosition withYPercentage(double yPercentage) {
        return new StoryAreaPosition(xPercentage, yPercentage, widthPercentage, heightPercentage, rotationAngle, cornerRadiusPercentage);
    }

    public StoryAreaPosition withWidthPercentage(double widthPercentage) {
        return new StoryAreaPosition(xPercentage, yPercentage, widthPercentage, heightPercentage, rotationAngle, cornerRadiusPercentage);
    }

    public StoryAreaPosition withHeightPercentage(double heightPercentage) {
        return new StoryAreaPosition(xPercentage, yPercentage, widthPercentage, heightPercentage, rotationAngle, cornerRadiusPercentage);
    }

    public StoryAreaPosition withRotationAngle(double rotationAngle) {
        return new StoryAreaPosition(xPercentage, yPercentage, widthPercentage, heightPercentage, rotationAngle, cornerRadiusPercentage);
    }

    public StoryAreaPosition withCornerRadiusPercentage(double cornerRadiusPercentage) {
        return new StoryAreaPosition(xPercentage, yPercentage, widthPercentage, heightPercentage, rotationAngle, cornerRadiusPercentage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoryAreaPosition)) {
            return false;
        }
        StoryAreaPosition that = (StoryAreaPosition) o;
        return Double.compare(this.xPercentage, that.xPercentage) == 0
                && Double.compare(this.yPercentage, that.yPercentage) == 0
                && Double.compare(this.widthPercentage, that.widthPercentage) == 0
                && Double.compare(this.heightPercentage, that.heightPercentage) == 0
                && Double.compare(this.rotationAngle, that.rotationAngle) == 0
                && Double.compare(this.cornerRadiusPercentage, that.cornerRadiusPercentage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.xPercentage, this.yPercentage, this.widthPercentage, this.heightPercentage, this.rotationAngle, this.cornerRadiusPercentage);
    }

    @Override
    public String toString() {
        return "StoryAreaPosition[xPercentage=" + this.xPercentage
                + ", yPercentage=" + this.yPercentage
                + ", widthPercentage=" + this.widthPercentage
                + ", heightPercentage=" + this.heightPercentage
                + ", rotationAngle=" + this.rotationAngle
                + ", cornerRadiusPercentage=" + this.cornerRadiusPercentage
                + "]";
    }
}
