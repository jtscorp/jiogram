package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Discriminator values for BackgroundFill.
 */
public enum BackgroundFillType {
    FREEFORM_GRADIENT("freeform_gradient"),
    GRADIENT("gradient"),
    SOLID("solid"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    BackgroundFillType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static BackgroundFillType fromValue(String value) {
        for (BackgroundFillType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
