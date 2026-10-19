package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputStoryContentType;

public record InputStoryContentPhoto(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputStoryContentType type,
    @JsonProperty("photo") InputFileOrString photo
) implements InputStoryContent {}
