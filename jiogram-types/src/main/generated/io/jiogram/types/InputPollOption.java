package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputPollOption {
    @JsonProperty("text") private final String text;
    @JsonProperty("text_parse_mode") @Nullable private final String textParseMode;
    @JsonProperty("text_entities") @Nullable private final List<MessageEntity> textEntities;

    @JsonCreator
    public InputPollOption(
            @JsonProperty("text") String text,
            @JsonProperty("text_parse_mode") @Nullable String textParseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
    ) {
        this.text = text;
        this.textParseMode = textParseMode;
        this.textEntities = textEntities;
    }

    public String text() {
        return this.text;
    }

    public String textParseMode() {
        return this.textParseMode;
    }

    public List<MessageEntity> textEntities() {
        return this.textEntities;
    }
}
