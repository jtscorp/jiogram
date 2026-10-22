package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputChecklistTask;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a checklist to create.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputchecklist">InputChecklist in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputChecklist {

    @JsonProperty("title")
    private final String title;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("title_entities")
    private final @Nullable List<MessageEntity> titleEntities;

    @JsonProperty("tasks")
    private final List<InputChecklistTask> tasks;

    @JsonProperty("others_can_add_tasks")
    private final @Nullable Boolean othersCanAddTasks;

    @JsonProperty("others_can_mark_tasks_as_done")
    private final @Nullable Boolean othersCanMarkTasksAsDone;

    /**
     * Creates a new {@code InputChecklist} instance.
     *
     * @param title Title of the checklist; 1-255 characters after entities parsing
     * @param parseMode Mode for parsing entities in the title. See formatting options for more
     *     details.
     * @param titleEntities List of special entities that appear in the title, which can be
     *     specified instead of parse_mode. Currently, only bold, italic, underline, strikethrough,
     *     spoiler, custom_emoji, and date_time entities are allowed.
     * @param tasks List of 1-30 tasks in the checklist
     * @param othersCanAddTasks Pass True if other users can add tasks to the checklist
     * @param othersCanMarkTasksAsDone Pass True if other users can mark tasks as done or not done
     *     in the checklist
     */
    @JsonCreator
    public InputChecklist(
            @JsonProperty("title") String title,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("title_entities") @Nullable List<MessageEntity> titleEntities,
            @JsonProperty("tasks") List<InputChecklistTask> tasks,
            @JsonProperty("others_can_add_tasks") @Nullable Boolean othersCanAddTasks,
            @JsonProperty("others_can_mark_tasks_as_done") @Nullable Boolean othersCanMarkTasksAsDone) {
        this.title = title;
        this.parseMode = parseMode;
        this.titleEntities = titleEntities;
        this.tasks = tasks;
        this.othersCanAddTasks = othersCanAddTasks;
        this.othersCanMarkTasksAsDone = othersCanMarkTasksAsDone;
    }

    public static InputChecklist of(String title, List<InputChecklistTask> tasks) {
        return new InputChecklist(title, null, null, tasks, null, null);
    }

    /**
     * Title of the checklist; 1-255 characters after entities parsing
     */
    public String title() {
        return title;
    }

    /**
     * Mode for parsing entities in the title. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * List of special entities that appear in the title, which can be specified instead of
     * parse_mode. Currently, only bold, italic, underline, strikethrough, spoiler, custom_emoji,
     * and date_time entities are allowed.
     */
    public @Nullable List<MessageEntity> titleEntities() {
        return titleEntities;
    }

    /**
     * List of 1-30 tasks in the checklist
     */
    public List<InputChecklistTask> tasks() {
        return tasks;
    }

    /**
     * Pass True if other users can add tasks to the checklist
     */
    public @Nullable Boolean othersCanAddTasks() {
        return othersCanAddTasks;
    }

    /**
     * Pass True if other users can mark tasks as done or not done in the checklist
     */
    public @Nullable Boolean othersCanMarkTasksAsDone() {
        return othersCanMarkTasksAsDone;
    }

    public InputChecklist withTitle(String title) {
        return new InputChecklist(title, parseMode, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public InputChecklist withParseMode(@Nullable ParseMode parseMode) {
        return new InputChecklist(title, parseMode, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public InputChecklist withTitleEntities(@Nullable List<MessageEntity> titleEntities) {
        return new InputChecklist(title, parseMode, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public InputChecklist withTasks(List<InputChecklistTask> tasks) {
        return new InputChecklist(title, parseMode, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public InputChecklist withOthersCanAddTasks(@Nullable Boolean othersCanAddTasks) {
        return new InputChecklist(title, parseMode, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public InputChecklist withOthersCanMarkTasksAsDone(@Nullable Boolean othersCanMarkTasksAsDone) {
        return new InputChecklist(title, parseMode, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputChecklist)) {
            return false;
        }
        InputChecklist that = (InputChecklist) o;
        return Objects.equals(this.title, that.title)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.titleEntities, that.titleEntities)
                && Objects.equals(this.tasks, that.tasks)
                && Objects.equals(this.othersCanAddTasks, that.othersCanAddTasks)
                && Objects.equals(this.othersCanMarkTasksAsDone, that.othersCanMarkTasksAsDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.parseMode, this.titleEntities, this.tasks, this.othersCanAddTasks, this.othersCanMarkTasksAsDone);
    }

    @Override
    public String toString() {
        return "InputChecklist[title=" + this.title
                + ", parseMode=" + this.parseMode
                + ", titleEntities=" + this.titleEntities
                + ", tasks=" + this.tasks
                + ", othersCanAddTasks=" + this.othersCanAddTasks
                + ", othersCanMarkTasksAsDone=" + this.othersCanMarkTasksAsDone
                + "]";
    }
}
