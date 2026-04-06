package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarAmount;
import io.jiogram.types.TelegramMethod;

public record GetMyStarBalance(

) implements TelegramMethod<StarAmount> {

    @Override
    public String apiMethod() {
        return "getMyStarBalance";
    }

    @Override
    public String apiReturnType() {
        return "StarAmount";
    }
}
