package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessOpeningHoursInterval;
import java.util.List;

/**
 * Describes the opening hours of a business.
 *
 * @param timeZoneName Unique name of the time zone for which the opening hours are defined
 * @param openingHours List of time intervals describing business opening hours
 * @see <a href="https://core.telegram.org/bots/api#businessopeninghours">BusinessOpeningHours in the Bot API</a>
 */
public record BusinessOpeningHours(
    @JsonProperty("time_zone_name") String timeZoneName,
    @JsonProperty("opening_hours") List<BusinessOpeningHoursInterval> openingHours
) {}
