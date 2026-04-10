package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class TextQuote {
    @JsonProperty("text") private final String text;
    @JsonProperty("entities") @Nullable private final List<MessageEntity> entities;
    @JsonProperty("position") private final long position;
    @JsonProperty("is_manual") @Nullable private final Boolean isManual;

    @JsonCreator
    public TextQuote(
            @JsonProperty("text") String text,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities,
            @JsonProperty("position") long position,
            @JsonProperty("is_manual") @Nullable Boolean isManual
    ) {
        this.text = text;
        this.entities = entities;
        this.position = position;
        this.isManual = isManual;
    }

    public String text() {
        return this.text;
    }

    public List<MessageEntity> entities() {
        return this.entities;
    }

    public long position() {
        return this.position;
    }

    public Boolean isManual() {
        return this.isManual;
    }
}
