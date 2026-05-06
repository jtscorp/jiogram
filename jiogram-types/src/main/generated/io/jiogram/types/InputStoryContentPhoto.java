package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContentType;

public record InputStoryContentPhoto(
    @JsonProperty("type") InputStoryContentType type,
    @JsonProperty("photo") String photo
) implements InputStoryContent {}
