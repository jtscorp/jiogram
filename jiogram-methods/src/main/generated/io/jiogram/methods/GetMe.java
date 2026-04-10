package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.User;

public class GetMe implements TelegramMethod<User> {
    @JsonCreator
    public GetMe() {
    }

    @Override
    public String apiMethod() {
        return "getMe";
    }

    @Override
    public String apiReturnType() {
        return "User";
    }
}
