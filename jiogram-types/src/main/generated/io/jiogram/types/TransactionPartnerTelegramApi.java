package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;

/**
 * Describes a transaction with payment for paid broadcasting.
 *
 * @param type Type of the transaction partner, always 'telegram_api'
 * @param requestCount The number of successful requests that exceeded regular limits and were
 *     therefore billed
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnertelegramapi">TransactionPartnerTelegramApi in the Bot API</a>
 */
public record TransactionPartnerTelegramApi(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
    @JsonProperty("request_count") long requestCount
) implements TransactionPartner {

    public static TransactionPartnerTelegramApi of(long requestCount) {
        return new TransactionPartnerTelegramApi(TransactionPartnerType.TELEGRAM_API, requestCount);
    }

    public TransactionPartnerTelegramApi withRequestCount(long requestCount) {
        return new TransactionPartnerTelegramApi(type, requestCount);
    }
}
