package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PassportElementErrorDataField(
    @JsonProperty("source") String source,
    @JsonProperty("type") String type,
    @JsonProperty("field_name") String fieldName,
    @JsonProperty("data_hash") String dataHash,
    @JsonProperty("message") String message
) implements PassportElementError {}
