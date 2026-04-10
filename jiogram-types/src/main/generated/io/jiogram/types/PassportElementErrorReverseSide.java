package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PassportElementErrorReverseSide implements PassportElementError {
    @JsonProperty("source") private final String source;
    @JsonProperty("type") private final String type;
    @JsonProperty("file_hash") private final String fileHash;
    @JsonProperty("message") private final String message;

    @JsonCreator
    public PassportElementErrorReverseSide(
            @JsonProperty("source") String source,
            @JsonProperty("type") String type,
            @JsonProperty("file_hash") String fileHash,
            @JsonProperty("message") String message
    ) {
        this.source = source;
        this.type = type;
        this.fileHash = fileHash;
        this.message = message;
    }

    public String source() {
        return this.source;
    }

    public String type() {
        return this.type;
    }

    public String fileHash() {
        return this.fileHash;
    }

    public String message() {
        return this.message;
    }
}
