package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class PollAnswer {
    @JsonProperty("poll_id") private final String pollId;
    @JsonProperty("voter_chat") @Nullable private final Chat voterChat;
    @JsonProperty("user") @Nullable private final User user;
    @JsonProperty("option_ids") private final List<Long> optionIds;
    @JsonProperty("option_persistent_ids") private final List<String> optionPersistentIds;

    @JsonCreator
    public PollAnswer(
            @JsonProperty("poll_id") String pollId,
            @JsonProperty("voter_chat") @Nullable Chat voterChat,
            @JsonProperty("user") @Nullable User user,
            @JsonProperty("option_ids") List<Long> optionIds,
            @JsonProperty("option_persistent_ids") List<String> optionPersistentIds
    ) {
        this.pollId = pollId;
        this.voterChat = voterChat;
        this.user = user;
        this.optionIds = optionIds;
        this.optionPersistentIds = optionPersistentIds;
    }

    public String pollId() {
        return this.pollId;
    }

    public Chat voterChat() {
        return this.voterChat;
    }

    public User user() {
        return this.user;
    }

    public List<Long> optionIds() {
        return this.optionIds;
    }

    public List<String> optionPersistentIds() {
        return this.optionPersistentIds;
    }
}
