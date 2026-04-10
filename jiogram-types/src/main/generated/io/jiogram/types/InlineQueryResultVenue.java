package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultVenue implements InlineQueryResult {
    @JsonProperty("type") private final String type;
    @JsonProperty("id") private final String id;
    @JsonProperty("latitude") private final double latitude;
    @JsonProperty("longitude") private final double longitude;
    @JsonProperty("title") private final String title;
    @JsonProperty("address") private final String address;
    @JsonProperty("foursquare_id") @Nullable private final String foursquareId;
    @JsonProperty("foursquare_type") @Nullable private final String foursquareType;
    @JsonProperty("google_place_id") @Nullable private final String googlePlaceId;
    @JsonProperty("google_place_type") @Nullable private final String googlePlaceType;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("input_message_content") @Nullable private final InputMessageContent inputMessageContent;
    @JsonProperty("thumbnail_url") @Nullable private final String thumbnailUrl;
    @JsonProperty("thumbnail_width") @Nullable private final Long thumbnailWidth;
    @JsonProperty("thumbnail_height") @Nullable private final Long thumbnailHeight;

    @JsonCreator
    public InlineQueryResultVenue(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("title") String title,
            @JsonProperty("address") String address,
            @JsonProperty("foursquare_id") @Nullable String foursquareId,
            @JsonProperty("foursquare_type") @Nullable String foursquareType,
            @JsonProperty("google_place_id") @Nullable String googlePlaceId,
            @JsonProperty("google_place_type") @Nullable String googlePlaceType,
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
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public String type() {
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

    public String address() {
        return this.address;
    }

    public String foursquareId() {
        return this.foursquareId;
    }

    public String foursquareType() {
        return this.foursquareType;
    }

    public String googlePlaceId() {
        return this.googlePlaceId;
    }

    public String googlePlaceType() {
        return this.googlePlaceType;
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
