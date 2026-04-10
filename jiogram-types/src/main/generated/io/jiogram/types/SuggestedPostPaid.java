package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.StarAmount;
import org.jspecify.annotations.Nullable;

public class SuggestedPostPaid {
    @JsonProperty("suggested_post_message") @Nullable private final Message suggestedPostMessage;
    @JsonProperty("currency") private final String currency;
    @JsonProperty("amount") @Nullable private final Long amount;
    @JsonProperty("star_amount") @Nullable private final StarAmount starAmount;

    @JsonCreator
    public SuggestedPostPaid(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("currency") String currency,
            @JsonProperty("amount") @Nullable Long amount,
            @JsonProperty("star_amount") @Nullable StarAmount starAmount
    ) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.currency = currency;
        this.amount = amount;
        this.starAmount = starAmount;
    }

    public Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public String currency() {
        return this.currency;
    }

    public Long amount() {
        return this.amount;
    }

    public StarAmount starAmount() {
        return this.starAmount;
    }
}
