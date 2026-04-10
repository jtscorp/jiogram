package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class PollOptionDeleted {
    @JsonProperty("poll_message") @Nullable private final MaybeInaccessibleMessage pollMessage;
    @JsonProperty("option_persistent_id") private final String optionPersistentId;
    @JsonProperty("option_text") private final String optionText;
    @JsonProperty("option_text_entities") @Nullable private final List<MessageEntity> optionTextEntities;

    @JsonCreator
    public PollOptionDeleted(
            @JsonProperty("poll_message") @Nullable MaybeInaccessibleMessage pollMessage,
            @JsonProperty("option_persistent_id") String optionPersistentId,
            @JsonProperty("option_text") String optionText,
            @JsonProperty("option_text_entities") @Nullable List<MessageEntity> optionTextEntities
    ) {
        this.pollMessage = pollMessage;
        this.optionPersistentId = optionPersistentId;
        this.optionText = optionText;
        this.optionTextEntities = optionTextEntities;
    }

    public MaybeInaccessibleMessage pollMessage() {
        return this.pollMessage;
    }

    public String optionPersistentId() {
        return this.optionPersistentId;
    }

    public String optionText() {
        return this.optionText;
    }

    public List<MessageEntity> optionTextEntities() {
        return this.optionTextEntities;
    }
}
