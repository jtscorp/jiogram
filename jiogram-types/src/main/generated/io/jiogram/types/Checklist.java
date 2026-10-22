package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChecklistTask;
import io.jiogram.types.MessageEntity;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a checklist.
 *
 * @see <a href="https://core.telegram.org/bots/api#checklist">Checklist in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Checklist {

    @JsonProperty("title")
    private final String title;

    @JsonProperty("title_entities")
    private final @Nullable List<MessageEntity> titleEntities;

    @JsonProperty("tasks")
    private final List<ChecklistTask> tasks;

    @JsonProperty("others_can_add_tasks")
    private final @Nullable Boolean othersCanAddTasks;

    @JsonProperty("others_can_mark_tasks_as_done")
    private final @Nullable Boolean othersCanMarkTasksAsDone;

    /**
     * Creates a new {@code Checklist} instance.
     *
     * @param title Title of the checklist
     * @param titleEntities Special entities that appear in the checklist title
     * @param tasks List of tasks in the checklist
     * @param othersCanAddTasks True, if users other than the creator of the list can add tasks to
     *     the list
     * @param othersCanMarkTasksAsDone True, if users other than the creator of the list can mark
     *     tasks as done or not done
     */
    @JsonCreator
    public Checklist(
            @JsonProperty("title") String title,
            @JsonProperty("title_entities") @Nullable List<MessageEntity> titleEntities,
            @JsonProperty("tasks") List<ChecklistTask> tasks,
            @JsonProperty("others_can_add_tasks") @Nullable Boolean othersCanAddTasks,
            @JsonProperty("others_can_mark_tasks_as_done") @Nullable Boolean othersCanMarkTasksAsDone) {
        this.title = title;
        this.titleEntities = titleEntities;
        this.tasks = tasks;
        this.othersCanAddTasks = othersCanAddTasks;
        this.othersCanMarkTasksAsDone = othersCanMarkTasksAsDone;
    }

    public static Checklist of(String title, List<ChecklistTask> tasks) {
        return new Checklist(title, null, tasks, null, null);
    }

    /**
     * Title of the checklist
     */
    public String title() {
        return title;
    }

    /**
     * Special entities that appear in the checklist title
     */
    public @Nullable List<MessageEntity> titleEntities() {
        return titleEntities;
    }

    /**
     * List of tasks in the checklist
     */
    public List<ChecklistTask> tasks() {
        return tasks;
    }

    /**
     * True, if users other than the creator of the list can add tasks to the list
     */
    public @Nullable Boolean othersCanAddTasks() {
        return othersCanAddTasks;
    }

    /**
     * True, if users other than the creator of the list can mark tasks as done or not done
     */
    public @Nullable Boolean othersCanMarkTasksAsDone() {
        return othersCanMarkTasksAsDone;
    }

    public Checklist withTitle(String title) {
        return new Checklist(title, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public Checklist withTitleEntities(@Nullable List<MessageEntity> titleEntities) {
        return new Checklist(title, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public Checklist withTasks(List<ChecklistTask> tasks) {
        return new Checklist(title, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public Checklist withOthersCanAddTasks(@Nullable Boolean othersCanAddTasks) {
        return new Checklist(title, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    public Checklist withOthersCanMarkTasksAsDone(@Nullable Boolean othersCanMarkTasksAsDone) {
        return new Checklist(title, titleEntities, tasks, othersCanAddTasks, othersCanMarkTasksAsDone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Checklist)) {
            return false;
        }
        Checklist that = (Checklist) o;
        return Objects.equals(this.title, that.title)
                && Objects.equals(this.titleEntities, that.titleEntities)
                && Objects.equals(this.tasks, that.tasks)
                && Objects.equals(this.othersCanAddTasks, that.othersCanAddTasks)
                && Objects.equals(this.othersCanMarkTasksAsDone, that.othersCanMarkTasksAsDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.titleEntities, this.tasks, this.othersCanAddTasks, this.othersCanMarkTasksAsDone);
    }

    @Override
    public String toString() {
        return "Checklist[title=" + this.title
                + ", titleEntities=" + this.titleEntities
                + ", tasks=" + this.tasks
                + ", othersCanAddTasks=" + this.othersCanAddTasks
                + ", othersCanMarkTasksAsDone=" + this.othersCanMarkTasksAsDone
                + "]";
    }
}
