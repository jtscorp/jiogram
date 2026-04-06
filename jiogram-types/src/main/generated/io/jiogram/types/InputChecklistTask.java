package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputChecklistTask(
    @JsonProperty("id") long id,
    @JsonProperty("text") String text,
    @JsonProperty("parse_mode") @Nullable String parseMode,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
) {}
