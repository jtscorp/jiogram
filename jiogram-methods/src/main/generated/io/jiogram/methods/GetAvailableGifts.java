package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gifts;
import io.jiogram.types.TelegramMethod;

public record GetAvailableGifts(

) implements TelegramMethod<Gifts> {

    @Override
    public String apiMethod() {
        return "getAvailableGifts";
    }

    @Override
    public String apiReturnType() {
        return "Gifts";
    }
}
