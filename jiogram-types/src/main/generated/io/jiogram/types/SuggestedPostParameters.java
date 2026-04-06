package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

public record SuggestedPostParameters(
    @JsonProperty("price") @Nullable SuggestedPostPrice price,
    @JsonProperty("send_date") @Nullable Long sendDate
) {}
