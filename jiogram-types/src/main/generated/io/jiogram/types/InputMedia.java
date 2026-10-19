package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = InputMediaUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputMediaAnimation.class, name = "animation"),
    @JsonSubTypes.Type(value = InputMediaAudio.class, name = "audio"),
    @JsonSubTypes.Type(value = InputMediaDocument.class, name = "document"),
    @JsonSubTypes.Type(value = InputMediaPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InputMediaVideo.class, name = "video")
})
public sealed interface InputMedia permits InputMediaAnimation, InputMediaAudio, InputMediaDocument, InputMediaPhoto, InputMediaVideo, InputMediaUnknown {}
