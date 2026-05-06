package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentMimeType {
    APPLICATION_PDF("application/pdf"),
    APPLICATION_ZIP("application/zip");

    private final String value;

    DocumentMimeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static DocumentMimeType fromValue(String value) {
        for (DocumentMimeType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown DocumentMimeType: " + value);
    }
}
