package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarAmount;
import io.jiogram.types.TelegramMethod;

/**
 * Returns the amount of Telegram Stars owned by a managed business account. Requires the
 * can_view_gifts_and_stars business bot right. Returns StarAmount on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @see <a href="https://core.telegram.org/bots/api#getbusinessaccountstarbalance">getBusinessAccountStarBalance in the Bot API</a>
 */
public record GetBusinessAccountStarBalance(
    @JsonProperty("business_connection_id") String businessConnectionId
) implements TelegramMethod<StarAmount> {

    @Override
    public String apiMethod() {
        return "getBusinessAccountStarBalance";
    }

    @Override
    public String apiReturnType() {
        return "StarAmount";
    }
}
