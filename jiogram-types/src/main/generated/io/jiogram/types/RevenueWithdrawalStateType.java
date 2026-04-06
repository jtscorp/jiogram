package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RevenueWithdrawalStateType {
    PENDING("pending"),
    SUCCEEDED("succeeded"),
    FAILED("failed");

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
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown RevenueWithdrawalStateType: " + value);
    }
}
