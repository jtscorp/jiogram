package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record ChatMemberMember(
    @JsonProperty("status") ChatMemberType status,
    @JsonProperty("tag") @Nullable String tag,
    @JsonProperty("user") User user,
    @JsonProperty("until_date") @Nullable Long untilDate
) implements ChatMember {}
