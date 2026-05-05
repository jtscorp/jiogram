package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputPollOption(
    @JsonProperty("text") String text,
    @JsonProperty("text_parse_mode") @Nullable ParseMode textParseMode,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities
) {}
