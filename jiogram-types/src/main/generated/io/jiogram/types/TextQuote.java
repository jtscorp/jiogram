package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record TextQuote(
    @JsonProperty("text") String text,
    @JsonProperty("entities") @Nullable List<MessageEntity> entities,
    @JsonProperty("position") long position,
    @JsonProperty("is_manual") @Nullable Boolean isManual
) {}
