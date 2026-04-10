package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public class ChatBoostSourcePremium implements ChatBoostSource {
    @JsonProperty("source") private final String source;
    @JsonProperty("user") private final User user;

    @JsonCreator
    public ChatBoostSourcePremium(
            @JsonProperty("source") String source,
            @JsonProperty("user") User user
    ) {
        this.source = source;
        this.user = user;
    }

    public String source() {
        return this.source;
    }

    public User user() {
        return this.user;
    }
}
