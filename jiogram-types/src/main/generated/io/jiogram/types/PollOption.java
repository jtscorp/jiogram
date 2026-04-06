package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record PollOption(
    @JsonProperty("persistent_id") String persistentId,
    @JsonProperty("text") String text,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
    @JsonProperty("voter_count") long voterCount,
    @JsonProperty("added_by_user") @Nullable User addedByUser,
    @JsonProperty("added_by_chat") @Nullable Chat addedByChat,
    @JsonProperty("addition_date") @Nullable Long additionDate
) {}
