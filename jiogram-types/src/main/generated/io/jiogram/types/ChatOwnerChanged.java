package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public class ChatOwnerChanged {
    @JsonProperty("new_owner") private final User newOwner;

    @JsonCreator
    public ChatOwnerChanged(
            @JsonProperty("new_owner") User newOwner
    ) {
        this.newOwner = newOwner;
    }

    public User newOwner() {
        return this.newOwner;
    }
}
