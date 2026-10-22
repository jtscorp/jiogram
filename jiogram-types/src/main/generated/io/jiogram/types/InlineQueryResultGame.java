package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a Game.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultgame">InlineQueryResultGame in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultGame implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("game_short_name")
    private final String gameShortName;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code InlineQueryResultGame} instance.
     *
     * @param type Type of the result, must be game
     * @param id Unique identifier for this result, 1-64 bytes
     * @param gameShortName Short name of the game
     * @param replyMarkup Inline keyboard attached to the message
     */
    @JsonCreator
    public InlineQueryResultGame(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("game_short_name") String gameShortName,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.type = type;
        this.id = id;
        this.gameShortName = gameShortName;
        this.replyMarkup = replyMarkup;
    }

    public static InlineQueryResultGame of(String id, String gameShortName) {
        return new InlineQueryResultGame(InlineQueryResultType.GAME, id, gameShortName, null);
    }

    /**
     * Type of the result, must be game
     */
    public InlineQueryResultType type() {
        return type;
    }

    /**
     * Unique identifier for this result, 1-64 bytes
     */
    public String id() {
        return id;
    }

    /**
     * Short name of the game
     */
    public String gameShortName() {
        return gameShortName;
    }

    /**
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultGame)) {
            return false;
        }
        InlineQueryResultGame that = (InlineQueryResultGame) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.gameShortName, that.gameShortName)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.gameShortName, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "InlineQueryResultGame[type=" + this.type
                + ", id=" + this.id
                + ", gameShortName=" + this.gameShortName
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
