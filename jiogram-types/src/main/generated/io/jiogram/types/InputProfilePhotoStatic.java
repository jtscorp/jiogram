package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InputProfilePhotoStatic(
    @JsonProperty("type") String type,
    @JsonProperty("photo") String photo
) implements InputProfilePhoto {}
