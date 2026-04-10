package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Animation;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.PhotoSize;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class Game {
    @JsonProperty("title") private final String title;
    @JsonProperty("description") private final String description;
    @JsonProperty("photo") private final List<PhotoSize> photo;
    @JsonProperty("text") @Nullable private final String text;
    @JsonProperty("text_entities") @Nullable private final List<MessageEntity> textEntities;
    @JsonProperty("animation") @Nullable private final Animation animation;

    @JsonCreator
    public Game(
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("photo") List<PhotoSize> photo,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("text_entities") @Nullable List<MessageEntity> textEntities,
            @JsonProperty("animation") @Nullable Animation animation
    ) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.text = text;
        this.textEntities = textEntities;
        this.animation = animation;
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public List<PhotoSize> photo() {
        return this.photo;
    }

    public String text() {
        return this.text;
    }

    public List<MessageEntity> textEntities() {
        return this.textEntities;
    }

    public Animation animation() {
        return this.animation;
    }
}
