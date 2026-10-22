package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * This object represents one row of the high scores table for a game.
 * <br>And that's about all we've got for now.
 * <br>If you've got any questions, please check out our Bot FAQ
 *
 * @see <a href="https://core.telegram.org/bots/api#gamehighscore">GameHighScore in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GameHighScore {

    @JsonProperty("position")
    private final long position;

    @JsonProperty("user")
    private final User user;

    @JsonProperty("score")
    private final long score;

    /**
     * Creates a new {@code GameHighScore} instance.
     *
     * @param position Position in high score table for the game
     * @param user User
     * @param score Score
     */
    @JsonCreator
    public GameHighScore(
            @JsonProperty("position") long position,
            @JsonProperty("user") User user,
            @JsonProperty("score") long score) {
        this.position = position;
        this.user = user;
        this.score = score;
    }

    /**
     * Position in high score table for the game
     */
    public long position() {
        return position;
    }

    /**
     * User
     */
    public User user() {
        return user;
    }

    /**
     * Score
     */
    public long score() {
        return score;
    }

    public GameHighScore withPosition(long position) {
        return new GameHighScore(position, user, score);
    }

    public GameHighScore withUser(User user) {
        return new GameHighScore(position, user, score);
    }

    public GameHighScore withScore(long score) {
        return new GameHighScore(position, user, score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GameHighScore)) {
            return false;
        }
        GameHighScore that = (GameHighScore) o;
        return this.position == that.position
                && Objects.equals(this.user, that.user)
                && this.score == that.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position, this.user, this.score);
    }

    @Override
    public String toString() {
        return "GameHighScore[position=" + this.position
                + ", user=" + this.user
                + ", score=" + this.score
                + "]";
    }
}
