package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaidMessagePriceChanged {
    @JsonProperty("paid_message_star_count") private final long paidMessageStarCount;

    @JsonCreator
    public PaidMessagePriceChanged(
            @JsonProperty("paid_message_star_count") long paidMessageStarCount
    ) {
        this.paidMessageStarCount = paidMessageStarCount;
    }

    public long paidMessageStarCount() {
        return this.paidMessageStarCount;
    }
}
