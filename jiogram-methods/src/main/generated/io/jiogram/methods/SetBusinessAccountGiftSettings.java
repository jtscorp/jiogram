package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AcceptedGiftTypes;
import io.jiogram.types.TelegramMethod;

public class SetBusinessAccountGiftSettings implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("show_gift_button") private final boolean showGiftButton;
    @JsonProperty("accepted_gift_types") private final AcceptedGiftTypes acceptedGiftTypes;

    @JsonCreator
    public SetBusinessAccountGiftSettings(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("show_gift_button") boolean showGiftButton,
            @JsonProperty("accepted_gift_types") AcceptedGiftTypes acceptedGiftTypes
    ) {
        this.businessConnectionId = businessConnectionId;
        this.showGiftButton = showGiftButton;
        this.acceptedGiftTypes = acceptedGiftTypes;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public boolean showGiftButton() {
        return this.showGiftButton;
    }

    public AcceptedGiftTypes acceptedGiftTypes() {
        return this.acceptedGiftTypes;
    }

    @Override
    public String apiMethod() {
        return "setBusinessAccountGiftSettings";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
