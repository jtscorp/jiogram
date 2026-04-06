package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record KeyboardButtonRequestManagedBot(
    @JsonProperty("request_id") long requestId,
    @JsonProperty("suggested_name") @Nullable String suggestedName,
    @JsonProperty("suggested_username") @Nullable String suggestedUsername
) {}
