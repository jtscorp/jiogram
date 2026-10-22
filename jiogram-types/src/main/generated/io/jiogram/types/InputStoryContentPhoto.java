package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputStoryContentType;

/**
 * Describes a photo to post as a story.
 *
 * @param type Type of the content, must be photo
 * @param photo The photo to post as a story. The photo must be of the size 1080x1920 and must not
 *     exceed 10 MB. The photo can't be reused and can only be uploaded as a new file, so you can
 *     pass 'attach://&lt;file_attach_name&gt;' if the photo was uploaded using multipart/form-data
 *     under &lt;file_attach_name&gt;. More information on Sending Files
 * @see <a href="https://core.telegram.org/bots/api#inputstorycontentphoto">InputStoryContentPhoto in the Bot API</a>
 */
public record InputStoryContentPhoto(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputStoryContentType type,
    @JsonProperty("photo") InputFileOrString photo
) implements InputStoryContent {}
