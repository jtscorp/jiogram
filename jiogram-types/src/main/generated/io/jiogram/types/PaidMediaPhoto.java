package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;

public class PaidMediaPhoto implements PaidMedia {
    @JsonProperty("type") private final String type;
    @JsonProperty("photo") private final List<PhotoSize> photo;

    @JsonCreator
    public PaidMediaPhoto(
            @JsonProperty("type") String type,
            @JsonProperty("photo") List<PhotoSize> photo
    ) {
        this.type = type;
        this.photo = photo;
    }

    public String type() {
        return this.type;
    }

    public List<PhotoSize> photo() {
        return this.photo;
    }
}
