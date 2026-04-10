package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatPhoto {
    @JsonProperty("small_file_id") private final String smallFileId;
    @JsonProperty("small_file_unique_id") private final String smallFileUniqueId;
    @JsonProperty("big_file_id") private final String bigFileId;
    @JsonProperty("big_file_unique_id") private final String bigFileUniqueId;

    @JsonCreator
    public ChatPhoto(
            @JsonProperty("small_file_id") String smallFileId,
            @JsonProperty("small_file_unique_id") String smallFileUniqueId,
            @JsonProperty("big_file_id") String bigFileId,
            @JsonProperty("big_file_unique_id") String bigFileUniqueId
    ) {
        this.smallFileId = smallFileId;
        this.smallFileUniqueId = smallFileUniqueId;
        this.bigFileId = bigFileId;
        this.bigFileUniqueId = bigFileUniqueId;
    }

    public String smallFileId() {
        return this.smallFileId;
    }

    public String smallFileUniqueId() {
        return this.smallFileUniqueId;
    }

    public String bigFileId() {
        return this.bigFileId;
    }

    public String bigFileUniqueId() {
        return this.bigFileUniqueId;
    }
}
