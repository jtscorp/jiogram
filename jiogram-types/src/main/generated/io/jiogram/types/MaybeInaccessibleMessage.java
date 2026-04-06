package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "date")
@JsonSubTypes({
    @JsonSubTypes.Type(value = InaccessibleMessage.class, name = "0"),
    @JsonSubTypes.Type(value = Message.class, name = "nonzero")
})
public sealed interface MaybeInaccessibleMessage permits InaccessibleMessage, Message {}
