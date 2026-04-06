package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhoto;
import io.jiogram.types.TelegramMethod;

public record SetMyProfilePhoto(
    @JsonProperty("photo") InputProfilePhoto photo
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setMyProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
