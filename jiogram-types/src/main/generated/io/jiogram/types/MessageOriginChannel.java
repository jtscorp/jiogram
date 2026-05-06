package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageOriginType;
import org.jspecify.annotations.Nullable;

public record MessageOriginChannel(
    @JsonProperty("type") MessageOriginType type,
    @JsonProperty("date") long date,
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("author_signature") @Nullable String authorSignature
) implements MessageOrigin {}
