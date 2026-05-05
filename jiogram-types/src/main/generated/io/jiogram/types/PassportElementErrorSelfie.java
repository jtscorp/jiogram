package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

public class PassportElementErrorSelfie implements PassportElementError {
    @JsonProperty("source") private final PassportElementErrorType source;
    @JsonProperty("type") private final PassportElementType type;
    @JsonProperty("file_hash") private final String fileHash;
    @JsonProperty("message") private final String message;

    @JsonCreator
    public PassportElementErrorSelfie(
            @JsonProperty("source") PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("file_hash") String fileHash,
            @JsonProperty("message") String message
    ) {
        this.source = source;
        this.type = type;
        this.fileHash = fileHash;
        this.message = message;
    }

    public PassportElementErrorType source() {
        return this.source;
    }

    public PassportElementType type() {
        return this.type;
    }

    public String fileHash() {
        return this.fileHash;
    }

    public String message() {
        return this.message;
    }
}
