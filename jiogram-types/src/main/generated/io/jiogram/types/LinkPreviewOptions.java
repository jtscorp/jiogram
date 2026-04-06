package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record LinkPreviewOptions(
    @JsonProperty("is_disabled") @Nullable Boolean isDisabled,
    @JsonProperty("url") @Nullable String url,
    @JsonProperty("prefer_small_media") @Nullable Boolean preferSmallMedia,
    @JsonProperty("prefer_large_media") @Nullable Boolean preferLargeMedia,
    @JsonProperty("show_above_text") @Nullable Boolean showAboveText
) {}
