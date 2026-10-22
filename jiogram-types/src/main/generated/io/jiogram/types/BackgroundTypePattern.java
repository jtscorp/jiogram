package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;
import io.jiogram.types.BackgroundTypeType;
import io.jiogram.types.Document;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * The background is a .PNG or .TGV (gzipped subset of SVG with MIME type
 * 'application/x-tgwallpattern') pattern to be combined with the background fill chosen by the
 * user.
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypepattern">BackgroundTypePattern in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BackgroundTypePattern implements BackgroundType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BackgroundTypeType type;

    @JsonProperty("document")
    private final Document document;

    @JsonProperty("fill")
    private final BackgroundFill fill;

    @JsonProperty("intensity")
    private final long intensity;

    @JsonProperty("is_inverted")
    private final @Nullable Boolean isInverted;

    @JsonProperty("is_moving")
    private final @Nullable Boolean isMoving;

    /**
     * Creates a new {@code BackgroundTypePattern} instance.
     *
     * @param type Type of the background, always 'pattern'
     * @param document Document with the pattern
     * @param fill The background fill that is combined with the pattern
     * @param intensity Intensity of the pattern when it is shown above the filled background; 0-100
     * @param isInverted True, if the background fill must be applied only to the pattern itself.
     *     All other pixels are black in this case. For dark themes only
     * @param isMoving True, if the background moves slightly when the device is tilted
     */
    @JsonCreator
    public BackgroundTypePattern(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
            @JsonProperty("document") Document document,
            @JsonProperty("fill") BackgroundFill fill,
            @JsonProperty("intensity") long intensity,
            @JsonProperty("is_inverted") @Nullable Boolean isInverted,
            @JsonProperty("is_moving") @Nullable Boolean isMoving) {
        this.type = type;
        this.document = document;
        this.fill = fill;
        this.intensity = intensity;
        this.isInverted = isInverted;
        this.isMoving = isMoving;
    }

    public static BackgroundTypePattern of(Document document, BackgroundFill fill, long intensity) {
        return new BackgroundTypePattern(BackgroundTypeType.PATTERN, document, fill, intensity, null, null);
    }

    /**
     * Type of the background, always 'pattern'
     */
    public BackgroundTypeType type() {
        return type;
    }

    /**
     * Document with the pattern
     */
    public Document document() {
        return document;
    }

    /**
     * The background fill that is combined with the pattern
     */
    public BackgroundFill fill() {
        return fill;
    }

    /**
     * Intensity of the pattern when it is shown above the filled background; 0-100
     */
    public long intensity() {
        return intensity;
    }

    /**
     * True, if the background fill must be applied only to the pattern itself. All other pixels are
     * black in this case. For dark themes only
     */
    public @Nullable Boolean isInverted() {
        return isInverted;
    }

    /**
     * True, if the background moves slightly when the device is tilted
     */
    public @Nullable Boolean isMoving() {
        return isMoving;
    }

    public BackgroundTypePattern withDocument(Document document) {
        return new BackgroundTypePattern(type, document, fill, intensity, isInverted, isMoving);
    }

    public BackgroundTypePattern withFill(BackgroundFill fill) {
        return new BackgroundTypePattern(type, document, fill, intensity, isInverted, isMoving);
    }

    public BackgroundTypePattern withIntensity(long intensity) {
        return new BackgroundTypePattern(type, document, fill, intensity, isInverted, isMoving);
    }

    public BackgroundTypePattern withIsInverted(@Nullable Boolean isInverted) {
        return new BackgroundTypePattern(type, document, fill, intensity, isInverted, isMoving);
    }

    public BackgroundTypePattern withIsMoving(@Nullable Boolean isMoving) {
        return new BackgroundTypePattern(type, document, fill, intensity, isInverted, isMoving);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BackgroundTypePattern)) {
            return false;
        }
        BackgroundTypePattern that = (BackgroundTypePattern) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.document, that.document)
                && Objects.equals(this.fill, that.fill)
                && this.intensity == that.intensity
                && Objects.equals(this.isInverted, that.isInverted)
                && Objects.equals(this.isMoving, that.isMoving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.document, this.fill, this.intensity, this.isInverted, this.isMoving);
    }

    @Override
    public String toString() {
        return "BackgroundTypePattern[type=" + this.type
                + ", document=" + this.document
                + ", fill=" + this.fill
                + ", intensity=" + this.intensity
                + ", isInverted=" + this.isInverted
                + ", isMoving=" + this.isMoving
                + "]";
    }
}
