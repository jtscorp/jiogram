package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UniqueGiftBackdropColors {
    @JsonProperty("center_color") private final long centerColor;
    @JsonProperty("edge_color") private final long edgeColor;
    @JsonProperty("symbol_color") private final long symbolColor;
    @JsonProperty("text_color") private final long textColor;

    @JsonCreator
    public UniqueGiftBackdropColors(
            @JsonProperty("center_color") long centerColor,
            @JsonProperty("edge_color") long edgeColor,
            @JsonProperty("symbol_color") long symbolColor,
            @JsonProperty("text_color") long textColor
    ) {
        this.centerColor = centerColor;
        this.edgeColor = edgeColor;
        this.symbolColor = symbolColor;
        this.textColor = textColor;
    }

    public long centerColor() {
        return this.centerColor;
    }

    public long edgeColor() {
        return this.edgeColor;
    }

    public long symbolColor() {
        return this.symbolColor;
    }

    public long textColor() {
        return this.textColor;
    }
}
