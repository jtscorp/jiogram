package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import org.jspecify.annotations.Nullable;

/**
 * Contains information about the location of a Telegram Business account.
 *
 * @param address Address of the business
 * @param location Location of the business
 * @see <a href="https://core.telegram.org/bots/api#businesslocation">BusinessLocation in the Bot API</a>
 */
public record BusinessLocation(
    @JsonProperty("address") String address,
    @JsonProperty("location") @Nullable Location location
) {}
