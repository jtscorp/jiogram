package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.StarAmount;
import org.jspecify.annotations.Nullable;

public record SuggestedPostPaid(
    @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
    @JsonProperty("currency") String currency,
    @JsonProperty("amount") @Nullable Long amount,
    @JsonProperty("star_amount") @Nullable StarAmount starAmount
) {}
