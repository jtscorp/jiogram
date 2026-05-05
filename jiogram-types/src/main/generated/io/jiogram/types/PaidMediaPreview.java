package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import org.jspecify.annotations.Nullable;

public class PaidMediaPreview implements PaidMedia {
    @JsonProperty("type") private final PaidMediaType type;
    @JsonProperty("width") @Nullable private final Long width;
    @JsonProperty("height") @Nullable private final Long height;
    @JsonProperty("duration") @Nullable private final Long duration;

    @JsonCreator
    public PaidMediaPreview(
            @JsonProperty("type") PaidMediaType type,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("duration") @Nullable Long duration
    ) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.duration = duration;
    }

    public PaidMediaType type() {
        return this.type;
    }

    public Long width() {
        return this.width;
    }

    public Long height() {
        return this.height;
    }

    public Long duration() {
        return this.duration;
    }
}
