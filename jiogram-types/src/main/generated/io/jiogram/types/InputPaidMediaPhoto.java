package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputPaidMediaType;

public record InputPaidMediaPhoto(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputPaidMediaType type,
    @JsonProperty("media") InputFileOrString media
) implements InputPaidMedia {}
