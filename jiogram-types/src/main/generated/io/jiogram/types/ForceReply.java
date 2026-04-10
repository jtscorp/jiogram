package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class ForceReply implements ReplyMarkup {
    @JsonProperty("force_reply") private final boolean forceReply;
    @JsonProperty("input_field_placeholder") @Nullable private final String inputFieldPlaceholder;
    @JsonProperty("selective") @Nullable private final Boolean selective;

    @JsonCreator
    public ForceReply(
            @JsonProperty("force_reply") boolean forceReply,
            @JsonProperty("input_field_placeholder") @Nullable String inputFieldPlaceholder,
            @JsonProperty("selective") @Nullable Boolean selective
    ) {
        this.forceReply = forceReply;
        this.inputFieldPlaceholder = inputFieldPlaceholder;
        this.selective = selective;
    }

    public boolean forceReply() {
        return this.forceReply;
    }

    public String inputFieldPlaceholder() {
        return this.inputFieldPlaceholder;
    }

    public Boolean selective() {
        return this.selective;
    }
}
