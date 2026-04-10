package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import org.jspecify.annotations.Nullable;

public class SuggestedPostRefunded {
    @JsonProperty("suggested_post_message") @Nullable private final Message suggestedPostMessage;
    @JsonProperty("reason") private final String reason;

    @JsonCreator
    public SuggestedPostRefunded(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("reason") String reason
    ) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.reason = reason;
    }

    public Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public String reason() {
        return this.reason;
    }
}
