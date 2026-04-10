package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class PollOption {
    @JsonProperty("persistent_id") private final String persistentId;
    @JsonProperty("text") private final String text;
    @JsonProperty("text_entities") @Nullable private final List<MessageEntity> textEntities;
    @JsonProperty("voter_count") private final long voterCount;
    @JsonProperty("added_by_user") @Nullable private final User addedByUser;
    @JsonProperty("added_by_chat") @Nullable private final Chat addedByChat;
    @JsonProperty("addition_date") @Nullable private final Long additionDate;

    @JsonCreator
    public PollOption(
            @JsonProperty("persistent_id") String persistentId,
            @JsonProperty("text") String text,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
            @JsonProperty("voter_count") long voterCount,
            @JsonProperty("added_by_user") @Nullable User addedByUser,
            @JsonProperty("added_by_chat") @Nullable Chat addedByChat,
            @JsonProperty("addition_date") @Nullable Long additionDate
    ) {
        this.persistentId = persistentId;
        this.text = text;
        this.textEntities = textEntities;
        this.voterCount = voterCount;
        this.addedByUser = addedByUser;
        this.addedByChat = addedByChat;
        this.additionDate = additionDate;
    }

    public String persistentId() {
        return this.persistentId;
    }

    public String text() {
        return this.text;
    }

    public List<MessageEntity> textEntities() {
        return this.textEntities;
    }

    public long voterCount() {
        return this.voterCount;
    }

    public User addedByUser() {
        return this.addedByUser;
    }

    public Chat addedByChat() {
        return this.addedByChat;
    }

    public Long additionDate() {
        return this.additionDate;
    }
}
