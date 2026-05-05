package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhotoType;

public class InputProfilePhotoStatic implements InputProfilePhoto {
    @JsonProperty("type") private final InputProfilePhotoType type;
    @JsonProperty("photo") private final String photo;

    @JsonCreator
    public InputProfilePhotoStatic(
            @JsonProperty("type") InputProfilePhotoType type,
            @JsonProperty("photo") String photo
    ) {
        this.type = type;
        this.photo = photo;
    }

    public InputProfilePhotoType type() {
        return this.type;
    }

    public String photo() {
        return this.photo;
    }
}
