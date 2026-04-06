package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record ResponseParameters(
    @JsonProperty("migrate_to_chat_id") @Nullable Long migrateToChatId,
    @JsonProperty("retry_after") @Nullable Long retryAfter
) {}
