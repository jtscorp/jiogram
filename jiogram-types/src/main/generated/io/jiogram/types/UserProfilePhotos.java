package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;

public record UserProfilePhotos(
    @JsonProperty("total_count") long totalCount,
    @JsonProperty("photos") List<List<PhotoSize>> photos
) {}
