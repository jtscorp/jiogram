package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PassportElementErrorType {
    DATA("data"),
    FILE("file"),
    FILES("files"),
    FRONT_SIDE("front_side"),
    REVERSE_SIDE("reverse_side"),
    SELFIE("selfie"),
    TRANSLATION_FILE("translation_file"),
    TRANSLATION_FILES("translation_files"),
    UNSPECIFIED("unspecified"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

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
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
