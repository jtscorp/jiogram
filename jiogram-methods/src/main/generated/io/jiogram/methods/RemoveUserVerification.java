package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record RemoveUserVerification(
    @JsonProperty("user_id") long userId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "removeUserVerification";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
