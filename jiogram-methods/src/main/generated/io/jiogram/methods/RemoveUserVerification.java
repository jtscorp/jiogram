package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class RemoveUserVerification implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;

    @JsonCreator
    public RemoveUserVerification(
            @JsonProperty("user_id") long userId
    ) {
        this.userId = userId;
    }

    public long userId() {
        return this.userId;
    }

    @Override
    public String apiMethod() {
        return "removeUserVerification";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
