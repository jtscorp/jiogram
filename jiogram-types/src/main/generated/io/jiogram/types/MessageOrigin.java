package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = MessageOriginChannel.class, name = "channel"),
    @JsonSubTypes.Type(value = MessageOriginHiddenUser.class, name = "hidden_user"),
    @JsonSubTypes.Type(value = MessageOriginChat.class, name = "chat"),
    @JsonSubTypes.Type(value = MessageOriginUser.class, name = "user")
})
public sealed interface MessageOrigin permits MessageOriginChannel, MessageOriginHiddenUser, MessageOriginChat, MessageOriginUser {}
