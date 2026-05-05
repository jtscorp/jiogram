package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContentType;

public class InputStoryContentPhoto implements InputStoryContent {
    @JsonProperty("type") private final InputStoryContentType type;
    @JsonProperty("photo") private final String photo;

    @JsonCreator
    public InputStoryContentPhoto(
            @JsonProperty("type") InputStoryContentType type,
            @JsonProperty("photo") String photo
    ) {
        this.type = type;
        this.photo = photo;
    }

    public InputStoryContentType type() {
        return this.type;
    }

    public String photo() {
        return this.photo;
    }
}
