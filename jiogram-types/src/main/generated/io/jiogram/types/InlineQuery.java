package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryChatType;
import io.jiogram.types.Location;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record InlineQuery(
    @JsonProperty("id") String id,
    @JsonProperty("from") User from,
    @JsonProperty("query") String query,
    @JsonProperty("offset") String offset,
    @JsonProperty("chat_type") @Nullable InlineQueryChatType chatType,
    @JsonProperty("location") @Nullable Location location
) {}
