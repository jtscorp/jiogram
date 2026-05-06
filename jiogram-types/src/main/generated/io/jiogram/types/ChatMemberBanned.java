package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;

public record ChatMemberBanned(
    @JsonProperty("status") ChatMemberType status,
    @JsonProperty("user") User user,
    @JsonProperty("until_date") long untilDate
) implements ChatMember {}
