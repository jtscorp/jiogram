package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public class PaidMediaPurchased {
    @JsonProperty("from") private final User from;
    @JsonProperty("paid_media_payload") private final String paidMediaPayload;

    @JsonCreator
    public PaidMediaPurchased(
            @JsonProperty("from") User from,
            @JsonProperty("paid_media_payload") String paidMediaPayload
    ) {
        this.from = from;
        this.paidMediaPayload = paidMediaPayload;
    }

    public User from() {
        return this.from;
    }

    public String paidMediaPayload() {
        return this.paidMediaPayload;
    }
}
