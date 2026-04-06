package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputProfilePhotoStatic.class, name = "static"),
    @JsonSubTypes.Type(value = InputProfilePhotoAnimated.class, name = "animated")
})
public sealed interface InputProfilePhoto permits InputProfilePhotoStatic, InputProfilePhotoAnimated {}
