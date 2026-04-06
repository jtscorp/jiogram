package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record RemoveMyProfilePhoto(

) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "removeMyProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
