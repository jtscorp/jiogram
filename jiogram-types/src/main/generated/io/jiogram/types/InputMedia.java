package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputMediaVideo.class, name = "video"),
    @JsonSubTypes.Type(value = InputMediaAnimation.class, name = "animation"),
    @JsonSubTypes.Type(value = InputMediaDocument.class, name = "document"),
    @JsonSubTypes.Type(value = InputMediaAudio.class, name = "audio"),
    @JsonSubTypes.Type(value = InputMediaPhoto.class, name = "photo")
})
public sealed interface InputMedia permits InputMediaVideo, InputMediaAnimation, InputMediaDocument, InputMediaAudio, InputMediaPhoto {}
