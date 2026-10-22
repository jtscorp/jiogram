package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a task in a checklist.
 *
 * @param id Unique identifier of the task
 * @param text Text of the task
 * @param textEntities Special entities that appear in the task text
 * @param completedByUser User that completed the task; omitted if the task wasn't completed by a
 *     user
 * @param completedByChat Chat that completed the task; omitted if the task wasn't completed by a
 *     chat
 * @param completionDate Point in time (Unix timestamp) when the task was completed; 0 if the task
 *     wasn't completed
 * @see <a href="https://core.telegram.org/bots/api#checklisttask">ChecklistTask in the Bot API</a>
 */
public record ChecklistTask(
    @JsonProperty("id") long id,
    @JsonProperty("text") String text,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
    @JsonProperty("completed_by_user") @Nullable User completedByUser,
    @JsonProperty("completed_by_chat") @Nullable Chat completedByChat,
    @JsonProperty("completion_date") @Nullable Long completionDate
) {

    public static ChecklistTask of(long id, String text) {
        return new ChecklistTask(id, text, null, null, null, null);
    }

    public ChecklistTask withId(long id) {
        return new ChecklistTask(id, text, textEntities, completedByUser, completedByChat, completionDate);
    }

    public ChecklistTask withText(String text) {
        return new ChecklistTask(id, text, textEntities, completedByUser, completedByChat, completionDate);
    }

    public ChecklistTask withTextEntities(@Nullable List<MessageEntity> textEntities) {
        return new ChecklistTask(id, text, textEntities, completedByUser, completedByChat, completionDate);
    }

    public ChecklistTask withCompletedByUser(@Nullable User completedByUser) {
        return new ChecklistTask(id, text, textEntities, completedByUser, completedByChat, completionDate);
    }

    public ChecklistTask withCompletedByChat(@Nullable Chat completedByChat) {
        return new ChecklistTask(id, text, textEntities, completedByUser, completedByChat, completionDate);
    }

    public ChecklistTask withCompletionDate(@Nullable Long completionDate) {
        return new ChecklistTask(id, text, textEntities, completedByUser, completedByChat, completionDate);
    }
}
