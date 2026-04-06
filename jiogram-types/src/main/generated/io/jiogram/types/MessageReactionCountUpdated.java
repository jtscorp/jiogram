package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ReactionCount;
import java.util.List;

public record MessageReactionCountUpdated(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("date") long date,
    @JsonProperty("reactions") List<ReactionCount> reactions
) {}
