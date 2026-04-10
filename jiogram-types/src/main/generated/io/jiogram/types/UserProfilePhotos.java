package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;

public class UserProfilePhotos {
    @JsonProperty("total_count") private final long totalCount;
    @JsonProperty("photos") private final List<List<PhotoSize>> photos;

    @JsonCreator
    public UserProfilePhotos(
            @JsonProperty("total_count") long totalCount,
            @JsonProperty("photos") List<List<PhotoSize>> photos
    ) {
        this.totalCount = totalCount;
        this.photos = photos;
    }

    public long totalCount() {
        return this.totalCount;
    }

    public List<List<PhotoSize>> photos() {
        return this.photos;
    }
}
