package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PassportFile {
    @JsonProperty("file_id") private final String fileId;
    @JsonProperty("file_unique_id") private final String fileUniqueId;
    @JsonProperty("file_size") private final long fileSize;
    @JsonProperty("file_date") private final long fileDate;

    @JsonCreator
    public PassportFile(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("file_size") long fileSize,
            @JsonProperty("file_date") long fileDate
    ) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.fileSize = fileSize;
        this.fileDate = fileDate;
    }

    public String fileId() {
        return this.fileId;
    }

    public String fileUniqueId() {
        return this.fileUniqueId;
    }

    public long fileSize() {
        return this.fileSize;
    }

    public long fileDate() {
        return this.fileDate;
    }
}
