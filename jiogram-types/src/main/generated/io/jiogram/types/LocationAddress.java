package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record LocationAddress(
    @JsonProperty("country_code") String countryCode,
    @JsonProperty("state") @Nullable String state,
    @JsonProperty("city") @Nullable String city,
    @JsonProperty("street") @Nullable String street
) {}
