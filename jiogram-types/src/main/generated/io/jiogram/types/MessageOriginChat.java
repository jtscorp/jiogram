package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import org.jspecify.annotations.Nullable;

public record MessageOriginChat(
    @JsonProperty("type") String type,
    @JsonProperty("date") long date,
    @JsonProperty("sender_chat") Chat senderChat,
    @JsonProperty("author_signature") @Nullable String authorSignature
) implements MessageOrigin {}
