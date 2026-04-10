package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class ChecklistTask {
    @JsonProperty("id") private final long id;
    @JsonProperty("text") private final String text;
    @JsonProperty("text_entities") @Nullable private final List<MessageEntity> textEntities;
    @JsonProperty("completed_by_user") @Nullable private final User completedByUser;
    @JsonProperty("completed_by_chat") @Nullable private final Chat completedByChat;
    @JsonProperty("completion_date") @Nullable private final Long completionDate;

    @JsonCreator
    public ChecklistTask(
            @JsonProperty("id") long id,
            @JsonProperty("text") String text,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
            @JsonProperty("completed_by_user") @Nullable User completedByUser,
            @JsonProperty("completed_by_chat") @Nullable Chat completedByChat,
            @JsonProperty("completion_date") @Nullable Long completionDate
    ) {
        this.id = id;
        this.text = text;
        this.textEntities = textEntities;
        this.completedByUser = completedByUser;
        this.completedByChat = completedByChat;
        this.completionDate = completionDate;
    }

    public long id() {
        return this.id;
    }

    public String text() {
        return this.text;
    }

    public List<MessageEntity> textEntities() {
        return this.textEntities;
    }

    public User completedByUser() {
        return this.completedByUser;
    }

    public Chat completedByChat() {
        return this.completedByChat;
    }

    public Long completionDate() {
        return this.completionDate;
    }
}
