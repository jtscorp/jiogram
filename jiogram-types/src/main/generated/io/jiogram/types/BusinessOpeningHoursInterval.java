package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes an interval of time during which a business is open.
 *
 * @param openingMinute The minute's sequence number in a week, starting on Monday, marking the
 *     start of the time interval during which the business is open; 0 - 7 * 24 * 60
 * @param closingMinute The minute's sequence number in a week, starting on Monday, marking the end
 *     of the time interval during which the business is open; 0 - 8 * 24 * 60
 * @see <a href="https://core.telegram.org/bots/api#businessopeninghoursinterval">BusinessOpeningHoursInterval in the Bot API</a>
 */
public record BusinessOpeningHoursInterval(
    @JsonProperty("opening_minute") long openingMinute,
    @JsonProperty("closing_minute") long closingMinute
) {}
