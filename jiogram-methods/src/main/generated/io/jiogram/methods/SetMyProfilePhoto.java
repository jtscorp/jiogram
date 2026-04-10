package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhoto;
import io.jiogram.types.TelegramMethod;

public class SetMyProfilePhoto implements TelegramMethod<Boolean> {
    @JsonProperty("photo") private final InputProfilePhoto photo;

    @JsonCreator
    public SetMyProfilePhoto(
            @JsonProperty("photo") InputProfilePhoto photo
    ) {
        this.photo = photo;
    }

    public InputProfilePhoto photo() {
        return this.photo;
    }

    @Override
    public String apiMethod() {
        return "setMyProfilePhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
