package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about checklist tasks marked as done or not done.
 *
 * @see <a href="https://core.telegram.org/bots/api#checklisttasksdone">ChecklistTasksDone in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChecklistTasksDone {

    @JsonProperty("checklist_message")
    private final @Nullable Message checklistMessage;

    @JsonProperty("marked_as_done_task_ids")
    private final @Nullable List<Long> markedAsDoneTaskIds;

    @JsonProperty("marked_as_not_done_task_ids")
    private final @Nullable List<Long> markedAsNotDoneTaskIds;

    /**
     * Creates a new {@code ChecklistTasksDone} instance.
     *
     * @param checklistMessage Message containing the checklist whose tasks were marked as done or
     *     not done. Note that the Message object in this field will not contain the
     *     reply_to_message field even if it itself is a reply.
     * @param markedAsDoneTaskIds Identifiers of the tasks that were marked as done
     * @param markedAsNotDoneTaskIds Identifiers of the tasks that were marked as not done
     */
    @JsonCreator
    public ChecklistTasksDone(
            @JsonProperty("checklist_message") @Nullable Message checklistMessage,
            @JsonProperty("marked_as_done_task_ids") @Nullable List<Long> markedAsDoneTaskIds,
            @JsonProperty("marked_as_not_done_task_ids") @Nullable List<Long> markedAsNotDoneTaskIds) {
        this.checklistMessage = checklistMessage;
        this.markedAsDoneTaskIds = markedAsDoneTaskIds;
        this.markedAsNotDoneTaskIds = markedAsNotDoneTaskIds;
    }

    public static ChecklistTasksDone of() {
        return new ChecklistTasksDone(null, null, null);
    }

    /**
     * Message containing the checklist whose tasks were marked as done or not done. Note that the
     * Message object in this field will not contain the reply_to_message field even if it itself is
     * a reply.
     */
    public @Nullable Message checklistMessage() {
        return checklistMessage;
    }

    /**
     * Identifiers of the tasks that were marked as done
     */
    public @Nullable List<Long> markedAsDoneTaskIds() {
        return markedAsDoneTaskIds;
    }

    /**
     * Identifiers of the tasks that were marked as not done
     */
    public @Nullable List<Long> markedAsNotDoneTaskIds() {
        return markedAsNotDoneTaskIds;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChecklistTasksDone)) {
            return false;
        }
        ChecklistTasksDone that = (ChecklistTasksDone) o;
        return Objects.equals(this.checklistMessage, that.checklistMessage)
                && Objects.equals(this.markedAsDoneTaskIds, that.markedAsDoneTaskIds)
                && Objects.equals(this.markedAsNotDoneTaskIds, that.markedAsNotDoneTaskIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.checklistMessage, this.markedAsDoneTaskIds, this.markedAsNotDoneTaskIds);
    }

    @Override
    public String toString() {
        return "ChecklistTasksDone[checklistMessage=" + this.checklistMessage
                + ", markedAsDoneTaskIds=" + this.markedAsDoneTaskIds
                + ", markedAsNotDoneTaskIds=" + this.markedAsNotDoneTaskIds
                + "]";
    }
}
