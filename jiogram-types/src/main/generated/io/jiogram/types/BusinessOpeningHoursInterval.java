package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes an interval of time during which a business is open.
 *
 * @see <a href="https://core.telegram.org/bots/api#businessopeninghoursinterval">BusinessOpeningHoursInterval in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BusinessOpeningHoursInterval {

    @JsonProperty("opening_minute")
    private final long openingMinute;

    @JsonProperty("closing_minute")
    private final long closingMinute;

    /**
     * Creates a new {@code BusinessOpeningHoursInterval} instance.
     *
     * @param openingMinute The minute's sequence number in a week, starting on Monday, marking the
     *     start of the time interval during which the business is open; 0 - 7 * 24 * 60
     * @param closingMinute The minute's sequence number in a week, starting on Monday, marking the
     *     end of the time interval during which the business is open; 0 - 8 * 24 * 60
     */
    @JsonCreator
    public BusinessOpeningHoursInterval(
            @JsonProperty("opening_minute") long openingMinute,
            @JsonProperty("closing_minute") long closingMinute) {
        this.openingMinute = openingMinute;
        this.closingMinute = closingMinute;
    }

    /**
     * The minute's sequence number in a week, starting on Monday, marking the start of the time
     * interval during which the business is open; 0 - 7 * 24 * 60
     */
    public long openingMinute() {
        return openingMinute;
    }

    /**
     * The minute's sequence number in a week, starting on Monday, marking the end of the time
     * interval during which the business is open; 0 - 8 * 24 * 60
     */
    public long closingMinute() {
        return closingMinute;
    }

    public BusinessOpeningHoursInterval withOpeningMinute(long openingMinute) {
        return new BusinessOpeningHoursInterval(openingMinute, closingMinute);
    }

    public BusinessOpeningHoursInterval withClosingMinute(long closingMinute) {
        return new BusinessOpeningHoursInterval(openingMinute, closingMinute);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BusinessOpeningHoursInterval)) {
            return false;
        }
        BusinessOpeningHoursInterval that = (BusinessOpeningHoursInterval) o;
        return this.openingMinute == that.openingMinute
                && this.closingMinute == that.closingMinute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.openingMinute, this.closingMinute);
    }

    @Override
    public String toString() {
        return "BusinessOpeningHoursInterval[openingMinute=" + this.openingMinute
                + ", closingMinute=" + this.closingMinute
                + "]";
    }
}
