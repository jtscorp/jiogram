package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CopyTextButton(
    @JsonProperty("text") String text
) {}
