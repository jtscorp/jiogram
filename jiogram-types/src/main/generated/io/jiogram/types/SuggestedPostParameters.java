package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

public class SuggestedPostParameters {
    @JsonProperty("price") @Nullable private final SuggestedPostPrice price;
    @JsonProperty("send_date") @Nullable private final Long sendDate;

    @JsonCreator
    public SuggestedPostParameters(
            @JsonProperty("price") @Nullable SuggestedPostPrice price,
            @JsonProperty("send_date") @Nullable Long sendDate
    ) {
        this.price = price;
        this.sendDate = sendDate;
    }

    public SuggestedPostPrice price() {
        return this.price;
    }

    public Long sendDate() {
        return this.sendDate;
    }
}
