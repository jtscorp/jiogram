package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class KeyboardButtonPollType {
    @JsonProperty("type") @Nullable private final String type;

    @JsonCreator
    public KeyboardButtonPollType(
            @JsonProperty("type") @Nullable String type
    ) {
        this.type = type;
    }

    public String type() {
        return this.type;
    }
}
