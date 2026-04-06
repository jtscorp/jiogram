package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record Close(

) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "close";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
