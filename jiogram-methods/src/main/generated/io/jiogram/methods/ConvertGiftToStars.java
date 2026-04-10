package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class ConvertGiftToStars implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("owned_gift_id") private final String ownedGiftId;

    @JsonCreator
    public ConvertGiftToStars(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("owned_gift_id") String ownedGiftId
    ) {
        this.businessConnectionId = businessConnectionId;
        this.ownedGiftId = ownedGiftId;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public String ownedGiftId() {
        return this.ownedGiftId;
    }

    @Override
    public String apiMethod() {
        return "convertGiftToStars";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
