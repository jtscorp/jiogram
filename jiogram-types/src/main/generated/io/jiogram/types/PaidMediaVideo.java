package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import io.jiogram.types.Video;

public class PaidMediaVideo implements PaidMedia {
    @JsonProperty("type") private final PaidMediaType type;
    @JsonProperty("video") private final Video video;

    @JsonCreator
    public PaidMediaVideo(
            @JsonProperty("type") PaidMediaType type,
            @JsonProperty("video") Video video
    ) {
        this.type = type;
        this.video = video;
    }

    public PaidMediaType type() {
        return this.type;
    }

    public Video video() {
        return this.video;
    }
}
