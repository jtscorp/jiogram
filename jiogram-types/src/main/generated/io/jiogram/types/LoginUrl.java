package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record LoginUrl(
    @JsonProperty("url") String url,
    @JsonProperty("forward_text") @Nullable String forwardText,
    @JsonProperty("bot_username") @Nullable String botUsername,
    @JsonProperty("request_write_access") @Nullable Boolean requestWriteAccess
) {}
