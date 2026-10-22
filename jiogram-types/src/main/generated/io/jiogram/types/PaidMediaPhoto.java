package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import io.jiogram.types.PhotoSize;
import java.util.List;
import java.util.Objects;

/**
 * The paid media is a photo.
 *
 * @see <a href="https://core.telegram.org/bots/api#paidmediaphoto">PaidMediaPhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PaidMediaPhoto implements PaidMedia {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final PaidMediaType type;

    @JsonProperty("photo")
    private final List<PhotoSize> photo;

    /**
     * Creates a new {@code PaidMediaPhoto} instance.
     *
     * @param type Type of the paid media, always 'photo'
     * @param photo The photo
     */
    @JsonCreator
    public PaidMediaPhoto(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) PaidMediaType type,
            @JsonProperty("photo") List<PhotoSize> photo) {
        this.type = type;
        this.photo = photo;
    }

    public static PaidMediaPhoto of(List<PhotoSize> photo) {
        return new PaidMediaPhoto(PaidMediaType.PHOTO, photo);
    }

    /**
     * Type of the paid media, always 'photo'
     */
    public PaidMediaType type() {
        return type;
    }

    /**
     * The photo
     */
    public List<PhotoSize> photo() {
        return photo;
    }

    public PaidMediaPhoto withPhoto(List<PhotoSize> photo) {
        return new PaidMediaPhoto(type, photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaidMediaPhoto)) {
            return false;
        }
        PaidMediaPhoto that = (PaidMediaPhoto) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.photo);
    }

    @Override
    public String toString() {
        return "PaidMediaPhoto[type=" + this.type
                + ", photo=" + this.photo
                + "]";
    }
}
