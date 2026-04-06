package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PassportElementErrorFile(
    @JsonProperty("source") String source,
    @JsonProperty("type") String type,
    @JsonProperty("file_hash") String fileHash,
    @JsonProperty("message") String message
) implements PassportElementError {}
