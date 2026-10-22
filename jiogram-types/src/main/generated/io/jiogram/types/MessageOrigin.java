package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object describes the origin of a message. It can be one of
 * <br>- MessageOriginUser
 * <br>- MessageOriginHiddenUser
 * <br>- MessageOriginChat
 * <br>- MessageOriginChannel
 *
 * @see <a href="https://core.telegram.org/bots/api#messageorigin">MessageOrigin in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = MessageOriginUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MessageOriginChannel.class, name = "channel"),
    @JsonSubTypes.Type(value = MessageOriginChat.class, name = "chat"),
    @JsonSubTypes.Type(value = MessageOriginHiddenUser.class, name = "hidden_user"),
    @JsonSubTypes.Type(value = MessageOriginUser.class, name = "user")
})
public interface MessageOrigin {}
