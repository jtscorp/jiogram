package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMedia;
import java.util.List;

public class PaidMediaInfo {
    @JsonProperty("star_count") private final long starCount;
    @JsonProperty("paid_media") private final List<PaidMedia> paidMedia;

    @JsonCreator
    public PaidMediaInfo(
            @JsonProperty("star_count") long starCount,
            @JsonProperty("paid_media") List<PaidMedia> paidMedia
    ) {
        this.starCount = starCount;
        this.paidMedia = paidMedia;
    }

    public long starCount() {
        return this.starCount;
    }

    public List<PaidMedia> paidMedia() {
        return this.paidMedia;
    }
}
