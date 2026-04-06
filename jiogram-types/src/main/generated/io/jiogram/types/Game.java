package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Animation;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record Game(
    @JsonProperty("title") String title,
    @JsonProperty("description") String description,
    @JsonProperty("photo") List<PhotoSize> photo,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
    @JsonProperty("animation") @Nullable Animation animation
) {}
