package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record InputStoryContentVideo(
    @JsonProperty("type") String type,
    @JsonProperty("video") String video,
    @JsonProperty("duration") @Nullable Double duration,
    @JsonProperty("cover_frame_timestamp") @Nullable Double coverFrameTimestamp,
    @JsonProperty("is_animation") @Nullable Boolean isAnimation
) implements InputStoryContent {}
