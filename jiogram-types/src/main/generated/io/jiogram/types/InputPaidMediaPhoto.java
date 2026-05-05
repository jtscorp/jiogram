package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputPaidMediaType;

public class InputPaidMediaPhoto implements InputPaidMedia {
    @JsonProperty("type") private final InputPaidMediaType type;
    @JsonProperty("media") private final String media;

    @JsonCreator
    public InputPaidMediaPhoto(
            @JsonProperty("type") InputPaidMediaType type,
            @JsonProperty("media") String media
    ) {
        this.type = type;
        this.media = media;
    }

    public InputPaidMediaType type() {
        return this.type;
    }

    public String media() {
        return this.media;
    }
}
