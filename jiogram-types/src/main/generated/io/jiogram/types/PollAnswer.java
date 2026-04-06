package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record PollAnswer(
    @JsonProperty("poll_id") String pollId,
    @JsonProperty("voter_chat") @Nullable Chat voterChat,
    @JsonProperty("user") @Nullable User user,
    @JsonProperty("option_ids") List<Long> optionIds,
    @JsonProperty("option_persistent_ids") List<String> optionPersistentIds
) {}
