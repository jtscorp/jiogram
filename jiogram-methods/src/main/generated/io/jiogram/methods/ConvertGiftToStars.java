package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Converts a given regular gift to Telegram Stars. Requires the can_convert_gifts_to_stars business
 * bot right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#convertgifttostars">convertGiftToStars in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ConvertGiftToStars implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("owned_gift_id")
    private final String ownedGiftId;

    /**
     * Creates a new {@code ConvertGiftToStars} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param ownedGiftId Unique identifier of the regular gift that should be converted to Telegram
     *     Stars
     */
    @JsonCreator
    public ConvertGiftToStars(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("owned_gift_id") String ownedGiftId) {
        this.businessConnectionId = businessConnectionId;
        this.ownedGiftId = ownedGiftId;
    }

    @Override
    public String apiMethod() {
        return "convertGiftToStars";
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
     * Unique identifier of the regular gift that should be converted to Telegram Stars
     */
    public String ownedGiftId() {
        return ownedGiftId;
    }

    public ConvertGiftToStars withBusinessConnectionId(String businessConnectionId) {
        return new ConvertGiftToStars(businessConnectionId, ownedGiftId);
    }

    public ConvertGiftToStars withOwnedGiftId(String ownedGiftId) {
        return new ConvertGiftToStars(businessConnectionId, ownedGiftId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConvertGiftToStars)) {
            return false;
        }
        ConvertGiftToStars that = (ConvertGiftToStars) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.ownedGiftId, that.ownedGiftId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.ownedGiftId);
    }

    @Override
    public String toString() {
        return "ConvertGiftToStars[businessConnectionId=" + this.businessConnectionId
                + ", ownedGiftId=" + this.ownedGiftId
                + "]";
    }
}
