package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes the options used for link preview generation.
 *
 * @see <a href="https://core.telegram.org/bots/api#linkpreviewoptions">LinkPreviewOptions in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class LinkPreviewOptions {

    @JsonProperty("is_disabled")
    private final @Nullable Boolean isDisabled;

    @JsonProperty("url")
    private final @Nullable String url;

    @JsonProperty("prefer_small_media")
    private final @Nullable Boolean preferSmallMedia;

    @JsonProperty("prefer_large_media")
    private final @Nullable Boolean preferLargeMedia;

    @JsonProperty("show_above_text")
    private final @Nullable Boolean showAboveText;

    /**
     * Creates a new {@code LinkPreviewOptions} instance.
     *
     * @param isDisabled True, if the link preview is disabled
     * @param url URL to use for the link preview. If empty, then the first URL found in the message
     *     text will be used
     * @param preferSmallMedia True, if the media in the link preview is supposed to be shrunk;
     *     ignored if the URL isn't explicitly specified or media size change isn't supported for
     *     the preview
     * @param preferLargeMedia True, if the media in the link preview is supposed to be enlarged;
     *     ignored if the URL isn't explicitly specified or media size change isn't supported for
     *     the preview
     * @param showAboveText True, if the link preview must be shown above the message text;
     *     otherwise, the link preview will be shown below the message text
     */
    @JsonCreator
    public LinkPreviewOptions(
            @JsonProperty("is_disabled") @Nullable Boolean isDisabled,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("prefer_small_media") @Nullable Boolean preferSmallMedia,
            @JsonProperty("prefer_large_media") @Nullable Boolean preferLargeMedia,
            @JsonProperty("show_above_text") @Nullable Boolean showAboveText) {
        this.isDisabled = isDisabled;
        this.url = url;
        this.preferSmallMedia = preferSmallMedia;
        this.preferLargeMedia = preferLargeMedia;
        this.showAboveText = showAboveText;
    }

    public static LinkPreviewOptions of() {
        return new LinkPreviewOptions(null, null, null, null, null);
    }

    /**
     * True, if the link preview is disabled
     */
    public @Nullable Boolean isDisabled() {
        return isDisabled;
    }

    /**
     * URL to use for the link preview. If empty, then the first URL found in the message text will
     * be used
     */
    public @Nullable String url() {
        return url;
    }

    /**
     * True, if the media in the link preview is supposed to be shrunk; ignored if the URL isn't
     * explicitly specified or media size change isn't supported for the preview
     */
    public @Nullable Boolean preferSmallMedia() {
        return preferSmallMedia;
    }

    /**
     * True, if the media in the link preview is supposed to be enlarged; ignored if the URL isn't
     * explicitly specified or media size change isn't supported for the preview
     */
    public @Nullable Boolean preferLargeMedia() {
        return preferLargeMedia;
    }

    /**
     * True, if the link preview must be shown above the message text; otherwise, the link preview
     * will be shown below the message text
     */
    public @Nullable Boolean showAboveText() {
        return showAboveText;
    }

    public LinkPreviewOptions withIsDisabled(@Nullable Boolean isDisabled) {
        return new LinkPreviewOptions(isDisabled, url, preferSmallMedia, preferLargeMedia, showAboveText);
    }

    public LinkPreviewOptions withUrl(@Nullable String url) {
        return new LinkPreviewOptions(isDisabled, url, preferSmallMedia, preferLargeMedia, showAboveText);
    }

    public LinkPreviewOptions withPreferSmallMedia(@Nullable Boolean preferSmallMedia) {
        return new LinkPreviewOptions(isDisabled, url, preferSmallMedia, preferLargeMedia, showAboveText);
    }

    public LinkPreviewOptions withPreferLargeMedia(@Nullable Boolean preferLargeMedia) {
        return new LinkPreviewOptions(isDisabled, url, preferSmallMedia, preferLargeMedia, showAboveText);
    }

    public LinkPreviewOptions withShowAboveText(@Nullable Boolean showAboveText) {
        return new LinkPreviewOptions(isDisabled, url, preferSmallMedia, preferLargeMedia, showAboveText);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkPreviewOptions)) {
            return false;
        }
        LinkPreviewOptions that = (LinkPreviewOptions) o;
        return Objects.equals(this.isDisabled, that.isDisabled)
                && Objects.equals(this.url, that.url)
                && Objects.equals(this.preferSmallMedia, that.preferSmallMedia)
                && Objects.equals(this.preferLargeMedia, that.preferLargeMedia)
                && Objects.equals(this.showAboveText, that.showAboveText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.isDisabled, this.url, this.preferSmallMedia, this.preferLargeMedia, this.showAboveText);
    }

    @Override
    public String toString() {
        return "LinkPreviewOptions[isDisabled=" + this.isDisabled
                + ", url=" + this.url
                + ", preferSmallMedia=" + this.preferSmallMedia
                + ", preferLargeMedia=" + this.preferLargeMedia
                + ", showAboveText=" + this.showAboveText
                + "]";
    }
}
