package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes the birthdate of a user.
 *
 * @see <a href="https://core.telegram.org/bots/api#birthdate">Birthdate in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Birthdate {

    @JsonProperty("day")
    private final long day;

    @JsonProperty("month")
    private final long month;

    @JsonProperty("year")
    private final @Nullable Long year;

    /**
     * Creates a new {@code Birthdate} instance.
     *
     * @param day Day of the user's birth; 1-31
     * @param month Month of the user's birth; 1-12
     * @param year Year of the user's birth
     */
    @JsonCreator
    public Birthdate(
            @JsonProperty("day") long day,
            @JsonProperty("month") long month,
            @JsonProperty("year") @Nullable Long year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Birthdate of(long day, long month) {
        return new Birthdate(day, month, null);
    }

    /**
     * Day of the user's birth; 1-31
     */
    public long day() {
        return day;
    }

    /**
     * Month of the user's birth; 1-12
     */
    public long month() {
        return month;
    }

    /**
     * Year of the user's birth
     */
    public @Nullable Long year() {
        return year;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Birthdate)) {
            return false;
        }
        Birthdate that = (Birthdate) o;
        return this.day == that.day
                && this.month == that.month
                && Objects.equals(this.year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.day, this.month, this.year);
    }

    @Override
    public String toString() {
        return "Birthdate[day=" + this.day
                + ", month=" + this.month
                + ", year=" + this.year
                + "]";
    }
}
