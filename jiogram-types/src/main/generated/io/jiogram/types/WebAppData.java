package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WebAppData {
    @JsonProperty("data") private final String data;
    @JsonProperty("button_text") private final String buttonText;

    @JsonCreator
    public WebAppData(
            @JsonProperty("data") String data,
            @JsonProperty("button_text") String buttonText
    ) {
        this.data = data;
        this.buttonText = buttonText;
    }

    public String data() {
        return this.data;
    }

    public String buttonText() {
        return this.buttonText;
    }
}
