package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

public class PassportElementErrorUnspecified implements PassportElementError {
    @JsonProperty("source") private final PassportElementErrorType source;
    @JsonProperty("type") private final PassportElementType type;
    @JsonProperty("element_hash") private final String elementHash;
    @JsonProperty("message") private final String message;

    @JsonCreator
    public PassportElementErrorUnspecified(
            @JsonProperty("source") PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("element_hash") String elementHash,
            @JsonProperty("message") String message
    ) {
        this.source = source;
        this.type = type;
        this.elementHash = elementHash;
        this.message = message;
    }

    public PassportElementErrorType source() {
        return this.source;
    }

    public PassportElementType type() {
        return this.type;
    }

    public String elementHash() {
        return this.elementHash;
    }

    public String message() {
        return this.message;
    }
}
