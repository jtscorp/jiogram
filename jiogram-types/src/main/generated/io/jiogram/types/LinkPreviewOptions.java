package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Describes the options used for link preview generation.
 *
 * @param isDisabled True, if the link preview is disabled
 * @param url URL to use for the link preview. If empty, then the first URL found in the message
 *     text will be used
 * @param preferSmallMedia True, if the media in the link preview is supposed to be shrunk; ignored
 *     if the URL isn't explicitly specified or media size change isn't supported for the preview
 * @param preferLargeMedia True, if the media in the link preview is supposed to be enlarged;
 *     ignored if the URL isn't explicitly specified or media size change isn't supported for the
 *     preview
 * @param showAboveText True, if the link preview must be shown above the message text; otherwise,
 *     the link preview will be shown below the message text
 * @see <a href="https://core.telegram.org/bots/api#linkpreviewoptions">LinkPreviewOptions in the Bot API</a>
 */
public record LinkPreviewOptions(
    @JsonProperty("is_disabled") @Nullable Boolean isDisabled,
    @JsonProperty("url") @Nullable String url,
    @JsonProperty("prefer_small_media") @Nullable Boolean preferSmallMedia,
    @JsonProperty("prefer_large_media") @Nullable Boolean preferLargeMedia,
    @JsonProperty("show_above_text") @Nullable Boolean showAboveText
) {}
