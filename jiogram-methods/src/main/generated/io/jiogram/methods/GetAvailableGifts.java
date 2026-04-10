package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gifts;
import io.jiogram.types.TelegramMethod;

public class GetAvailableGifts implements TelegramMethod<Gifts> {
    @JsonCreator
    public GetAvailableGifts() {
    }

    @Override
    public String apiMethod() {
        return "getAvailableGifts";
    }

    @Override
    public String apiReturnType() {
        return "Gifts";
    }
}
