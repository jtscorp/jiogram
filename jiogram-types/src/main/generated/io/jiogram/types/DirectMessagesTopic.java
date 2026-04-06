package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record DirectMessagesTopic(
    @JsonProperty("topic_id") long topicId,
    @JsonProperty("user") @Nullable User user
) {}
