package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about checklist tasks marked as done or not done.
 *
 * @param checklistMessage Message containing the checklist whose tasks were marked as done or not
 *     done. Note that the Message object in this field will not contain the reply_to_message field
 *     even if it itself is a reply.
 * @param markedAsDoneTaskIds Identifiers of the tasks that were marked as done
 * @param markedAsNotDoneTaskIds Identifiers of the tasks that were marked as not done
 * @see <a href="https://core.telegram.org/bots/api#checklisttasksdone">ChecklistTasksDone in the Bot API</a>
 */
public record ChecklistTasksDone(
    @JsonProperty("checklist_message") @Nullable Message checklistMessage,
    @JsonProperty("marked_as_done_task_ids") @Nullable List<Long> markedAsDoneTaskIds,
    @JsonProperty("marked_as_not_done_task_ids") @Nullable List<Long> markedAsNotDoneTaskIds
) {

    public static ChecklistTasksDone of() {
        return new ChecklistTasksDone(null, null, null);
    }

    public ChecklistTasksDone withChecklistMessage(@Nullable Message checklistMessage) {
        return new ChecklistTasksDone(checklistMessage, markedAsDoneTaskIds, markedAsNotDoneTaskIds);
    }

    public ChecklistTasksDone withMarkedAsDoneTaskIds(@Nullable List<Long> markedAsDoneTaskIds) {
        return new ChecklistTasksDone(checklistMessage, markedAsDoneTaskIds, markedAsNotDoneTaskIds);
    }

    public ChecklistTasksDone withMarkedAsNotDoneTaskIds(@Nullable List<Long> markedAsNotDoneTaskIds) {
        return new ChecklistTasksDone(checklistMessage, markedAsDoneTaskIds, markedAsNotDoneTaskIds);
    }
}
