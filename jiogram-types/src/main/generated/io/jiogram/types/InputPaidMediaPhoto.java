package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputPaidMediaType;
import java.util.Objects;

/**
 * The paid media to send is a photo.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputpaidmediaphoto">InputPaidMediaPhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputPaidMediaPhoto implements InputPaidMedia {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InputPaidMediaType type;

    @JsonProperty("media")
    private final InputFileOrString media;

    /**
     * Creates a new {@code InputPaidMediaPhoto} instance.
     *
     * @param type Type of the media, must be photo
     * @param media File to send. Pass a file_id to send a file that exists on the Telegram servers
     *     (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
     *     'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
     *     &lt;file_attach_name&gt; name. More information on Sending Files
     */
    @JsonCreator
    public InputPaidMediaPhoto(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputPaidMediaType type,
            @JsonProperty("media") InputFileOrString media) {
        this.type = type;
        this.media = media;
    }

    public static InputPaidMediaPhoto of(InputFileOrString media) {
        return new InputPaidMediaPhoto(InputPaidMediaType.PHOTO, media);
    }

    /**
     * Type of the media, must be photo
     */
    public InputPaidMediaType type() {
        return type;
    }

    /**
     * File to send. Pass a file_id to send a file that exists on the Telegram servers
     * (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
     * 'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
     * &lt;file_attach_name&gt; name. More information on Sending Files
     */
    public InputFileOrString media() {
        return media;
    }

    public InputPaidMediaPhoto withMedia(InputFileOrString media) {
        return new InputPaidMediaPhoto(type, media);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputPaidMediaPhoto)) {
            return false;
        }
        InputPaidMediaPhoto that = (InputPaidMediaPhoto) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.media, that.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.media);
    }

    @Override
    public String toString() {
        return "InputPaidMediaPhoto[type=" + this.type
                + ", media=" + this.media
                + "]";
    }
}
