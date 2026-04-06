package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionPartnerType {
    OTHER("other"),
    CHAT("chat"),
    FRAGMENT("fragment"),
    TELEGRAM_API("telegram_api"),
    TELEGRAM_ADS("telegram_ads"),
    USER("user"),
    AFFILIATE_PROGRAM("affiliate_program");

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
