package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Transfers Telegram Stars from the business account balance to the bot's balance. Requires the
 * can_transfer_stars business bot right. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param starCount Number of Telegram Stars to transfer; 1-10000
 * @see <a href="https://core.telegram.org/bots/api#transferbusinessaccountstars">transferBusinessAccountStars in the Bot API</a>
 */
public record TransferBusinessAccountStars(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("star_count") long starCount
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "transferBusinessAccountStars";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public TransferBusinessAccountStars withBusinessConnectionId(String businessConnectionId) {
        return new TransferBusinessAccountStars(businessConnectionId, starCount);
    }

    public TransferBusinessAccountStars withStarCount(long starCount) {
        return new TransferBusinessAccountStars(businessConnectionId, starCount);
    }
}
