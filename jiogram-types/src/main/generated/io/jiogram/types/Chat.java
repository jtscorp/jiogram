package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatType;
import org.jspecify.annotations.Nullable;

public record Chat(
    @JsonProperty("id") long id,
    @JsonProperty("type") ChatType type,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("username") @Nullable String username,
    @JsonProperty("first_name") @Nullable String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("is_forum") @Nullable Boolean isForum,
    @JsonProperty("is_direct_messages") @Nullable Boolean isDirectMessages
) {}
