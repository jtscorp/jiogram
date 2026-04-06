package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChecklistTask;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record Checklist(
    @JsonProperty("title") String title,
    @JsonProperty("title_entities") @Nullable List<MessageEntity> titleEntities,
    @JsonProperty("tasks") List<ChecklistTask> tasks,
    @JsonProperty("others_can_add_tasks") @Nullable Boolean othersCanAddTasks,
    @JsonProperty("others_can_mark_tasks_as_done") @Nullable Boolean othersCanMarkTasksAsDone
) {}
