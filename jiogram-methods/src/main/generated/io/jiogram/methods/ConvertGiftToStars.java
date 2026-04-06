package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record ConvertGiftToStars(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("owned_gift_id") String ownedGiftId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "convertGiftToStars";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
