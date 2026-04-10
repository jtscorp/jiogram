package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import org.jspecify.annotations.Nullable;

public class SuggestedPostDeclined {
    @JsonProperty("suggested_post_message") @Nullable private final Message suggestedPostMessage;
    @JsonProperty("comment") @Nullable private final String comment;

    @JsonCreator
    public SuggestedPostDeclined(
            @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
            @JsonProperty("comment") @Nullable String comment
    ) {
        this.suggestedPostMessage = suggestedPostMessage;
        this.comment = comment;
    }

    public Message suggestedPostMessage() {
        return this.suggestedPostMessage;
    }

    public String comment() {
        return this.comment;
    }
}
