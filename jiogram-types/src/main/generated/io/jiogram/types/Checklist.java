package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChecklistTask;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a checklist.
 *
 * @param title Title of the checklist
 * @param titleEntities Special entities that appear in the checklist title
 * @param tasks List of tasks in the checklist
 * @param othersCanAddTasks True, if users other than the creator of the list can add tasks to the
 *     list
 * @param othersCanMarkTasksAsDone True, if users other than the creator of the list can mark tasks
 *     as done or not done
 * @see <a href="https://core.telegram.org/bots/api#checklist">Checklist in the Bot API</a>
 */
public record Checklist(
    @JsonProperty("title") String title,
    @JsonProperty("title_entities") @Nullable List<MessageEntity> titleEntities,
    @JsonProperty("tasks") List<ChecklistTask> tasks,
    @JsonProperty("others_can_add_tasks") @Nullable Boolean othersCanAddTasks,
    @JsonProperty("others_can_mark_tasks_as_done") @Nullable Boolean othersCanMarkTasksAsDone
) {}
