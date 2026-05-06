package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageOriginType;

public record MessageOriginHiddenUser(
    @JsonProperty("type") MessageOriginType type,
    @JsonProperty("date") long date,
    @JsonProperty("sender_user_name") String senderUserName
) implements MessageOrigin {}
