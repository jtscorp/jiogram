package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputProfilePhotoType;
import java.util.Objects;

/**
 * A static profile photo in the .JPG format.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputprofilephotostatic">InputProfilePhotoStatic in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputProfilePhotoStatic implements InputProfilePhoto {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InputProfilePhotoType type;

    @JsonProperty("photo")
    private final InputFileOrString photo;

    /**
     * Creates a new {@code InputProfilePhotoStatic} instance.
     *
     * @param type Type of the profile photo, must be static
     * @param photo The static profile photo. Profile photos can't be reused and can only be
     *     uploaded as a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the photo
     *     was uploaded using multipart/form-data under &lt;file_attach_name&gt;. More information
     *     on Sending Files
     */
    @JsonCreator
    public InputProfilePhotoStatic(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputProfilePhotoType type,
            @JsonProperty("photo") InputFileOrString photo) {
        this.type = type;
        this.photo = photo;
    }

    public static InputProfilePhotoStatic of(InputFileOrString photo) {
        return new InputProfilePhotoStatic(InputProfilePhotoType.STATIC, photo);
    }

    /**
     * Type of the profile photo, must be static
     */
    public InputProfilePhotoType type() {
        return type;
    }

    /**
     * The static profile photo. Profile photos can't be reused and can only be uploaded as a new
     * file, so you can pass 'attach://&lt;file_attach_name&gt;' if the photo was uploaded using
     * multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
     */
    public InputFileOrString photo() {
        return photo;
    }

    public InputProfilePhotoStatic withPhoto(InputFileOrString photo) {
        return new InputProfilePhotoStatic(type, photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputProfilePhotoStatic)) {
            return false;
        }
        InputProfilePhotoStatic that = (InputProfilePhotoStatic) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.photo);
    }

    @Override
    public String toString() {
        return "InputProfilePhotoStatic[type=" + this.type
                + ", photo=" + this.photo
                + "]";
    }
}
