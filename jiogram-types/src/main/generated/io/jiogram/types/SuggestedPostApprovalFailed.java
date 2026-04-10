package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

public class SuggestedPostApprovalFailed {
    @JsonProperty("suggested_post_message") @Nullable private final Message suggestedPostMessage;
    @JsonProperty("price") private final SuggestedPostPrice price;

    @JsonCreator
    public SuggestedPostApprovalFailed(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("price") SuggestedPostPrice price
    ) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.price = price;
    }

    public Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public SuggestedPostPrice price() {
        return this.price;
    }
}
