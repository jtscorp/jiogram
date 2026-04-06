package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record SentWebAppMessage(
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId
) {}
