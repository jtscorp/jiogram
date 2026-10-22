package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputStoryContentType;
import java.util.Objects;

/**
 * Describes a photo to post as a story.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputstorycontentphoto">InputStoryContentPhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputStoryContentPhoto implements InputStoryContent {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InputStoryContentType type;

    @JsonProperty("photo")
    private final InputFileOrString photo;

    /**
     * Creates a new {@code InputStoryContentPhoto} instance.
     *
     * @param type Type of the content, must be photo
     * @param photo The photo to post as a story. The photo must be of the size 1080x1920 and must
     *     not exceed 10 MB. The photo can't be reused and can only be uploaded as a new file, so
     *     you can pass 'attach://&lt;file_attach_name&gt;' if the photo was uploaded using
     *     multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
     */
    @JsonCreator
    public InputStoryContentPhoto(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputStoryContentType type,
            @JsonProperty("photo") InputFileOrString photo) {
        this.type = type;
        this.photo = photo;
    }

    public static InputStoryContentPhoto of(InputFileOrString photo) {
        return new InputStoryContentPhoto(InputStoryContentType.PHOTO, photo);
    }

    /**
     * Type of the content, must be photo
     */
    public InputStoryContentType type() {
        return type;
    }

    /**
     * The photo to post as a story. The photo must be of the size 1080x1920 and must not exceed 10
     * MB. The photo can't be reused and can only be uploaded as a new file, so you can pass
     * 'attach://&lt;file_attach_name&gt;' if the photo was uploaded using multipart/form-data under
     * &lt;file_attach_name&gt;. More information on Sending Files
     */
    public InputFileOrString photo() {
        return photo;
    }

    public InputStoryContentPhoto withPhoto(InputFileOrString photo) {
        return new InputStoryContentPhoto(type, photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputStoryContentPhoto)) {
            return false;
        }
        InputStoryContentPhoto that = (InputStoryContentPhoto) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.photo);
    }

    @Override
    public String toString() {
        return "InputStoryContentPhoto[type=" + this.type
                + ", photo=" + this.photo
                + "]";
    }
}
