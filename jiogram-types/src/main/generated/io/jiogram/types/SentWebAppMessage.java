package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class SentWebAppMessage {
    @JsonProperty("inline_message_id") @Nullable private final String inlineMessageId;

    @JsonCreator
    public SentWebAppMessage(
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId
    ) {
        this.inlineMessageId = inlineMessageId;
    }

    public String inlineMessageId() {
        return this.inlineMessageId;
    }
}
