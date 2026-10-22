package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of transaction with a user.
 */
public enum TransactionType {
    INVOICE_PAYMENT("invoice_payment"),
    PAID_MEDIA_PAYMENT("paid_media_payment"),
    GIFT_PURCHASE("gift_purchase"),
    PREMIUM_PURCHASE("premium_purchase"),
    BUSINESS_ACCOUNT_TRANSFER("business_account_transfer"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static TransactionType fromValue(String value) {
        for (TransactionType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
