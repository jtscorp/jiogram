package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;
import io.jiogram.types.Document;
import org.jspecify.annotations.Nullable;

public class BackgroundTypePattern implements BackgroundType {
    @JsonProperty("type") private final String type;
    @JsonProperty("document") private final Document document;
    @JsonProperty("fill") private final BackgroundFill fill;
    @JsonProperty("intensity") private final long intensity;
    @JsonProperty("is_inverted") @Nullable private final Boolean isInverted;
    @JsonProperty("is_moving") @Nullable private final Boolean isMoving;

    @JsonCreator
    public BackgroundTypePattern(
            @JsonProperty("type") String type,
            @JsonProperty("document") Document document,
            @JsonProperty("fill") BackgroundFill fill,
            @JsonProperty("intensity") long intensity,
            @JsonProperty("is_inverted") @Nullable Boolean isInverted,
            @JsonProperty("is_moving") @Nullable Boolean isMoving
    ) {
        this.type = type;
        this.document = document;
        this.fill = fill;
        this.intensity = intensity;
        this.isInverted = isInverted;
        this.isMoving = isMoving;
    }

    public String type() {
        return this.type;
    }

    public Document document() {
        return this.document;
    }

    public BackgroundFill fill() {
        return this.fill;
    }

    public long intensity() {
        return this.intensity;
    }

    public Boolean isInverted() {
        return this.isInverted;
    }

    public Boolean isMoving() {
        return this.isMoving;
    }
}
