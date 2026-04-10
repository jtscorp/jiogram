package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PassportElementErrorFiles implements PassportElementError {
    @JsonProperty("source") private final String source;
    @JsonProperty("type") private final String type;
    @JsonProperty("file_hashes") private final List<String> fileHashes;
    @JsonProperty("message") private final String message;

    @JsonCreator
    public PassportElementErrorFiles(
            @JsonProperty("source") String source,
            @JsonProperty("type") String type,
            @JsonProperty("file_hashes") List<String> fileHashes,
            @JsonProperty("message") String message
    ) {
        this.source = source;
        this.type = type;
        this.fileHashes = fileHashes;
        this.message = message;
    }

    public String source() {
        return this.source;
    }

    public String type() {
        return this.type;
    }

    public List<String> fileHashes() {
        return this.fileHashes;
    }

    public String message() {
        return this.message;
    }
}
