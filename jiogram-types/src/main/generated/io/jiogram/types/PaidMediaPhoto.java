package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import io.jiogram.types.PhotoSize;
import java.util.List;

/**
 * The paid media is a photo.
 *
 * @param type Type of the paid media, always 'photo'
 * @param photo The photo
 * @see <a href="https://core.telegram.org/bots/api#paidmediaphoto">PaidMediaPhoto in the Bot API</a>
 */
public record PaidMediaPhoto(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) PaidMediaType type,
    @JsonProperty("photo") List<PhotoSize> photo
) implements PaidMedia {}
