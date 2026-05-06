package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhotoType;

public record InputProfilePhotoStatic(
    @JsonProperty("type") InputProfilePhotoType type,
    @JsonProperty("photo") String photo
) implements InputProfilePhoto {}
