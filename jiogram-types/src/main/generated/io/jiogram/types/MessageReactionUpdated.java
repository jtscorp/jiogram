package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ReactionType;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class MessageReactionUpdated {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("user") @Nullable private final User user;
    @JsonProperty("actor_chat") @Nullable private final Chat actorChat;
    @JsonProperty("date") private final long date;
    @JsonProperty("old_reaction") private final List<ReactionType> oldReaction;
    @JsonProperty("new_reaction") private final List<ReactionType> newReaction;

    @JsonCreator
    public MessageReactionUpdated(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("user") @Nullable User user,
            @JsonProperty("actor_chat") @Nullable Chat actorChat,
            @JsonProperty("date") long date,
            @JsonProperty("old_reaction") List<ReactionType> oldReaction,
            @JsonProperty("new_reaction") List<ReactionType> newReaction
    ) {
        this.chat = chat;
        this.messageId = messageId;
        this.user = user;
        this.actorChat = actorChat;
        this.date = date;
        this.oldReaction = oldReaction;
        this.newReaction = newReaction;
    }

    public Chat chat() {
        return this.chat;
    }

    public long messageId() {
        return this.messageId;
    }

    public User user() {
        return this.user;
    }

    public Chat actorChat() {
        return this.actorChat;
    }

    public long date() {
        return this.date;
    }

    public List<ReactionType> oldReaction() {
        return this.oldReaction;
    }

    public List<ReactionType> newReaction() {
        return this.newReaction;
    }
}
