package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;
import java.util.List;

public class PassportElementErrorTranslationFiles implements PassportElementError {
    @JsonProperty("source") private final PassportElementErrorType source;
    @JsonProperty("type") private final PassportElementType type;
    @JsonProperty("file_hashes") private final List<String> fileHashes;
    @JsonProperty("message") private final String message;

    @JsonCreator
    public PassportElementErrorTranslationFiles(
            @JsonProperty("source") PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("file_hashes") List<String> fileHashes,
            @JsonProperty("message") String message
    ) {
        this.source = source;
        this.type = type;
        this.fileHashes = fileHashes;
        this.message = message;
    }

    public PassportElementErrorType source() {
        return this.source;
    }

    public PassportElementType type() {
        return this.type;
    }

    public List<String> fileHashes() {
        return this.fileHashes;
    }

    public String message() {
        return this.message;
    }
}
