package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostPrice;
import org.jspecify.annotations.Nullable;

public class SuggestedPostApproved {
    @JsonProperty("suggested_post_message") @Nullable private final Message suggestedPostMessage;
    @JsonProperty("price") @Nullable private final SuggestedPostPrice price;
    @JsonProperty("send_date") private final long sendDate;

    @JsonCreator
    public SuggestedPostApproved(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("price") @Nullable SuggestedPostPrice price,
            @JsonProperty("send_date") long sendDate
    ) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.price = price;
        this.sendDate = sendDate;
    }

    public Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public SuggestedPostPrice price() {
        return this.price;
    }

    public long sendDate() {
        return this.sendDate;
    }
}
