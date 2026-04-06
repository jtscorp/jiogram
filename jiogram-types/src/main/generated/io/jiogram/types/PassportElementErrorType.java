package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PassportElementErrorType {
    SELFIE("selfie"),
    FILES("files"),
    REVERSE_SIDE("reverse_side"),
    TRANSLATION_FILE("translation_file"),
    FILE("file"),
    FRONT_SIDE("front_side"),
    TRANSLATION_FILES("translation_files"),
    UNSPECIFIED("unspecified"),
    DATA("data");

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
