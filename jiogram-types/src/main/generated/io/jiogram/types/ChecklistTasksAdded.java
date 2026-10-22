package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChecklistTask;
import io.jiogram.types.Message;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about tasks added to a checklist.
 *
 * @param checklistMessage Message containing the checklist to which the tasks were added. Note that
 *     the Message object in this field will not contain the reply_to_message field even if it
 *     itself is a reply.
 * @param tasks List of tasks added to the checklist
 * @see <a href="https://core.telegram.org/bots/api#checklisttasksadded">ChecklistTasksAdded in the Bot API</a>
 */
public record ChecklistTasksAdded(
    @JsonProperty("checklist_message") @Nullable Message checklistMessage,
    @JsonProperty("tasks") List<ChecklistTask> tasks
) {

    public ChecklistTasksAdded withChecklistMessage(@Nullable Message checklistMessage) {
        return new ChecklistTasksAdded(checklistMessage, tasks);
    }

    public ChecklistTasksAdded withTasks(List<ChecklistTask> tasks) {
        return new ChecklistTasksAdded(checklistMessage, tasks);
    }
}
