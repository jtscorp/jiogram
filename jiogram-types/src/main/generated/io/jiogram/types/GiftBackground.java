package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GiftBackground(
    @JsonProperty("center_color") long centerColor,
    @JsonProperty("edge_color") long edgeColor,
    @JsonProperty("text_color") long textColor
) {}
