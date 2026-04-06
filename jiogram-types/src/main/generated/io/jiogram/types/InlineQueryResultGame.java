package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import org.jspecify.annotations.Nullable;

public record InlineQueryResultGame(
    @JsonProperty("type") String type,
    @JsonProperty("id") String id,
    @JsonProperty("game_short_name") String gameShortName,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements InlineQueryResult {}
