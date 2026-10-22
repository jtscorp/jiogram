package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;
import java.util.Objects;

/**
 * The background is a gradient fill.
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundfillgradient">BackgroundFillGradient in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BackgroundFillGradient implements BackgroundFill {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BackgroundFillType type;

    @JsonProperty("top_color")
    private final long topColor;

    @JsonProperty("bottom_color")
    private final long bottomColor;

    @JsonProperty("rotation_angle")
    private final long rotationAngle;

    /**
     * Creates a new {@code BackgroundFillGradient} instance.
     *
     * @param type Type of the background fill, always 'gradient'
     * @param topColor Top color of the gradient in the RGB24 format
     * @param bottomColor Bottom color of the gradient in the RGB24 format
     * @param rotationAngle Clockwise rotation angle of the background fill in degrees; 0-359
     */
    @JsonCreator
    public BackgroundFillGradient(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundFillType type,
            @JsonProperty("top_color") long topColor,
            @JsonProperty("bottom_color") long bottomColor,
            @JsonProperty("rotation_angle") long rotationAngle) {
        this.type = type;
        this.topColor = topColor;
        this.bottomColor = bottomColor;
        this.rotationAngle = rotationAngle;
    }

    public static BackgroundFillGradient of(long topColor, long bottomColor, long rotationAngle) {
        return new BackgroundFillGradient(BackgroundFillType.GRADIENT, topColor, bottomColor, rotationAngle);
    }

    /**
     * Type of the background fill, always 'gradient'
     */
    public BackgroundFillType type() {
        return type;
    }

    /**
     * Top color of the gradient in the RGB24 format
     */
    public long topColor() {
        return topColor;
    }

    /**
     * Bottom color of the gradient in the RGB24 format
     */
    public long bottomColor() {
        return bottomColor;
    }

    /**
     * Clockwise rotation angle of the background fill in degrees; 0-359
     */
    public long rotationAngle() {
        return rotationAngle;
    }

    public BackgroundFillGradient withTopColor(long topColor) {
        return new BackgroundFillGradient(type, topColor, bottomColor, rotationAngle);
    }

    public BackgroundFillGradient withBottomColor(long bottomColor) {
        return new BackgroundFillGradient(type, topColor, bottomColor, rotationAngle);
    }

    public BackgroundFillGradient withRotationAngle(long rotationAngle) {
        return new BackgroundFillGradient(type, topColor, bottomColor, rotationAngle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BackgroundFillGradient)) {
            return false;
        }
        BackgroundFillGradient that = (BackgroundFillGradient) o;
        return Objects.equals(this.type, that.type)
                && this.topColor == that.topColor
                && this.bottomColor == that.bottomColor
                && this.rotationAngle == that.rotationAngle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.topColor, this.bottomColor, this.rotationAngle);
    }

    @Override
    public String toString() {
        return "BackgroundFillGradient[type=" + this.type
                + ", topColor=" + this.topColor
                + ", bottomColor=" + this.bottomColor
                + ", rotationAngle=" + this.rotationAngle
                + "]";
    }
}
