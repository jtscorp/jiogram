package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import io.jiogram.types.PhotoSize;
import java.util.List;

public class PaidMediaPhoto implements PaidMedia {
    @JsonProperty("type") private final PaidMediaType type;
    @JsonProperty("photo") private final List<PhotoSize> photo;

    @JsonCreator
    public PaidMediaPhoto(
            @JsonProperty("type") PaidMediaType type,
            @JsonProperty("photo") List<PhotoSize> photo
    ) {
        this.type = type;
        this.photo = photo;
    }

    public PaidMediaType type() {
        return this.type;
    }

    public List<PhotoSize> photo() {
        return this.photo;
    }
}
