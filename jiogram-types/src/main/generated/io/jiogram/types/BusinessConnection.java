package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessBotRights;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record BusinessConnection(
    @JsonProperty("id") String id,
    @JsonProperty("user") User user,
    @JsonProperty("user_chat_id") long userChatId,
    @JsonProperty("date") long date,
    @JsonProperty("rights") @Nullable BusinessBotRights rights,
    @JsonProperty("is_enabled") boolean isEnabled
) {}
