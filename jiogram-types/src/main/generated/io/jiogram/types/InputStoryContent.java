package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = InputStoryContentUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputStoryContentPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InputStoryContentVideo.class, name = "video")
})
public sealed interface InputStoryContent permits InputStoryContentPhoto, InputStoryContentVideo, InputStoryContentUnknown {}
