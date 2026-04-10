package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class DirectMessagesTopic {
    @JsonProperty("topic_id") private final long topicId;
    @JsonProperty("user") @Nullable private final User user;

    @JsonCreator
    public DirectMessagesTopic(
            @JsonProperty("topic_id") long topicId,
            @JsonProperty("user") @Nullable User user
    ) {
        this.topicId = topicId;
        this.user = user;
    }

    public long topicId() {
        return this.topicId;
    }

    public User user() {
        return this.user;
    }
}
