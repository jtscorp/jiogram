package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;

/**
 * Describes a withdrawal transaction to the Telegram Ads platform.
 *
 * @param type Type of the transaction partner, always 'telegram_ads'
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnertelegramads">TransactionPartnerTelegramAds in the Bot API</a>
 */
public record TransactionPartnerTelegramAds(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type
) implements TransactionPartner {

    public static TransactionPartnerTelegramAds of() {
        return new TransactionPartnerTelegramAds(TransactionPartnerType.TELEGRAM_ADS);
    }
}
