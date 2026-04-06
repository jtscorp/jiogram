package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PaidMessagePriceChanged(
    @JsonProperty("paid_message_star_count") long paidMessageStarCount
) {}
