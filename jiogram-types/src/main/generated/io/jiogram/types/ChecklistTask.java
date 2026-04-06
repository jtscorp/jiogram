package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ChecklistTask(
    @JsonProperty("id") long id,
    @JsonProperty("text") String text,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
    @JsonProperty("completed_by_user") @Nullable User completedByUser,
    @JsonProperty("completed_by_chat") @Nullable Chat completedByChat,
    @JsonProperty("completion_date") @Nullable Long completionDate
) {}
