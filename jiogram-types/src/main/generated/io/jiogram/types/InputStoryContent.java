package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the content of a story to post. Currently, it can be one of
 * <br>- InputStoryContentPhoto
 * <br>- InputStoryContentVideo
 *
 * @see <a href="https://core.telegram.org/bots/api#inputstorycontent">InputStoryContent in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = InputStoryContentUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputStoryContentPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InputStoryContentVideo.class, name = "video")
})
public sealed interface InputStoryContent permits InputStoryContentPhoto, InputStoryContentVideo, InputStoryContentUnknown {}
