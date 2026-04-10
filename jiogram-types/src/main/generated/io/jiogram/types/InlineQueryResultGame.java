package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultGame implements InlineQueryResult {
    @JsonProperty("type") private final String type;
    @JsonProperty("id") private final String id;
    @JsonProperty("game_short_name") private final String gameShortName;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public InlineQueryResultGame(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("game_short_name") String gameShortName,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.type = type;
        this.id = id;
        this.gameShortName = gameShortName;
        this.replyMarkup = replyMarkup;
    }

    public String type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String gameShortName() {
        return this.gameShortName;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }
}
