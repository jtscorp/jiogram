package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record ForceReply(
    @JsonProperty("force_reply") boolean forceReply,
    @JsonProperty("input_field_placeholder") @Nullable String inputFieldPlaceholder,
    @JsonProperty("selective") @Nullable Boolean selective
) implements ReplyMarkup {}
