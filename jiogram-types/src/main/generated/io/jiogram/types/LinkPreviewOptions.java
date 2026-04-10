package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class LinkPreviewOptions {
    @JsonProperty("is_disabled") @Nullable private final Boolean isDisabled;
    @JsonProperty("url") @Nullable private final String url;
    @JsonProperty("prefer_small_media") @Nullable private final Boolean preferSmallMedia;
    @JsonProperty("prefer_large_media") @Nullable private final Boolean preferLargeMedia;
    @JsonProperty("show_above_text") @Nullable private final Boolean showAboveText;

    @JsonCreator
    public LinkPreviewOptions(
            @JsonProperty("is_disabled") @Nullable Boolean isDisabled,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("prefer_small_media") @Nullable Boolean preferSmallMedia,
            @JsonProperty("prefer_large_media") @Nullable Boolean preferLargeMedia,
            @JsonProperty("show_above_text") @Nullable Boolean showAboveText
    ) {
        this.isDisabled = isDisabled;
        this.url = url;
        this.preferSmallMedia = preferSmallMedia;
        this.preferLargeMedia = preferLargeMedia;
        this.showAboveText = showAboveText;
    }

    public Boolean isDisabled() {
        return this.isDisabled;
    }

    public String url() {
        return this.url;
    }

    public Boolean preferSmallMedia() {
        return this.preferSmallMedia;
    }

    public Boolean preferLargeMedia() {
        return this.preferLargeMedia;
    }

    public Boolean showAboveText() {
        return this.showAboveText;
    }
}
