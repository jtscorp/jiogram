package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

public record PassportElementErrorDataField(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("field_name") String fieldName,
    @JsonProperty("data_hash") String dataHash,
    @JsonProperty("message") String message
) implements PassportElementError {}
