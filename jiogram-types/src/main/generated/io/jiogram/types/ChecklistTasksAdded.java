package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChecklistTask;
import io.jiogram.types.Message;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ChecklistTasksAdded(
    @JsonProperty("checklist_message") @Nullable Message checklistMessage,
    @JsonProperty("tasks") List<ChecklistTask> tasks
) {}
