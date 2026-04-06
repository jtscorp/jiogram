package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGift;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record OwnedGifts(
    @JsonProperty("total_count") long totalCount,
    @JsonProperty("gifts") List<OwnedGift> gifts,
    @JsonProperty("next_offset") @Nullable String nextOffset
) {}
