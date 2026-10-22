package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Converts a given regular gift to Telegram Stars. Requires the can_convert_gifts_to_stars business
 * bot right. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param ownedGiftId Unique identifier of the regular gift that should be converted to Telegram
 *     Stars
 * @see <a href="https://core.telegram.org/bots/api#convertgifttostars">convertGiftToStars in the Bot API</a>
 */
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

    public ConvertGiftToStars withBusinessConnectionId(String businessConnectionId) {
        return new ConvertGiftToStars(businessConnectionId, ownedGiftId);
    }

    public ConvertGiftToStars withOwnedGiftId(String ownedGiftId) {
        return new ConvertGiftToStars(businessConnectionId, ownedGiftId);
    }
}
