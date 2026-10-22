package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents an animated emoji that displays a random value.
 *
 * @param emoji Emoji on which the dice throw animation is based
 * @param value Value of the dice, 1-6 for '', '' and '' base emoji, 1-5 for '' and '' base emoji,
 *     1-64 for '' base emoji
 * @see <a href="https://core.telegram.org/bots/api#dice">Dice in the Bot API</a>
 */
public record Dice(
    @JsonProperty("emoji") String emoji,
    @JsonProperty("value") long value
) {

    public Dice withEmoji(String emoji) {
        return new Dice(emoji, value);
    }

    public Dice withValue(long value) {
        return new Dice(emoji, value);
    }
}
