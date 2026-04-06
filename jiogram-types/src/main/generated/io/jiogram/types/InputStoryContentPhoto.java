package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InputStoryContentPhoto(
    @JsonProperty("type") String type,
    @JsonProperty("photo") String photo
) implements InputStoryContent {}
