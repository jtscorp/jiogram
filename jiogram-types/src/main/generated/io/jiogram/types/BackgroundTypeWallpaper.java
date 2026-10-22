package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundTypeType;
import io.jiogram.types.Document;
import org.jspecify.annotations.Nullable;

/**
 * The background is a wallpaper in the JPEG format.
 *
 * @param type Type of the background, always 'wallpaper'
 * @param document Document with the wallpaper
 * @param darkThemeDimming Dimming of the background in dark themes, as a percentage; 0-100
 * @param isBlurred True, if the wallpaper is downscaled to fit in a 450x450 square and then
 *     box-blurred with radius 12
 * @param isMoving True, if the background moves slightly when the device is tilted
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypewallpaper">BackgroundTypeWallpaper in the Bot API</a>
 */
public record BackgroundTypeWallpaper(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
    @JsonProperty("document") Document document,
    @JsonProperty("dark_theme_dimming") long darkThemeDimming,
    @JsonProperty("is_blurred") @Nullable Boolean isBlurred,
    @JsonProperty("is_moving") @Nullable Boolean isMoving
) implements BackgroundType {

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
}
