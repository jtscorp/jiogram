package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChecklistTask;
import io.jiogram.types.Message;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class ChecklistTasksAdded {
    @JsonProperty("checklist_message") @Nullable private final Message checklistMessage;
    @JsonProperty("tasks") private final List<ChecklistTask> tasks;

    @JsonCreator
    public ChecklistTasksAdded(
            @JsonProperty("checklist_message") @Nullable Message checklistMessage,
            @JsonProperty("tasks") List<ChecklistTask> tasks
    ) {
        this.checklistMessage = checklistMessage;
        this.tasks = tasks;
    }

    public Message checklistMessage() {
        return this.checklistMessage;
    }

    public List<ChecklistTask> tasks() {
        return this.tasks;
    }
}
