package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Discriminator values for RevenueWithdrawalState.
 */
public enum RevenueWithdrawalStateType {
    FAILED("failed"),
    PENDING("pending"),
    SUCCEEDED("succeeded"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    RevenueWithdrawalStateType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static RevenueWithdrawalStateType fromValue(String value) {
        for (RevenueWithdrawalStateType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
