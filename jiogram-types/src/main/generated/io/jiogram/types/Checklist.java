package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChecklistTask;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class Checklist {
    @JsonProperty("title") private final String title;
    @JsonProperty("title_entities") @Nullable private final List<MessageEntity> titleEntities;
    @JsonProperty("tasks") private final List<ChecklistTask> tasks;
    @JsonProperty("others_can_add_tasks") @Nullable private final Boolean othersCanAddTasks;
    @JsonProperty("others_can_mark_tasks_as_done") @Nullable private final Boolean othersCanMarkTasksAsDone;

    @JsonCreator
    public Checklist(
            @JsonProperty("title") String title,
            @JsonProperty("title_entities") @Nullable List<MessageEntity> titleEntities,
            @JsonProperty("tasks") List<ChecklistTask> tasks,
            @JsonProperty("others_can_add_tasks") @Nullable Boolean othersCanAddTasks,
            @JsonProperty("others_can_mark_tasks_as_done") @Nullable Boolean othersCanMarkTasksAsDone
    ) {
        this.title = title;
        this.titleEntities = titleEntities;
        this.tasks = tasks;
        this.othersCanAddTasks = othersCanAddTasks;
        this.othersCanMarkTasksAsDone = othersCanMarkTasksAsDone;
    }

    public String title() {
        return this.title;
    }

    public List<MessageEntity> titleEntities() {
        return this.titleEntities;
    }

    public List<ChecklistTask> tasks() {
        return this.tasks;
    }

    public Boolean othersCanAddTasks() {
        return this.othersCanAddTasks;
    }

    public Boolean othersCanMarkTasksAsDone() {
        return this.othersCanMarkTasksAsDone;
    }
}
