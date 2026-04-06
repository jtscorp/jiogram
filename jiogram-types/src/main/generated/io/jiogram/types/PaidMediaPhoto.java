package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;

public record PaidMediaPhoto(
    @JsonProperty("type") String type,
    @JsonProperty("photo") List<PhotoSize> photo
) implements PaidMedia {}
