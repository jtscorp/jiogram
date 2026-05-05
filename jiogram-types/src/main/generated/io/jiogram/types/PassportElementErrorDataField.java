package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

public class PassportElementErrorDataField implements PassportElementError {
    @JsonProperty("source") private final PassportElementErrorType source;
    @JsonProperty("type") private final PassportElementType type;
    @JsonProperty("field_name") private final String fieldName;
    @JsonProperty("data_hash") private final String dataHash;
    @JsonProperty("message") private final String message;

    @JsonCreator
    public PassportElementErrorDataField(
            @JsonProperty("source") PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("field_name") String fieldName,
            @JsonProperty("data_hash") String dataHash,
            @JsonProperty("message") String message
    ) {
        this.source = source;
        this.type = type;
        this.fieldName = fieldName;
        this.dataHash = dataHash;
        this.message = message;
    }

    public PassportElementErrorType source() {
        return this.source;
    }

    public PassportElementType type() {
        return this.type;
    }

    public String fieldName() {
        return this.fieldName;
    }

    public String dataHash() {
        return this.dataHash;
    }

    public String message() {
        return this.message;
    }
}
