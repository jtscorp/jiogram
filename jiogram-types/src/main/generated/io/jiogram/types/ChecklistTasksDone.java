package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ChecklistTasksDone(
    @JsonProperty("checklist_message") @Nullable Message checklistMessage,
    @JsonProperty("marked_as_done_task_ids") @Nullable List<Long> markedAsDoneTaskIds,
    @JsonProperty("marked_as_not_done_task_ids") @Nullable List<Long> markedAsNotDoneTaskIds
) {}
