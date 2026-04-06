package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record PaidMediaPurchased(
    @JsonProperty("from") User from,
    @JsonProperty("paid_media_payload") String paidMediaPayload
) {}
