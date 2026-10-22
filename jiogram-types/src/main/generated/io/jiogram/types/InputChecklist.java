package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputChecklistTask;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a checklist to create.
 *
 * @param title Title of the checklist; 1-255 characters after entities parsing
 * @param parseMode Mode for parsing entities in the title. See formatting options for more details.
 * @param titleEntities List of special entities that appear in the title, which can be specified
 *     instead of parse_mode. Currently, only bold, italic, underline, strikethrough, spoiler,
 *     custom_emoji, and date_time entities are allowed.
 * @param tasks List of 1-30 tasks in the checklist
 * @param othersCanAddTasks Pass True if other users can add tasks to the checklist
 * @param othersCanMarkTasksAsDone Pass True if other users can mark tasks as done or not done in
 *     the checklist
 * @see <a href="https://core.telegram.org/bots/api#inputchecklist">InputChecklist in the Bot API</a>
 */
public record InputChecklist(
    @JsonProperty("title") String title,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("title_entities") @Nullable List<MessageEntity> titleEntities,
    @JsonProperty("tasks") List<InputChecklistTask> tasks,
    @JsonProperty("others_can_add_tasks") @Nullable Boolean othersCanAddTasks,
    @JsonProperty("others_can_mark_tasks_as_done") @Nullable Boolean othersCanMarkTasksAsDone
) {

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
}
