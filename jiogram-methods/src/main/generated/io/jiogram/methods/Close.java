package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class Close implements TelegramMethod<Boolean> {
    @JsonCreator
    public Close() {
    }

    @Override
    public String apiMethod() {
        return "close";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
