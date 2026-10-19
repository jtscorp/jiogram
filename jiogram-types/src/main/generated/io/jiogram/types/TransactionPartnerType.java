package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionPartnerType {
    AFFILIATE_PROGRAM("affiliate_program"),
    CHAT("chat"),
    FRAGMENT("fragment"),
    OTHER("other"),
    TELEGRAM_ADS("telegram_ads"),
    TELEGRAM_API("telegram_api"),
    USER("user"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    TransactionPartnerType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static TransactionPartnerType fromValue(String value) {
        for (TransactionPartnerType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
