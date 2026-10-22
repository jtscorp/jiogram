package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputProfilePhotoType;
import org.jspecify.annotations.Nullable;

/**
 * An animated profile photo in the MPEG4 format.
 *
 * @param type Type of the profile photo, must be animated
 * @param animation The animated profile photo. Profile photos can't be reused and can only be
 *     uploaded as a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the photo was
 *     uploaded using multipart/form-data under &lt;file_attach_name&gt;. More information on
 *     Sending Files
 * @param mainFrameTimestamp Timestamp in seconds of the frame that will be used as the static
 *     profile photo. Defaults to 0.0.
 * @see <a href="https://core.telegram.org/bots/api#inputprofilephotoanimated">InputProfilePhotoAnimated in the Bot API</a>
 */
public record InputProfilePhotoAnimated(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputProfilePhotoType type,
    @JsonProperty("animation") InputFileOrString animation,
    @JsonProperty("main_frame_timestamp") @Nullable Double mainFrameTimestamp
) implements InputProfilePhoto {}
