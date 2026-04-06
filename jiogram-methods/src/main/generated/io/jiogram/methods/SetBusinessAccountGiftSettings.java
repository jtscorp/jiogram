package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AcceptedGiftTypes;
import io.jiogram.types.TelegramMethod;

public record SetBusinessAccountGiftSettings(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("show_gift_button") boolean showGiftButton,
    @JsonProperty("accepted_gift_types") AcceptedGiftTypes acceptedGiftTypes
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setBusinessAccountGiftSettings";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
