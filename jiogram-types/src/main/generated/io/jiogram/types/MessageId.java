package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageId(
    @JsonProperty("message_id") long messageId
) {}
