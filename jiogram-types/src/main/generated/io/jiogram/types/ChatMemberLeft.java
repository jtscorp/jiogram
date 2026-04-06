package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record ChatMemberLeft(
    @JsonProperty("status") String status,
    @JsonProperty("user") User user
) implements ChatMember {}
