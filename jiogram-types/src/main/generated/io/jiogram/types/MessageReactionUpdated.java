package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ReactionType;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record MessageReactionUpdated(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("user") @Nullable User user,
    @JsonProperty("actor_chat") @Nullable Chat actorChat,
    @JsonProperty("date") long date,
    @JsonProperty("old_reaction") List<ReactionType> oldReaction,
    @JsonProperty("new_reaction") List<ReactionType> newReaction
) {}
