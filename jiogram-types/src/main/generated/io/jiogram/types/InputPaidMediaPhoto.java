package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputPaidMediaPhoto implements InputPaidMedia {
    @JsonProperty("type") private final String type;
    @JsonProperty("media") private final String media;

    @JsonCreator
    public InputPaidMediaPhoto(
            @JsonProperty("type") String type,
            @JsonProperty("media") String media
    ) {
        this.type = type;
        this.media = media;
    }

    public String type() {
        return this.type;
    }

    public String media() {
        return this.media;
    }
}
