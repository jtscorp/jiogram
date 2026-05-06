package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageOriginType;
import io.jiogram.types.User;

public record MessageOriginUser(
    @JsonProperty("type") MessageOriginType type,
    @JsonProperty("date") long date,
    @JsonProperty("sender_user") User senderUser
) implements MessageOrigin {}
