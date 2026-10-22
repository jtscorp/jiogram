package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputPaidMediaType;

/**
 * The paid media to send is a photo.
 *
 * @param type Type of the media, must be photo
 * @param media File to send. Pass a file_id to send a file that exists on the Telegram servers
 *     (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
 *     'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
 *     &lt;file_attach_name&gt; name. More information on Sending Files
 * @see <a href="https://core.telegram.org/bots/api#inputpaidmediaphoto">InputPaidMediaPhoto in the Bot API</a>
 */
public record InputPaidMediaPhoto(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputPaidMediaType type,
    @JsonProperty("media") InputFileOrString media
) implements InputPaidMedia {

    public static InputPaidMediaPhoto of(InputFileOrString media) {
        return new InputPaidMediaPhoto(InputPaidMediaType.PHOTO, media);
    }

    public InputPaidMediaPhoto withMedia(InputFileOrString media) {
        return new InputPaidMediaPhoto(type, media);
    }
}
