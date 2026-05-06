package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;
import io.jiogram.types.BackgroundTypeType;
import io.jiogram.types.Document;
import org.jspecify.annotations.Nullable;

public record BackgroundTypePattern(
    @JsonProperty("type") BackgroundTypeType type,
    @JsonProperty("document") Document document,
    @JsonProperty("fill") BackgroundFill fill,
    @JsonProperty("intensity") long intensity,
    @JsonProperty("is_inverted") @Nullable Boolean isInverted,
    @JsonProperty("is_moving") @Nullable Boolean isMoving
) implements BackgroundType {}
