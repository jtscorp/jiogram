package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;

/**
 * Describes a transaction with an unknown source or recipient.
 *
 * @param type Type of the transaction partner, always 'other'
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnerother">TransactionPartnerOther in the Bot API</a>
 */
public record TransactionPartnerOther(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type
) implements TransactionPartner {

    public static TransactionPartnerOther of() {
        return new TransactionPartnerOther(TransactionPartnerType.OTHER);
    }
}
