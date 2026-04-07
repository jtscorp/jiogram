package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionPartnerType {
    TELEGRAM_API("telegram_api"),
    FRAGMENT("fragment"),
    CHAT("chat"),
    OTHER("other"),
    AFFILIATE_PROGRAM("affiliate_program"),
    USER("user"),
    TELEGRAM_ADS("telegram_ads");

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
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown TransactionPartnerType: " + value);
    }
}
