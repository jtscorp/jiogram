package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

public record InlineQueryResultVenue(
    @JsonProperty("type") InlineQueryResultType type,
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
) implements InlineQueryResult {}
