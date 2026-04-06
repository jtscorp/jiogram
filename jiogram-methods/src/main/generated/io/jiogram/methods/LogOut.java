package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record LogOut(

) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "logOut";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
