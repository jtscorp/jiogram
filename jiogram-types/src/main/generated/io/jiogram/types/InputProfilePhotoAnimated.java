package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputProfilePhotoType;
import org.jspecify.annotations.Nullable;

public record InputProfilePhotoAnimated(
    @JsonProperty("type") InputProfilePhotoType type,
    @JsonProperty("animation") String animation,
    @JsonProperty("main_frame_timestamp") @Nullable Double mainFrameTimestamp
) implements InputProfilePhoto {}
