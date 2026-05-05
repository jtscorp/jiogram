package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PollType;
import org.jspecify.annotations.Nullable;

public class KeyboardButtonPollType {
    @JsonProperty("type") @Nullable private final PollType type;

    @JsonCreator
    public KeyboardButtonPollType(
            @JsonProperty("type") @Nullable PollType type
    ) {
        this.type = type;
    }

    public PollType type() {
        return this.type;
    }
}
