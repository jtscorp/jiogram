package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import org.jspecify.annotations.Nullable;

/**
 * The paid media isn't available before the payment.
 *
 * @param type Type of the paid media, always 'preview'
 * @param width Media width as defined by the sender
 * @param height Media height as defined by the sender
 * @param duration Duration of the media in seconds as defined by the sender
 * @see <a href="https://core.telegram.org/bots/api#paidmediapreview">PaidMediaPreview in the Bot API</a>
 */
public record PaidMediaPreview(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) PaidMediaType type,
    @JsonProperty("width") @Nullable Long width,
    @JsonProperty("height") @Nullable Long height,
    @JsonProperty("duration") @Nullable Long duration
) implements PaidMedia {

    public static PaidMediaPreview of() {
        return new PaidMediaPreview(PaidMediaType.PREVIEW, null, null, null);
    }

    public PaidMediaPreview withWidth(@Nullable Long width) {
        return new PaidMediaPreview(type, width, height, duration);
    }

    public PaidMediaPreview withHeight(@Nullable Long height) {
        return new PaidMediaPreview(type, width, height, duration);
    }

    public PaidMediaPreview withDuration(@Nullable Long duration) {
        return new PaidMediaPreview(type, width, height, duration);
    }
}
