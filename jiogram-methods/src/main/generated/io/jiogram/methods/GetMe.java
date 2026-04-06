package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.User;

public record GetMe(

) implements TelegramMethod<User> {

    @Override
    public String apiMethod() {
        return "getMe";
    }

    @Override
    public String apiReturnType() {
        return "User";
    }
}
