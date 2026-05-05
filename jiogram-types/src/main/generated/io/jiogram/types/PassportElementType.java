package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PassportElementType {
    PERSONAL_DETAILS("personal_details"),
    PASSPORT("passport"),
    DRIVER_LICENSE("driver_license"),
    IDENTITY_CARD("identity_card"),
    INTERNAL_PASSPORT("internal_passport"),
    ADDRESS("address"),
    UTILITY_BILL("utility_bill"),
    BANK_STATEMENT("bank_statement"),
    RENTAL_AGREEMENT("rental_agreement"),
    PASSPORT_REGISTRATION("passport_registration"),
    TEMPORARY_REGISTRATION("temporary_registration"),
    PHONE_NUMBER("phone_number"),
    EMAIL("email");

    private final String value;

    PassportElementType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PassportElementType fromValue(String value) {
        for (PassportElementType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown PassportElementType: " + value);
    }
}
