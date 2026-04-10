package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class ChatOwnerLeft {
    @JsonProperty("new_owner") @Nullable private final User newOwner;

    @JsonCreator
    public ChatOwnerLeft(
            @JsonProperty("new_owner") @Nullable User newOwner
    ) {
        this.newOwner = newOwner;
    }

    public User newOwner() {
        return this.newOwner;
    }
}
