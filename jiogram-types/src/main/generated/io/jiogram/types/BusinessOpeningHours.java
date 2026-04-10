package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessOpeningHoursInterval;
import java.util.List;

public class BusinessOpeningHours {
    @JsonProperty("time_zone_name") private final String timeZoneName;
    @JsonProperty("opening_hours") private final List<BusinessOpeningHoursInterval> openingHours;

    @JsonCreator
    public BusinessOpeningHours(
            @JsonProperty("time_zone_name") String timeZoneName,
            @JsonProperty("opening_hours") List<BusinessOpeningHoursInterval> openingHours
    ) {
        this.timeZoneName = timeZoneName;
        this.openingHours = openingHours;
    }

    public String timeZoneName() {
        return this.timeZoneName;
    }

    public List<BusinessOpeningHoursInterval> openingHours() {
        return this.openingHours;
    }
}
