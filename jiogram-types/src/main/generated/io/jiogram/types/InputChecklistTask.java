package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputChecklistTask {
    @JsonProperty("id") private final long id;
    @JsonProperty("text") private final String text;
    @JsonProperty("parse_mode") @Nullable private final String parseMode;
    @JsonProperty("text_entities") @Nullable private final List<MessageEntity> textEntities;

    @JsonCreator
    public InputChecklistTask(
            @JsonProperty("id") long id,
            @JsonProperty("text") String text,
            @JsonProperty("parse_mode") @Nullable String parseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
    ) {
        this.id = id;
        this.text = text;
        this.parseMode = parseMode;
        this.textEntities = textEntities;
    }

    public long id() {
        return this.id;
    }

    public String text() {
        return this.text;
    }

    public String parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> textEntities() {
        return this.textEntities;
    }
}
