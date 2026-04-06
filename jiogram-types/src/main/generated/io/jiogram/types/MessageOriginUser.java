package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record MessageOriginUser(
    @JsonProperty("type") String type,
    @JsonProperty("date") long date,
    @JsonProperty("sender_user") User senderUser
) implements MessageOrigin {}
