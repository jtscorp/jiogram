package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record PassportElementErrorFiles(
    @JsonProperty("source") String source,
    @JsonProperty("type") String type,
    @JsonProperty("file_hashes") List<String> fileHashes,
    @JsonProperty("message") String message
) implements PassportElementError {}
