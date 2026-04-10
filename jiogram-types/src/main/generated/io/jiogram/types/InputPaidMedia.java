package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputPaidMediaPhoto.class, name = "photo"),
    @JsonSubTypes.Type(value = InputPaidMediaVideo.class, name = "video")
})
public interface InputPaidMedia {}
