package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhotoType;
import org.jspecify.annotations.Nullable;

public class InputProfilePhotoAnimated implements InputProfilePhoto {
    @JsonProperty("type") private final InputProfilePhotoType type;
    @JsonProperty("animation") private final String animation;
    @JsonProperty("main_frame_timestamp") @Nullable private final Double mainFrameTimestamp;

    @JsonCreator
    public InputProfilePhotoAnimated(
            @JsonProperty("type") InputProfilePhotoType type,
            @JsonProperty("animation") String animation,
            @JsonProperty("main_frame_timestamp") @Nullable Double mainFrameTimestamp
    ) {
        this.type = type;
        this.animation = animation;
        this.mainFrameTimestamp = mainFrameTimestamp;
    }

    public InputProfilePhotoType type() {
        return this.type;
    }

    public String animation() {
        return this.animation;
    }

    public Double mainFrameTimestamp() {
        return this.mainFrameTimestamp;
    }
}
