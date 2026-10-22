package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;
import java.util.Objects;

/**
 * Describes a transaction with an unknown source or recipient.
 *
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnerother">TransactionPartnerOther in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransactionPartnerOther implements TransactionPartner {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final TransactionPartnerType type;

    /**
     * Creates a new {@code TransactionPartnerOther} instance.
     *
     * @param type Type of the transaction partner, always 'other'
     */
    @JsonCreator
    public TransactionPartnerOther(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type) {
        this.type = type;
    }

    public static TransactionPartnerOther of() {
        return new TransactionPartnerOther(TransactionPartnerType.OTHER);
    }

    /**
     * Type of the transaction partner, always 'other'
     */
    public TransactionPartnerType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionPartnerOther)) {
            return false;
        }
        TransactionPartnerOther that = (TransactionPartnerOther) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "TransactionPartnerOther[type=" + this.type
                + "]";
    }
}
