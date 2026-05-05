package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputChecklistTask(
    @JsonProperty("id") long id,
    @JsonProperty("text") String text,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
) {}
