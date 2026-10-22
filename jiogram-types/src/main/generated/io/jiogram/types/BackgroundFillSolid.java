package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;
import java.util.Objects;

/**
 * The background is filled using the selected color.
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundfillsolid">BackgroundFillSolid in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BackgroundFillSolid implements BackgroundFill {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BackgroundFillType type;

    @JsonProperty("color")
    private final long color;

    /**
     * Creates a new {@code BackgroundFillSolid} instance.
     *
     * @param type Type of the background fill, always 'solid'
     * @param color The color of the background fill in the RGB24 format
     */
    @JsonCreator
    public BackgroundFillSolid(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundFillType type,
            @JsonProperty("color") long color) {
        this.type = type;
        this.color = color;
    }

    public static BackgroundFillSolid of(long color) {
        return new BackgroundFillSolid(BackgroundFillType.SOLID, color);
    }

    /**
     * Type of the background fill, always 'solid'
     */
    public BackgroundFillType type() {
        return type;
    }

    /**
     * The color of the background fill in the RGB24 format
     */
    public long color() {
        return color;
    }

    public BackgroundFillSolid withColor(long color) {
        return new BackgroundFillSolid(type, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BackgroundFillSolid)) {
            return false;
        }
        BackgroundFillSolid that = (BackgroundFillSolid) o;
        return Objects.equals(this.type, that.type)
                && this.color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.color);
    }

    @Override
    public String toString() {
        return "BackgroundFillSolid[type=" + this.type
                + ", color=" + this.color
                + "]";
    }
}
