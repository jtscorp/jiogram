package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;
import java.util.Objects;

/**
 * Describes a transaction with payment for paid broadcasting.
 *
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnertelegramapi">TransactionPartnerTelegramApi in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransactionPartnerTelegramApi implements TransactionPartner {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final TransactionPartnerType type;

    @JsonProperty("request_count")
    private final long requestCount;

    /**
     * Creates a new {@code TransactionPartnerTelegramApi} instance.
     *
     * @param type Type of the transaction partner, always 'telegram_api'
     * @param requestCount The number of successful requests that exceeded regular limits and were
     *     therefore billed
     */
    @JsonCreator
    public TransactionPartnerTelegramApi(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
            @JsonProperty("request_count") long requestCount) {
        this.type = type;
        this.requestCount = requestCount;
    }

    public static TransactionPartnerTelegramApi of(long requestCount) {
        return new TransactionPartnerTelegramApi(TransactionPartnerType.TELEGRAM_API, requestCount);
    }

    /**
     * Type of the transaction partner, always 'telegram_api'
     */
    public TransactionPartnerType type() {
        return type;
    }

    /**
     * The number of successful requests that exceeded regular limits and were therefore billed
     */
    public long requestCount() {
        return requestCount;
    }

    public TransactionPartnerTelegramApi withRequestCount(long requestCount) {
        return new TransactionPartnerTelegramApi(type, requestCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionPartnerTelegramApi)) {
            return false;
        }
        TransactionPartnerTelegramApi that = (TransactionPartnerTelegramApi) o;
        return Objects.equals(this.type, that.type)
                && this.requestCount == that.requestCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.requestCount);
    }

    @Override
    public String toString() {
        return "TransactionPartnerTelegramApi[type=" + this.type
                + ", requestCount=" + this.requestCount
                + "]";
    }
}
