package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;
import io.jiogram.types.BackgroundTypeType;
import java.util.Objects;

/**
 * The background is automatically filled based on the selected colors.
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypefill">BackgroundTypeFill in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BackgroundTypeFill implements BackgroundType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BackgroundTypeType type;

    @JsonProperty("fill")
    private final BackgroundFill fill;

    @JsonProperty("dark_theme_dimming")
    private final long darkThemeDimming;

    /**
     * Creates a new {@code BackgroundTypeFill} instance.
     *
     * @param type Type of the background, always 'fill'
     * @param fill The background fill
     * @param darkThemeDimming Dimming of the background in dark themes, as a percentage; 0-100
     */
    @JsonCreator
    public BackgroundTypeFill(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
            @JsonProperty("fill") BackgroundFill fill,
            @JsonProperty("dark_theme_dimming") long darkThemeDimming) {
        this.type = type;
        this.fill = fill;
        this.darkThemeDimming = darkThemeDimming;
    }

    public static BackgroundTypeFill of(BackgroundFill fill, long darkThemeDimming) {
        return new BackgroundTypeFill(BackgroundTypeType.FILL, fill, darkThemeDimming);
    }

    /**
     * Type of the background, always 'fill'
     */
    public BackgroundTypeType type() {
        return type;
    }

    /**
     * The background fill
     */
    public BackgroundFill fill() {
        return fill;
    }

    /**
     * Dimming of the background in dark themes, as a percentage; 0-100
     */
    public long darkThemeDimming() {
        return darkThemeDimming;
    }

    public BackgroundTypeFill withFill(BackgroundFill fill) {
        return new BackgroundTypeFill(type, fill, darkThemeDimming);
    }

    public BackgroundTypeFill withDarkThemeDimming(long darkThemeDimming) {
        return new BackgroundTypeFill(type, fill, darkThemeDimming);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BackgroundTypeFill)) {
            return false;
        }
        BackgroundTypeFill that = (BackgroundTypeFill) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.fill, that.fill)
                && this.darkThemeDimming == that.darkThemeDimming;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.fill, this.darkThemeDimming);
    }

    @Override
    public String toString() {
        return "BackgroundTypeFill[type=" + this.type
                + ", fill=" + this.fill
                + ", darkThemeDimming=" + this.darkThemeDimming
                + "]";
    }
}
