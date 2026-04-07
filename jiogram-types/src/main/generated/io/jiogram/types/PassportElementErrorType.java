package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PassportElementErrorType {
    TRANSLATION_FILES("translation_files"),
    FRONT_SIDE("front_side"),
    FILE("file"),
    TRANSLATION_FILE("translation_file"),
    REVERSE_SIDE("reverse_side"),
    FILES("files"),
    SELFIE("selfie"),
    DATA("data"),
    UNSPECIFIED("unspecified");

    private final String value;

    PassportElementErrorType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PassportElementErrorType fromValue(String value) {
        for (PassportElementErrorType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown PassportElementErrorType: " + value);
    }
}
