package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class InputStoryContentVideo implements InputStoryContent {
    @JsonProperty("type") private final String type;
    @JsonProperty("video") private final String video;
    @JsonProperty("duration") @Nullable private final Double duration;
    @JsonProperty("cover_frame_timestamp") @Nullable private final Double coverFrameTimestamp;
    @JsonProperty("is_animation") @Nullable private final Boolean isAnimation;

    @JsonCreator
    public InputStoryContentVideo(
            @JsonProperty("type") String type,
            @JsonProperty("video") String video,
            @JsonProperty("duration") @Nullable Double duration,
            @JsonProperty("cover_frame_timestamp") @Nullable Double coverFrameTimestamp,
            @JsonProperty("is_animation") @Nullable Boolean isAnimation
    ) {
        this.type = type;
        this.video = video;
        this.duration = duration;
        this.coverFrameTimestamp = coverFrameTimestamp;
        this.isAnimation = isAnimation;
    }

    public String type() {
        return this.type;
    }

    public String video() {
        return this.video;
    }

    public Double duration() {
        return this.duration;
    }

    public Double coverFrameTimestamp() {
        return this.coverFrameTimestamp;
    }

    public Boolean isAnimation() {
        return this.isAnimation;
    }
}
