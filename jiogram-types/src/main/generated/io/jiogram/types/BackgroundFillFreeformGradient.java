package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;
import java.util.List;
import java.util.Objects;

/**
 * The background is a freeform gradient that rotates after every message in the chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundfillfreeformgradient">BackgroundFillFreeformGradient in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BackgroundFillFreeformGradient implements BackgroundFill {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BackgroundFillType type;

    @JsonProperty("colors")
    private final List<Long> colors;

    /**
     * Creates a new {@code BackgroundFillFreeformGradient} instance.
     *
     * @param type Type of the background fill, always 'freeform_gradient'
     * @param colors A list of the 3 or 4 base colors that are used to generate the freeform
     *     gradient in the RGB24 format
     */
    @JsonCreator
    public BackgroundFillFreeformGradient(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundFillType type,
            @JsonProperty("colors") List<Long> colors) {
        this.type = type;
        this.colors = colors;
    }

    public static BackgroundFillFreeformGradient of(List<Long> colors) {
        return new BackgroundFillFreeformGradient(BackgroundFillType.FREEFORM_GRADIENT, colors);
    }

    /**
     * Type of the background fill, always 'freeform_gradient'
     */
    public BackgroundFillType type() {
        return type;
    }

    /**
     * A list of the 3 or 4 base colors that are used to generate the freeform gradient in the RGB24
     * format
     */
    public List<Long> colors() {
        return colors;
    }

    public BackgroundFillFreeformGradient withColors(List<Long> colors) {
        return new BackgroundFillFreeformGradient(type, colors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BackgroundFillFreeformGradient)) {
            return false;
        }
        BackgroundFillFreeformGradient that = (BackgroundFillFreeformGradient) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.colors, that.colors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.colors);
    }

    @Override
    public String toString() {
        return "BackgroundFillFreeformGradient[type=" + this.type
                + ", colors=" + this.colors
                + "]";
    }
}
