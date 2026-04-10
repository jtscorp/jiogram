package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class File {
    @JsonProperty("file_id") private final String fileId;
    @JsonProperty("file_unique_id") private final String fileUniqueId;
    @JsonProperty("file_size") @Nullable private final Long fileSize;
    @JsonProperty("file_path") @Nullable private final String filePath;

    @JsonCreator
    public File(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("file_size") @Nullable Long fileSize,
            @JsonProperty("file_path") @Nullable String filePath
    ) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public String fileId() {
        return this.fileId;
    }

    public String fileUniqueId() {
        return this.fileUniqueId;
    }

    public Long fileSize() {
        return this.fileSize;
    }

    public String filePath() {
        return this.filePath;
    }
}
