package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents an animated emoji that displays a random value.
 *
 * @see <a href="https://core.telegram.org/bots/api#dice">Dice in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Dice {

    @JsonProperty("emoji")
    private final String emoji;

    @JsonProperty("value")
    private final long value;

    /**
     * Creates a new {@code Dice} instance.
     *
     * @param emoji Emoji on which the dice throw animation is based
     * @param value Value of the dice, 1-6 for '', '' and '' base emoji, 1-5 for '' and '' base
     *     emoji, 1-64 for '' base emoji
     */
    @JsonCreator
    public Dice(
            @JsonProperty("emoji") String emoji,
            @JsonProperty("value") long value) {
        this.emoji = emoji;
        this.value = value;
    }

    /**
     * Emoji on which the dice throw animation is based
     */
    public String emoji() {
        return emoji;
    }

    /**
     * Value of the dice, 1-6 for '', '' and '' base emoji, 1-5 for '' and '' base emoji, 1-64 for
     * '' base emoji
     */
    public long value() {
        return value;
    }

    public Dice withEmoji(String emoji) {
        return new Dice(emoji, value);
    }

    public Dice withValue(long value) {
        return new Dice(emoji, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dice)) {
            return false;
        }
        Dice that = (Dice) o;
        return Objects.equals(this.emoji, that.emoji)
                && this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.emoji, this.value);
    }

    @Override
    public String toString() {
        return "Dice[emoji=" + this.emoji
                + ", value=" + this.value
                + "]";
    }
}
