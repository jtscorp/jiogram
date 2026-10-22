package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessOpeningHoursInterval;
import java.util.List;
import java.util.Objects;

/**
 * Describes the opening hours of a business.
 *
 * @see <a href="https://core.telegram.org/bots/api#businessopeninghours">BusinessOpeningHours in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BusinessOpeningHours {

    @JsonProperty("time_zone_name")
    private final String timeZoneName;

    @JsonProperty("opening_hours")
    private final List<BusinessOpeningHoursInterval> openingHours;

    /**
     * Creates a new {@code BusinessOpeningHours} instance.
     *
     * @param timeZoneName Unique name of the time zone for which the opening hours are defined
     * @param openingHours List of time intervals describing business opening hours
     */
    @JsonCreator
    public BusinessOpeningHours(
            @JsonProperty("time_zone_name") String timeZoneName,
            @JsonProperty("opening_hours") List<BusinessOpeningHoursInterval> openingHours) {
        this.timeZoneName = timeZoneName;
        this.openingHours = openingHours;
    }

    /**
     * Unique name of the time zone for which the opening hours are defined
     */
    public String timeZoneName() {
        return timeZoneName;
    }

    /**
     * List of time intervals describing business opening hours
     */
    public List<BusinessOpeningHoursInterval> openingHours() {
        return openingHours;
    }

    public BusinessOpeningHours withTimeZoneName(String timeZoneName) {
        return new BusinessOpeningHours(timeZoneName, openingHours);
    }

    public BusinessOpeningHours withOpeningHours(List<BusinessOpeningHoursInterval> openingHours) {
        return new BusinessOpeningHours(timeZoneName, openingHours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BusinessOpeningHours)) {
            return false;
        }
        BusinessOpeningHours that = (BusinessOpeningHours) o;
        return Objects.equals(this.timeZoneName, that.timeZoneName)
                && Objects.equals(this.openingHours, that.openingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.timeZoneName, this.openingHours);
    }

    @Override
    public String toString() {
        return "BusinessOpeningHours[timeZoneName=" + this.timeZoneName
                + ", openingHours=" + this.openingHours
                + "]";
    }
}
