package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object describes the position on faces where a mask should be placed by default.
 *
 * @see <a href="https://core.telegram.org/bots/api#maskposition">MaskPosition in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MaskPosition {

    @JsonProperty("point")
    private final String point;

    @JsonProperty("x_shift")
    private final double xShift;

    @JsonProperty("y_shift")
    private final double yShift;

    @JsonProperty("scale")
    private final double scale;

    /**
     * Creates a new {@code MaskPosition} instance.
     *
     * @param point The part of the face relative to which the mask should be placed. One of
     *     'forehead', 'eyes', 'mouth', or 'chin'.
     * @param xShift Shift by X-axis measured in widths of the mask scaled to the face size, from
     *     left to right. For example, choosing -1.0 will place mask just to the left of the default
     *     mask position.
     * @param yShift Shift by Y-axis measured in heights of the mask scaled to the face size, from
     *     top to bottom. For example, 1.0 will place the mask just below the default mask position.
     * @param scale Mask scaling coefficient. For example, 2.0 means double size.
     */
    @JsonCreator
    public MaskPosition(
            @JsonProperty("point") String point,
            @JsonProperty("x_shift") double xShift,
            @JsonProperty("y_shift") double yShift,
            @JsonProperty("scale") double scale) {
        this.point = point;
        this.xShift = xShift;
        this.yShift = yShift;
        this.scale = scale;
    }

    /**
     * The part of the face relative to which the mask should be placed. One of 'forehead', 'eyes',
     * 'mouth', or 'chin'.
     */
    public String point() {
        return point;
    }

    /**
     * Shift by X-axis measured in widths of the mask scaled to the face size, from left to right.
     * For example, choosing -1.0 will place mask just to the left of the default mask position.
     */
    public double xShift() {
        return xShift;
    }

    /**
     * Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom.
     * For example, 1.0 will place the mask just below the default mask position.
     */
    public double yShift() {
        return yShift;
    }

    /**
     * Mask scaling coefficient. For example, 2.0 means double size.
     */
    public double scale() {
        return scale;
    }

    public MaskPosition withPoint(String point) {
        return new MaskPosition(point, xShift, yShift, scale);
    }

    public MaskPosition withXShift(double xShift) {
        return new MaskPosition(point, xShift, yShift, scale);
    }

    public MaskPosition withYShift(double yShift) {
        return new MaskPosition(point, xShift, yShift, scale);
    }

    public MaskPosition withScale(double scale) {
        return new MaskPosition(point, xShift, yShift, scale);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MaskPosition)) {
            return false;
        }
        MaskPosition that = (MaskPosition) o;
        return Objects.equals(this.point, that.point)
                && Double.compare(this.xShift, that.xShift) == 0
                && Double.compare(this.yShift, that.yShift) == 0
                && Double.compare(this.scale, that.scale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.point, this.xShift, this.yShift, this.scale);
    }

    @Override
    public String toString() {
        return "MaskPosition[point=" + this.point
                + ", xShift=" + this.xShift
                + ", yShift=" + this.yShift
                + ", scale=" + this.scale
                + "]";
    }
}
