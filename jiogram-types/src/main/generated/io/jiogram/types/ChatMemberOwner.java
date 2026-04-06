package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record ChatMemberOwner(
    @JsonProperty("status") String status,
    @JsonProperty("user") User user,
    @JsonProperty("is_anonymous") boolean isAnonymous,
    @JsonProperty("custom_title") @Nullable String customTitle
) implements ChatMember {}
