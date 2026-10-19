package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputStoryContentType;
import org.jspecify.annotations.Nullable;

public record InputStoryContentVideo(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputStoryContentType type,
    @JsonProperty("video") String video,
    @JsonProperty("duration") @Nullable Double duration,
    @JsonProperty("cover_frame_timestamp") @Nullable Double coverFrameTimestamp,
    @JsonProperty("is_animation") @Nullable Boolean isAnimation
) implements InputStoryContent {}
