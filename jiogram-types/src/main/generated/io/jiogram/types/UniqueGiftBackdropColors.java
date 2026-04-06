package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UniqueGiftBackdropColors(
    @JsonProperty("center_color") long centerColor,
    @JsonProperty("edge_color") long edgeColor,
    @JsonProperty("symbol_color") long symbolColor,
    @JsonProperty("text_color") long textColor
) {}
