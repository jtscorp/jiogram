package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputProfilePhotoType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * An animated profile photo in the MPEG4 format.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputprofilephotoanimated">InputProfilePhotoAnimated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputProfilePhotoAnimated implements InputProfilePhoto {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InputProfilePhotoType type;

    @JsonProperty("animation")
    private final InputFileOrString animation;

    @JsonProperty("main_frame_timestamp")
    private final @Nullable Double mainFrameTimestamp;

    /**
     * Creates a new {@code InputProfilePhotoAnimated} instance.
     *
     * @param type Type of the profile photo, must be animated
     * @param animation The animated profile photo. Profile photos can't be reused and can only be
     *     uploaded as a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the photo
     *     was uploaded using multipart/form-data under &lt;file_attach_name&gt;. More information
     *     on Sending Files
     * @param mainFrameTimestamp Timestamp in seconds of the frame that will be used as the static
     *     profile photo. Defaults to 0.0.
     */
    @JsonCreator
    public InputProfilePhotoAnimated(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputProfilePhotoType type,
            @JsonProperty("animation") InputFileOrString animation,
            @JsonProperty("main_frame_timestamp") @Nullable Double mainFrameTimestamp) {
        this.type = type;
        this.animation = animation;
        this.mainFrameTimestamp = mainFrameTimestamp;
    }

    public static InputProfilePhotoAnimated of(InputFileOrString animation) {
        return new InputProfilePhotoAnimated(InputProfilePhotoType.ANIMATED, animation, null);
    }

    /**
     * Type of the profile photo, must be animated
     */
    public InputProfilePhotoType type() {
        return type;
    }

    /**
     * The animated profile photo. Profile photos can't be reused and can only be uploaded as a new
     * file, so you can pass 'attach://&lt;file_attach_name&gt;' if the photo was uploaded using
     * multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
     */
    public InputFileOrString animation() {
        return animation;
    }

    /**
     * Timestamp in seconds of the frame that will be used as the static profile photo. Defaults to
     * 0.0.
     */
    public @Nullable Double mainFrameTimestamp() {
        return mainFrameTimestamp;
    }

    public InputProfilePhotoAnimated withAnimation(InputFileOrString animation) {
        return new InputProfilePhotoAnimated(type, animation, mainFrameTimestamp);
    }

    public InputProfilePhotoAnimated withMainFrameTimestamp(@Nullable Double mainFrameTimestamp) {
        return new InputProfilePhotoAnimated(type, animation, mainFrameTimestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputProfilePhotoAnimated)) {
            return false;
        }
        InputProfilePhotoAnimated that = (InputProfilePhotoAnimated) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.animation, that.animation)
                && Objects.equals(this.mainFrameTimestamp, that.mainFrameTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.animation, this.mainFrameTimestamp);
    }

    @Override
    public String toString() {
        return "InputProfilePhotoAnimated[type=" + this.type
                + ", animation=" + this.animation
                + ", mainFrameTimestamp=" + this.mainFrameTimestamp
                + "]";
    }
}
