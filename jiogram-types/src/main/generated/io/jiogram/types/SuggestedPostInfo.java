package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

public class SuggestedPostInfo {
    @JsonProperty("state") private final String state;
    @JsonProperty("price") @Nullable private final SuggestedPostPrice price;
    @JsonProperty("send_date") @Nullable private final Long sendDate;

    @JsonCreator
    public SuggestedPostInfo(
            @JsonProperty("state") String state,
            @JsonProperty("price") @Nullable SuggestedPostPrice price,
            @JsonProperty("send_date") @Nullable Long sendDate
    ) {
        this.state = state;
        this.price = price;
        this.sendDate = sendDate;
    }

    public String state() {
        return this.state;
    }

    public SuggestedPostPrice price() {
        return this.price;
    }

    public Long sendDate() {
        return this.sendDate;
    }
}
