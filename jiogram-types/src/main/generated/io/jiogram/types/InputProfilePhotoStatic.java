package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputProfilePhotoType;

/**
 * A static profile photo in the .JPG format.
 *
 * @param type Type of the profile photo, must be static
 * @param photo The static profile photo. Profile photos can't be reused and can only be uploaded as
 *     a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the photo was uploaded
 *     using multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
 * @see <a href="https://core.telegram.org/bots/api#inputprofilephotostatic">InputProfilePhotoStatic in the Bot API</a>
 */
public record InputProfilePhotoStatic(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputProfilePhotoType type,
    @JsonProperty("photo") InputFileOrString photo
) implements InputProfilePhoto {}
