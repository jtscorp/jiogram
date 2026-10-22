package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object describes the position on faces where a mask should be placed by default.
 *
 * @param point The part of the face relative to which the mask should be placed. One of 'forehead',
 *     'eyes', 'mouth', or 'chin'.
 * @param xShift Shift by X-axis measured in widths of the mask scaled to the face size, from left
 *     to right. For example, choosing -1.0 will place mask just to the left of the default mask
 *     position.
 * @param yShift Shift by Y-axis measured in heights of the mask scaled to the face size, from top
 *     to bottom. For example, 1.0 will place the mask just below the default mask position.
 * @param scale Mask scaling coefficient. For example, 2.0 means double size.
 * @see <a href="https://core.telegram.org/bots/api#maskposition">MaskPosition in the Bot API</a>
 */
public record MaskPosition(
    @JsonProperty("point") String point,
    @JsonProperty("x_shift") double xShift,
    @JsonProperty("y_shift") double yShift,
    @JsonProperty("scale") double scale
) {

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
}
