package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * The paid media isn't available before the payment.
 *
 * @see <a href="https://core.telegram.org/bots/api#paidmediapreview">PaidMediaPreview in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PaidMediaPreview implements PaidMedia {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final PaidMediaType type;

    @JsonProperty("width")
    private final @Nullable Long width;

    @JsonProperty("height")
    private final @Nullable Long height;

    @JsonProperty("duration")
    private final @Nullable Long duration;

    /**
     * Creates a new {@code PaidMediaPreview} instance.
     *
     * @param type Type of the paid media, always 'preview'
     * @param width Media width as defined by the sender
     * @param height Media height as defined by the sender
     * @param duration Duration of the media in seconds as defined by the sender
     */
    @JsonCreator
    public PaidMediaPreview(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) PaidMediaType type,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("duration") @Nullable Long duration) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.duration = duration;
    }

    public static PaidMediaPreview of() {
        return new PaidMediaPreview(PaidMediaType.PREVIEW, null, null, null);
    }

    /**
     * Type of the paid media, always 'preview'
     */
    public PaidMediaType type() {
        return type;
    }

    /**
     * Media width as defined by the sender
     */
    public @Nullable Long width() {
        return width;
    }

    /**
     * Media height as defined by the sender
     */
    public @Nullable Long height() {
        return height;
    }

    /**
     * Duration of the media in seconds as defined by the sender
     */
    public @Nullable Long duration() {
        return duration;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaidMediaPreview)) {
            return false;
        }
        PaidMediaPreview that = (PaidMediaPreview) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.width, that.width)
                && Objects.equals(this.height, that.height)
                && Objects.equals(this.duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.width, this.height, this.duration);
    }

    @Override
    public String toString() {
        return "PaidMediaPreview[type=" + this.type
                + ", width=" + this.width
                + ", height=" + this.height
                + ", duration=" + this.duration
                + "]";
    }
}
