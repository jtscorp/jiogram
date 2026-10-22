package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChecklistTask;
import io.jiogram.types.Message;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about tasks added to a checklist.
 *
 * @see <a href="https://core.telegram.org/bots/api#checklisttasksadded">ChecklistTasksAdded in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChecklistTasksAdded {

    @JsonProperty("checklist_message")
    private final @Nullable Message checklistMessage;

    @JsonProperty("tasks")
    private final List<ChecklistTask> tasks;

    /**
     * Creates a new {@code ChecklistTasksAdded} instance.
     *
     * @param checklistMessage Message containing the checklist to which the tasks were added. Note
     *     that the Message object in this field will not contain the reply_to_message field even if
     *     it itself is a reply.
     * @param tasks List of tasks added to the checklist
     */
    @JsonCreator
    public ChecklistTasksAdded(
            @JsonProperty("checklist_message") @Nullable Message checklistMessage,
            @JsonProperty("tasks") List<ChecklistTask> tasks) {
        this.checklistMessage = checklistMessage;
        this.tasks = tasks;
    }

    public static ChecklistTasksAdded of(List<ChecklistTask> tasks) {
        return new ChecklistTasksAdded(null, tasks);
    }

    /**
     * Message containing the checklist to which the tasks were added. Note that the Message object
     * in this field will not contain the reply_to_message field even if it itself is a reply.
     */
    public @Nullable Message checklistMessage() {
        return checklistMessage;
    }

    /**
     * List of tasks added to the checklist
     */
    public List<ChecklistTask> tasks() {
        return tasks;
    }

    public ChecklistTasksAdded withChecklistMessage(@Nullable Message checklistMessage) {
        return new ChecklistTasksAdded(checklistMessage, tasks);
    }

    public ChecklistTasksAdded withTasks(List<ChecklistTask> tasks) {
        return new ChecklistTasksAdded(checklistMessage, tasks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChecklistTasksAdded)) {
            return false;
        }
        ChecklistTasksAdded that = (ChecklistTasksAdded) o;
        return Objects.equals(this.checklistMessage, that.checklistMessage)
                && Objects.equals(this.tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.checklistMessage, this.tasks);
    }

    @Override
    public String toString() {
        return "ChecklistTasksAdded[checklistMessage=" + this.checklistMessage
                + ", tasks=" + this.tasks
                + "]";
    }
}
