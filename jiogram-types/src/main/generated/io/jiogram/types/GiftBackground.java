package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GiftBackground {
    @JsonProperty("center_color") private final long centerColor;
    @JsonProperty("edge_color") private final long edgeColor;
    @JsonProperty("text_color") private final long textColor;

    @JsonCreator
    public GiftBackground(
            @JsonProperty("center_color") long centerColor,
            @JsonProperty("edge_color") long edgeColor,
            @JsonProperty("text_color") long textColor
    ) {
        this.centerColor = centerColor;
        this.edgeColor = edgeColor;
        this.textColor = textColor;
    }

    public long centerColor() {
        return this.centerColor;
    }

    public long edgeColor() {
        return this.edgeColor;
    }

    public long textColor() {
        return this.textColor;
    }
}
