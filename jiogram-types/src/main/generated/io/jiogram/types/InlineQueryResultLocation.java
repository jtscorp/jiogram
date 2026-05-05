package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultLocation implements InlineQueryResult {
    @JsonProperty("type") private final InlineQueryResultType type;
    @JsonProperty("id") private final String id;
    @JsonProperty("latitude") private final double latitude;
    @JsonProperty("longitude") private final double longitude;
    @JsonProperty("title") private final String title;
    @JsonProperty("horizontal_accuracy") @Nullable private final Double horizontalAccuracy;
    @JsonProperty("live_period") @Nullable private final Long livePeriod;
    @JsonProperty("heading") @Nullable private final Long heading;
    @JsonProperty("proximity_alert_radius") @Nullable private final Long proximityAlertRadius;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("input_message_content") @Nullable private final InputMessageContent inputMessageContent;
    @JsonProperty("thumbnail_url") @Nullable private final String thumbnailUrl;
    @JsonProperty("thumbnail_width") @Nullable private final Long thumbnailWidth;
    @JsonProperty("thumbnail_height") @Nullable private final Long thumbnailHeight;

    @JsonCreator
    public InlineQueryResultLocation(
            @JsonProperty("type") InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("title") String title,
            @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
            @JsonProperty("live_period") @Nullable Long livePeriod,
            @JsonProperty("heading") @Nullable Long heading,
            @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent,
            @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl,
            @JsonProperty("thumbnail_width") @Nullable Long thumbnailWidth,
            @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight
    ) {
        this.type = type;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public InlineQueryResultType type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public String title() {
        return this.title;
    }

    public Double horizontalAccuracy() {
        return this.horizontalAccuracy;
    }

    public Long livePeriod() {
        return this.livePeriod;
    }

    public Long heading() {
        return this.heading;
    }

    public Long proximityAlertRadius() {
        return this.proximityAlertRadius;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    public InputMessageContent inputMessageContent() {
        return this.inputMessageContent;
    }

    public String thumbnailUrl() {
        return this.thumbnailUrl;
    }

    public Long thumbnailWidth() {
        return this.thumbnailWidth;
    }

    public Long thumbnailHeight() {
        return this.thumbnailHeight;
    }
}
