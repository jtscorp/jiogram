package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputProfilePhotoType;
import org.jspecify.annotations.Nullable;

public record InputProfilePhotoAnimated(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputProfilePhotoType type,
    @JsonProperty("animation") InputFileOrString animation,
    @JsonProperty("main_frame_timestamp") @Nullable Double mainFrameTimestamp
) implements InputProfilePhoto {}
