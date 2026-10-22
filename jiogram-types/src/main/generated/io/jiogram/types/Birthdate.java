package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Describes the birthdate of a user.
 *
 * @param day Day of the user's birth; 1-31
 * @param month Month of the user's birth; 1-12
 * @param year Year of the user's birth
 * @see <a href="https://core.telegram.org/bots/api#birthdate">Birthdate in the Bot API</a>
 */
public record Birthdate(
    @JsonProperty("day") long day,
    @JsonProperty("month") long month,
    @JsonProperty("year") @Nullable Long year
) {

    public static Birthdate of(long day, long month) {
        return new Birthdate(day, month, null);
    }

    public Birthdate withDay(long day) {
        return new Birthdate(day, month, year);
    }

    public Birthdate withMonth(long month) {
        return new Birthdate(day, month, year);
    }

    public Birthdate withYear(@Nullable Long year) {
        return new Birthdate(day, month, year);
    }
}
