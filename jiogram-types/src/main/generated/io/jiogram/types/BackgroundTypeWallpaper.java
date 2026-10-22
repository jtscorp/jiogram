package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundTypeType;
import io.jiogram.types.Document;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * The background is a wallpaper in the JPEG format.
 *
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypewallpaper">BackgroundTypeWallpaper in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BackgroundTypeWallpaper implements BackgroundType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final BackgroundTypeType type;

    @JsonProperty("document")
    private final Document document;

    @JsonProperty("dark_theme_dimming")
    private final long darkThemeDimming;

    @JsonProperty("is_blurred")
    private final @Nullable Boolean isBlurred;

    @JsonProperty("is_moving")
    private final @Nullable Boolean isMoving;

    /**
     * Creates a new {@code BackgroundTypeWallpaper} instance.
     *
     * @param type Type of the background, always 'wallpaper'
     * @param document Document with the wallpaper
     * @param darkThemeDimming Dimming of the background in dark themes, as a percentage; 0-100
     * @param isBlurred True, if the wallpaper is downscaled to fit in a 450x450 square and then
     *     box-blurred with radius 12
     * @param isMoving True, if the background moves slightly when the device is tilted
     */
    @JsonCreator
    public BackgroundTypeWallpaper(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
            @JsonProperty("document") Document document,
            @JsonProperty("dark_theme_dimming") long darkThemeDimming,
            @JsonProperty("is_blurred") @Nullable Boolean isBlurred,
            @JsonProperty("is_moving") @Nullable Boolean isMoving) {
        this.type = type;
        this.document = document;
        this.darkThemeDimming = darkThemeDimming;
        this.isBlurred = isBlurred;
        this.isMoving = isMoving;
    }

    public static BackgroundTypeWallpaper of(Document document, long darkThemeDimming) {
        return new BackgroundTypeWallpaper(BackgroundTypeType.WALLPAPER, document, darkThemeDimming, null, null);
    }

    /**
     * Type of the background, always 'wallpaper'
     */
    public BackgroundTypeType type() {
        return type;
    }

    /**
     * Document with the wallpaper
     */
    public Document document() {
        return document;
    }

    /**
     * Dimming of the background in dark themes, as a percentage; 0-100
     */
    public long darkThemeDimming() {
        return darkThemeDimming;
    }

    /**
     * True, if the wallpaper is downscaled to fit in a 450x450 square and then box-blurred with
     * radius 12
     */
    public @Nullable Boolean isBlurred() {
        return isBlurred;
    }

    /**
     * True, if the background moves slightly when the device is tilted
     */
    public @Nullable Boolean isMoving() {
        return isMoving;
    }

    public BackgroundTypeWallpaper withDocument(Document document) {
        return new BackgroundTypeWallpaper(type, document, darkThemeDimming, isBlurred, isMoving);
    }

    public BackgroundTypeWallpaper withDarkThemeDimming(long darkThemeDimming) {
        return new BackgroundTypeWallpaper(type, document, darkThemeDimming, isBlurred, isMoving);
    }

    public BackgroundTypeWallpaper withIsBlurred(@Nullable Boolean isBlurred) {
        return new BackgroundTypeWallpaper(type, document, darkThemeDimming, isBlurred, isMoving);
    }

    public BackgroundTypeWallpaper withIsMoving(@Nullable Boolean isMoving) {
        return new BackgroundTypeWallpaper(type, document, darkThemeDimming, isBlurred, isMoving);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BackgroundTypeWallpaper)) {
            return false;
        }
        BackgroundTypeWallpaper that = (BackgroundTypeWallpaper) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.document, that.document)
                && this.darkThemeDimming == that.darkThemeDimming
                && Objects.equals(this.isBlurred, that.isBlurred)
                && Objects.equals(this.isMoving, that.isMoving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.document, this.darkThemeDimming, this.isBlurred, this.isMoving);
    }

    @Override
    public String toString() {
        return "BackgroundTypeWallpaper[type=" + this.type
                + ", document=" + this.document
                + ", darkThemeDimming=" + this.darkThemeDimming
                + ", isBlurred=" + this.isBlurred
                + ", isMoving=" + this.isMoving
                + "]";
    }
}
