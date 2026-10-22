package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AcceptedGiftTypes;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Changes the privacy settings pertaining to incoming gifts in a managed business account. Requires
 * the can_change_gift_settings business bot right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setbusinessaccountgiftsettings">setBusinessAccountGiftSettings in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetBusinessAccountGiftSettings implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("show_gift_button")
    private final boolean showGiftButton;

    @JsonProperty("accepted_gift_types")
    private final AcceptedGiftTypes acceptedGiftTypes;

    /**
     * Creates a new {@code SetBusinessAccountGiftSettings} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param showGiftButton Pass True, if a button for sending a gift to the user or by the
     *     business account must always be shown in the input field
     * @param acceptedGiftTypes Types of gifts accepted by the business account
     */
    @JsonCreator
    public SetBusinessAccountGiftSettings(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("show_gift_button") boolean showGiftButton,
            @JsonProperty("accepted_gift_types") AcceptedGiftTypes acceptedGiftTypes) {
        this.businessConnectionId = businessConnectionId;
        this.showGiftButton = showGiftButton;
        this.acceptedGiftTypes = acceptedGiftTypes;
    }

    @Override
    public String apiMethod() {
        return "setBusinessAccountGiftSettings";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Pass True, if a button for sending a gift to the user or by the business account must always
     * be shown in the input field
     */
    public boolean showGiftButton() {
        return showGiftButton;
    }

    /**
     * Types of gifts accepted by the business account
     */
    public AcceptedGiftTypes acceptedGiftTypes() {
        return acceptedGiftTypes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetBusinessAccountGiftSettings)) {
            return false;
        }
        SetBusinessAccountGiftSettings that = (SetBusinessAccountGiftSettings) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.showGiftButton == that.showGiftButton
                && Objects.equals(this.acceptedGiftTypes, that.acceptedGiftTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.showGiftButton, this.acceptedGiftTypes);
    }

    @Override
    public String toString() {
        return "SetBusinessAccountGiftSettings[businessConnectionId=" + this.businessConnectionId
                + ", showGiftButton=" + this.showGiftButton
                + ", acceptedGiftTypes=" + this.acceptedGiftTypes
                + "]";
    }
}
