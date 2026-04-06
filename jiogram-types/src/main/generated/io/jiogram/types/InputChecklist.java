package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputChecklistTask;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputChecklist(
    @JsonProperty("title") String title,
    @JsonProperty("parse_mode") @Nullable String parseMode,
    @JsonProperty("title_entities") @Nullable List<MessageEntity> titleEntities,
    @JsonProperty("tasks") List<InputChecklistTask> tasks,
    @JsonProperty("others_can_add_tasks") @Nullable Boolean othersCanAddTasks,
    @JsonProperty("others_can_mark_tasks_as_done") @Nullable Boolean othersCanMarkTasksAsDone
) {}
