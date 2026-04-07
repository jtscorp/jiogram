package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputStoryContentVideo.class, name = "video"),
    @JsonSubTypes.Type(value = InputStoryContentPhoto.class, name = "photo")
})
public sealed interface InputStoryContent permits InputStoryContentVideo, InputStoryContentPhoto {}
