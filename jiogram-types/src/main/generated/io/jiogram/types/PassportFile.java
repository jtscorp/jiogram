package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PassportFile(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("file_size") long fileSize,
    @JsonProperty("file_date") long fileDate
) {}
