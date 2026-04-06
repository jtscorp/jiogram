package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessOpeningHoursInterval;
import java.util.List;

public record BusinessOpeningHours(
    @JsonProperty("time_zone_name") String timeZoneName,
    @JsonProperty("opening_hours") List<BusinessOpeningHoursInterval> openingHours
) {}
