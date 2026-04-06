package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMedia;
import java.util.List;

public record PaidMediaInfo(
    @JsonProperty("star_count") long starCount,
    @JsonProperty("paid_media") List<PaidMedia> paidMedia
) {}
