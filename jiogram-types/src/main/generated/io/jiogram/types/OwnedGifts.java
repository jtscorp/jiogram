package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGift;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class OwnedGifts {
    @JsonProperty("total_count") private final long totalCount;
    @JsonProperty("gifts") private final List<OwnedGift> gifts;
    @JsonProperty("next_offset") @Nullable private final String nextOffset;

    @JsonCreator
    public OwnedGifts(
            @JsonProperty("total_count") long totalCount,
            @JsonProperty("gifts") List<OwnedGift> gifts,
            @JsonProperty("next_offset") @Nullable String nextOffset
    ) {
        this.totalCount = totalCount;
        this.gifts = gifts;
        this.nextOffset = nextOffset;
    }

    public long totalCount() {
        return this.totalCount;
    }

    public List<OwnedGift> gifts() {
        return this.gifts;
    }

    public String nextOffset() {
        return this.nextOffset;
    }
}
