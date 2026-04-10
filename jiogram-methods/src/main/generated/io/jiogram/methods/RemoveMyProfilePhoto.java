package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class RemoveMyProfilePhoto implements TelegramMethod<Boolean> {
    @JsonCreator
    public RemoveMyProfilePhoto() {
    }

    @Override
    public String apiMethod() {
        return "removeMyProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
