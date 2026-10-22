package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a task in a checklist.
 *
 * @see <a href="https://core.telegram.org/bots/api#checklisttask">ChecklistTask in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChecklistTask {

    @JsonProperty("id")
    private final long id;

    @JsonProperty("text")
    private final String text;

    @JsonProperty("text_entities")
    private final @Nullable List<MessageEntity> textEntities;

    @JsonProperty("completed_by_user")
    private final @Nullable User completedByUser;

    @JsonProperty("completed_by_chat")
    private final @Nullable Chat completedByChat;

    @JsonProperty("completion_date")
    private final @Nullable Long completionDate;

    /**
     * Creates a new {@code ChecklistTask} instance.
     *
     * @param id Unique identifier of the task
     * @param text Text of the task
     * @param textEntities Special entities that appear in the task text
     * @param completedByUser User that completed the task; omitted if the task wasn't completed by
     *     a user
     * @param completedByChat Chat that completed the task; omitted if the task wasn't completed by
     *     a chat
     * @param completionDate Point in time (Unix timestamp) when the task was completed; 0 if the
     *     task wasn't completed
     */
    @JsonCreator
    public ChecklistTask(
            @JsonProperty("id") long id,
            @JsonProperty("text") String text,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
            @JsonProperty("completed_by_user") @Nullable User completedByUser,
            @JsonProperty("completed_by_chat") @Nullable Chat completedByChat,
            @JsonProperty("completion_date") @Nullable Long completionDate) {
        this.id = id;
        this.text = text;
        this.textEntities = textEntities;
        this.completedByUser = completedByUser;
        this.completedByChat = completedByChat;
        this.completionDate = completionDate;
    }

    public static ChecklistTask of(long id, String text) {
        return new ChecklistTask(id, text, null, null, null, null);
    }

    /**
     * Unique identifier of the task
     */
    public long id() {
        return id;
    }

    /**
     * Text of the task
     */
    public String text() {
        return text;
    }

    /**
     * Special entities that appear in the task text
     */
    public @Nullable List<MessageEntity> textEntities() {
        return textEntities;
    }

    /**
     * User that completed the task; omitted if the task wasn't completed by a user
     */
    public @Nullable User completedByUser() {
        return completedByUser;
    }

    /**
     * Chat that completed the task; omitted if the task wasn't completed by a chat
     */
    public @Nullable Chat completedByChat() {
        return completedByChat;
    }

    /**
     * Point in time (Unix timestamp) when the task was completed; 0 if the task wasn't completed
     */
    public @Nullable Long completionDate() {
        return completionDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChecklistTask)) {
            return false;
        }
        ChecklistTask that = (ChecklistTask) o;
        return this.id == that.id
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.textEntities, that.textEntities)
                && Objects.equals(this.completedByUser, that.completedByUser)
                && Objects.equals(this.completedByChat, that.completedByChat)
                && Objects.equals(this.completionDate, that.completionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.text, this.textEntities, this.completedByUser, this.completedByChat, this.completionDate);
    }

    @Override
    public String toString() {
        return "ChecklistTask[id=" + this.id
                + ", text=" + this.text
                + ", textEntities=" + this.textEntities
                + ", completedByUser=" + this.completedByUser
                + ", completedByChat=" + this.completedByChat
                + ", completionDate=" + this.completionDate
                + "]";
    }
}
