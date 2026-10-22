package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;
import io.jiogram.types.BackgroundTypeType;
import io.jiogram.types.Document;
import org.jspecify.annotations.Nullable;

/**
 * The background is a .PNG or .TGV (gzipped subset of SVG with MIME type
 * 'application/x-tgwallpattern') pattern to be combined with the background fill chosen by the
 * user.
 *
 * @param type Type of the background, always 'pattern'
 * @param document Document with the pattern
 * @param fill The background fill that is combined with the pattern
 * @param intensity Intensity of the pattern when it is shown above the filled background; 0-100
 * @param isInverted True, if the background fill must be applied only to the pattern itself. All
 *     other pixels are black in this case. For dark themes only
 * @param isMoving True, if the background moves slightly when the device is tilted
 * @see <a href="https://core.telegram.org/bots/api#backgroundtypepattern">BackgroundTypePattern in the Bot API</a>
 */
public record BackgroundTypePattern(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
    @JsonProperty("document") Document document,
    @JsonProperty("fill") BackgroundFill fill,
    @JsonProperty("intensity") long intensity,
    @JsonProperty("is_inverted") @Nullable Boolean isInverted,
    @JsonProperty("is_moving") @Nullable Boolean isMoving
) implements BackgroundType {

    public static BackgroundTypePattern of(Document document, BackgroundFill fill, long intensity) {
        return new BackgroundTypePattern(BackgroundTypeType.PATTERN, document, fill, intensity, null, null);
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
}
