package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageAutoDeleteTimerChanged(
    @JsonProperty("message_auto_delete_time") long messageAutoDeleteTime
) {}
