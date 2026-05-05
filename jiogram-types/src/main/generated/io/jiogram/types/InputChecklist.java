package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputChecklistTask;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputChecklist {
    @JsonProperty("title") private final String title;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("title_entities") @Nullable private final List<MessageEntity> titleEntities;
    @JsonProperty("tasks") private final List<InputChecklistTask> tasks;
    @JsonProperty("others_can_add_tasks") @Nullable private final Boolean othersCanAddTasks;
    @JsonProperty("others_can_mark_tasks_as_done") @Nullable private final Boolean othersCanMarkTasksAsDone;

    @JsonCreator
    public InputChecklist(
            @JsonProperty("title") String title,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("title_entities") @Nullable List<MessageEntity> titleEntities,
            @JsonProperty("tasks") List<InputChecklistTask> tasks,
            @JsonProperty("others_can_add_tasks") @Nullable Boolean othersCanAddTasks,
            @JsonProperty("others_can_mark_tasks_as_done") @Nullable Boolean othersCanMarkTasksAsDone
    ) {
        this.title = title;
        this.parseMode = parseMode;
        this.titleEntities = titleEntities;
        this.tasks = tasks;
        this.othersCanAddTasks = othersCanAddTasks;
        this.othersCanMarkTasksAsDone = othersCanMarkTasksAsDone;
    }

    public String title() {
        return this.title;
    }

    public ParseMode parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> titleEntities() {
        return this.titleEntities;
    }

    public List<InputChecklistTask> tasks() {
        return this.tasks;
    }

    public Boolean othersCanAddTasks() {
        return this.othersCanAddTasks;
    }

    public Boolean othersCanMarkTasksAsDone() {
        return this.othersCanMarkTasksAsDone;
    }
}
