package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ReactionCount;
import java.util.List;

public class MessageReactionCountUpdated {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("date") private final long date;
    @JsonProperty("reactions") private final List<ReactionCount> reactions;

    @JsonCreator
    public MessageReactionCountUpdated(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("date") long date,
            @JsonProperty("reactions") List<ReactionCount> reactions
    ) {
        this.chat = chat;
        this.messageId = messageId;
        this.date = date;
        this.reactions = reactions;
    }

    public Chat chat() {
        return this.chat;
    }

    public long messageId() {
        return this.messageId;
    }

    public long date() {
        return this.date;
    }

    public List<ReactionCount> reactions() {
        return this.reactions;
    }
}
