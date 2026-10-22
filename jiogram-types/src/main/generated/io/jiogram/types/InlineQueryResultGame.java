package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import org.jspecify.annotations.Nullable;

/**
 * Represents a Game.
 *
 * @param type Type of the result, must be game
 * @param id Unique identifier for this result, 1-64 bytes
 * @param gameShortName Short name of the game
 * @param replyMarkup Inline keyboard attached to the message
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultgame">InlineQueryResultGame in the Bot API</a>
 */
public record InlineQueryResultGame(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("game_short_name") String gameShortName,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements InlineQueryResult {

    public static InlineQueryResultGame of(String id, String gameShortName) {
        return new InlineQueryResultGame(InlineQueryResultType.GAME, id, gameShortName, null);
    }

    public InlineQueryResultGame withId(String id) {
        return new InlineQueryResultGame(type, id, gameShortName, replyMarkup);
    }

    public InlineQueryResultGame withGameShortName(String gameShortName) {
        return new InlineQueryResultGame(type, id, gameShortName, replyMarkup);
    }

    public InlineQueryResultGame withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultGame(type, id, gameShortName, replyMarkup);
    }
}
