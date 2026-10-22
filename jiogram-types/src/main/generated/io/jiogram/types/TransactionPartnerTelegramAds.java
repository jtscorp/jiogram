package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;
import java.util.Objects;

/**
 * Describes a withdrawal transaction to the Telegram Ads platform.
 *
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnertelegramads">TransactionPartnerTelegramAds in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransactionPartnerTelegramAds implements TransactionPartner {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final TransactionPartnerType type;

    /**
     * Creates a new {@code TransactionPartnerTelegramAds} instance.
     *
     * @param type Type of the transaction partner, always 'telegram_ads'
     */
    @JsonCreator
    public TransactionPartnerTelegramAds(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type) {
        this.type = type;
    }

    public static TransactionPartnerTelegramAds of() {
        return new TransactionPartnerTelegramAds(TransactionPartnerType.TELEGRAM_ADS);
    }

    /**
     * Type of the transaction partner, always 'telegram_ads'
     */
    public TransactionPartnerType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionPartnerTelegramAds)) {
            return false;
        }
        TransactionPartnerTelegramAds that = (TransactionPartnerTelegramAds) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "TransactionPartnerTelegramAds[type=" + this.type
                + "]";
    }
}
