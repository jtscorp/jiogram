package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record ChatMemberOwner(
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
    @JsonProperty("user") User user,
    @JsonProperty("is_anonymous") boolean isAnonymous,
    @JsonProperty("custom_title") @Nullable String customTitle
) implements ChatMember {}
