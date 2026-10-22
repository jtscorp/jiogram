package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AcceptedGiftTypes;
import io.jiogram.types.TelegramMethod;

/**
 * Changes the privacy settings pertaining to incoming gifts in a managed business account. Requires
 * the can_change_gift_settings business bot right. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param showGiftButton Pass True, if a button for sending a gift to the user or by the business
 *     account must always be shown in the input field
 * @param acceptedGiftTypes Types of gifts accepted by the business account
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountgiftsettings">setBusinessAccountGiftSettings in the Bot API</a>
 */
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

    public SetBusinessAccountGiftSettings withBusinessConnectionId(String businessConnectionId) {
        return new SetBusinessAccountGiftSettings(businessConnectionId, showGiftButton, acceptedGiftTypes);
    }

    public SetBusinessAccountGiftSettings withShowGiftButton(boolean showGiftButton) {
        return new SetBusinessAccountGiftSettings(businessConnectionId, showGiftButton, acceptedGiftTypes);
    }

    public SetBusinessAccountGiftSettings withAcceptedGiftTypes(AcceptedGiftTypes acceptedGiftTypes) {
        return new SetBusinessAccountGiftSettings(businessConnectionId, showGiftButton, acceptedGiftTypes);
    }
}
