package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class LogOut implements TelegramMethod<Boolean> {
    @JsonCreator
    public LogOut() {
    }

    @Override
    public String apiMethod() {
        return "logOut";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
