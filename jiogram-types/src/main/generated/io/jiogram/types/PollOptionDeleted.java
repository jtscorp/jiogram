package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record PollOptionDeleted(
    @JsonProperty("poll_message") @Nullable MaybeInaccessibleMessage pollMessage,
    @JsonProperty("option_persistent_id") String optionPersistentId,
    @JsonProperty("option_text") String optionText,
    @JsonProperty("option_text_entities") @Nullable List<MessageEntity> optionTextEntities
) {}
