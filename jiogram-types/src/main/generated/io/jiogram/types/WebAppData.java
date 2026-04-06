package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WebAppData(
    @JsonProperty("data") String data,
    @JsonProperty("button_text") String buttonText
) {}
