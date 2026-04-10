package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarAmount;
import io.jiogram.types.TelegramMethod;

public class GetMyStarBalance implements TelegramMethod<StarAmount> {
    @JsonCreator
    public GetMyStarBalance() {
    }

    @Override
    public String apiMethod() {
        return "getMyStarBalance";
    }

    @Override
    public String apiReturnType() {
        return "StarAmount";
    }
}
