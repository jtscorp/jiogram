package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;

public class ChatBoostSourceGiftCode implements ChatBoostSource {
    @JsonProperty("source") private final ChatBoostSourceType source;
    @JsonProperty("user") private final User user;

    @JsonCreator
    public ChatBoostSourceGiftCode(
            @JsonProperty("source") ChatBoostSourceType source,
            @JsonProperty("user") User user
    ) {
        this.source = source;
        this.user = user;
    }

    public ChatBoostSourceType source() {
        return this.source;
    }

    public User user() {
        return this.user;
    }
}
