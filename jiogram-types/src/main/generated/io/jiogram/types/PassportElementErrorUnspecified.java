package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PassportElementErrorUnspecified implements PassportElementError {
    @JsonProperty("source") private final String source;
    @JsonProperty("type") private final String type;
    @JsonProperty("element_hash") private final String elementHash;
    @JsonProperty("message") private final String message;

    @JsonCreator
    public PassportElementErrorUnspecified(
            @JsonProperty("source") String source,
            @JsonProperty("type") String type,
            @JsonProperty("element_hash") String elementHash,
            @JsonProperty("message") String message
    ) {
        this.source = source;
        this.type = type;
        this.elementHash = elementHash;
        this.message = message;
    }

    public String source() {
        return this.source;
    }

    public String type() {
        return this.type;
    }

    public String elementHash() {
        return this.elementHash;
    }

    public String message() {
        return this.message;
    }
}
