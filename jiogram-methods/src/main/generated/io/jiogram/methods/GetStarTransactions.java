package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarTransactions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Returns the bot's Telegram Star transactions in chronological order. On success, returns a
 * StarTransactions object.
 *
 * @param offset Number of transactions to skip in the response
 * @param limit The maximum number of transactions to be retrieved. Values between 1-100 are
 *     accepted. Defaults to 100.
 * @see <a href="https://core.telegram.org/bots/api#getstartransactions">getStarTransactions in the Bot API</a>
 */
public record GetStarTransactions(
    @JsonProperty("offset") @Nullable Long offset,
    @JsonProperty("limit") @Nullable Long limit
) implements TelegramMethod<StarTransactions> {

    @Override
    public String apiMethod() {
        return "getStarTransactions";
    }

    @Override
    public String apiReturnType() {
        return "StarTransactions";
    }

    public static GetStarTransactions of() {
        return new GetStarTransactions(null, null);
    }

    public GetStarTransactions withOffset(@Nullable Long offset) {
        return new GetStarTransactions(offset, limit);
    }

    public GetStarTransactions withLimit(@Nullable Long limit) {
        return new GetStarTransactions(offset, limit);
    }
}
