package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record GetManagedBotToken(
    @JsonProperty("user_id") long userId
) implements TelegramMethod<String> {

    @Override
    public String apiMethod() {
        return "getManagedBotToken";
    }

    @Override
    public String apiReturnType() {
        return "String";
    }
}
