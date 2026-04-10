package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputProfilePhotoStatic implements InputProfilePhoto {
    @JsonProperty("type") private final String type;
    @JsonProperty("photo") private final String photo;

    @JsonCreator
    public InputProfilePhotoStatic(
            @JsonProperty("type") String type,
            @JsonProperty("photo") String photo
    ) {
        this.type = type;
        this.photo = photo;
    }

    public String type() {
        return this.type;
    }

    public String photo() {
        return this.photo;
    }
}
