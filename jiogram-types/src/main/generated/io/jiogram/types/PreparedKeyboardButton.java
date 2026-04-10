package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PreparedKeyboardButton {
    @JsonProperty("id") private final String id;

    @JsonCreator
    public PreparedKeyboardButton(
            @JsonProperty("id") String id
    ) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
