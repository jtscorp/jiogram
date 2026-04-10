package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CopyTextButton {
    @JsonProperty("text") private final String text;

    @JsonCreator
    public CopyTextButton(
            @JsonProperty("text") String text
    ) {
        this.text = text;
    }

    public String text() {
        return this.text;
    }
}
