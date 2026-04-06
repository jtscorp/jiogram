package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PassportElementErrorUnspecified(
    @JsonProperty("source") String source,
    @JsonProperty("type") String type,
    @JsonProperty("element_hash") String elementHash,
    @JsonProperty("message") String message
) implements PassportElementError {}
