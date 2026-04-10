package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class ChecklistTasksDone {
    @JsonProperty("checklist_message") @Nullable private final Message checklistMessage;
    @JsonProperty("marked_as_done_task_ids") @Nullable private final List<Long> markedAsDoneTaskIds;
    @JsonProperty("marked_as_not_done_task_ids") @Nullable private final List<Long> markedAsNotDoneTaskIds;

    @JsonCreator
    public ChecklistTasksDone(
            @JsonProperty("checklist_message") @Nullable Message checklistMessage,
            @JsonProperty("marked_as_done_task_ids") @Nullable List<Long> markedAsDoneTaskIds,
            @JsonProperty("marked_as_not_done_task_ids") @Nullable List<Long> markedAsNotDoneTaskIds
    ) {
        this.checklistMessage = checklistMessage;
        this.markedAsDoneTaskIds = markedAsDoneTaskIds;
        this.markedAsNotDoneTaskIds = markedAsNotDoneTaskIds;
    }

    public Message checklistMessage() {
        return this.checklistMessage;
    }

    public List<Long> markedAsDoneTaskIds() {
        return this.markedAsDoneTaskIds;
    }

    public List<Long> markedAsNotDoneTaskIds() {
        return this.markedAsNotDoneTaskIds;
    }
}
