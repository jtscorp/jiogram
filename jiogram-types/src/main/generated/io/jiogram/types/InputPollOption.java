package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputPollOption {
    @JsonProperty("text") private final String text;
    @JsonProperty("text_parse_mode") @Nullable private final ParseMode textParseMode;
    @JsonProperty("text_entities") @Nullable private final List<MessageEntity> textEntities;

    @JsonCreator
    public InputPollOption(
            @JsonProperty("text") String text,
            @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
    ) {
        this.text = text;
        this.textParseMode = textParseMode;
        this.textEntities = textEntities;
    }

    public String text() {
        return this.text;
    }

    public ParseMode textParseMode() {
        return this.textParseMode;
    }

    public List<MessageEntity> textEntities() {
        return this.textEntities;
    }
}
