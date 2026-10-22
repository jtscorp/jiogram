package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

/**
 * This object represents one row of the high scores table for a game.
 * <br>And that's about all we've got for now.
 * <br>If you've got any questions, please check out our Bot FAQ
 *
 * @param position Position in high score table for the game
 * @param user User
 * @param score Score
 * @see <a href="https://core.telegram.org/bots/api#gamehighscore">GameHighScore in the Bot API</a>
 */
public record GameHighScore(
    @JsonProperty("position") long position,
    @JsonProperty("user") User user,
    @JsonProperty("score") long score
) {

    public GameHighScore withPosition(long position) {
        return new GameHighScore(position, user, score);
    }

    public GameHighScore withUser(User user) {
        return new GameHighScore(position, user, score);
    }

    public GameHighScore withScore(long score) {
        return new GameHighScore(position, user, score);
    }
}
