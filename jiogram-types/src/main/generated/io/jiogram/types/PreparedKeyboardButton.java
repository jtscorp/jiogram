package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PreparedKeyboardButton(
    @JsonProperty("id") String id
) {}
