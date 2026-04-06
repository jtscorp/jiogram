package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageOriginHiddenUser(
    @JsonProperty("type") String type,
    @JsonProperty("date") long date,
    @JsonProperty("sender_user_name") String senderUserName
) implements MessageOrigin {}
