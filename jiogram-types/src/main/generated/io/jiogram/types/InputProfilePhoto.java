package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = InputProfilePhotoAnimated.class, name = "animated"),
    @JsonSubTypes.Type(value = InputProfilePhotoStatic.class, name = "static")
})
public interface InputProfilePhoto {}
