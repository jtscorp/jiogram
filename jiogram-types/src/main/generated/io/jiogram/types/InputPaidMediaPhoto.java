package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InputPaidMediaPhoto(
    @JsonProperty("type") String type,
    @JsonProperty("media") String media
) implements InputPaidMedia {}
