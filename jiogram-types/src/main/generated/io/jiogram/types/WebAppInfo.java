package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WebAppInfo(
    @JsonProperty("url") String url
) {}
