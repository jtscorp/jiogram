package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LocationAddress;
import io.jiogram.types.StoryAreaTypeType;
import org.jspecify.annotations.Nullable;

/**
 * Describes a story area pointing to a location. Currently, a story can have up to 10 location
 * areas.
 *
 * @param type Type of the area, always 'location'
 * @param latitude Location latitude in degrees
 * @param longitude Location longitude in degrees
 * @param address Address of the location
 * @see <a href="https://core.telegram.org/bots/api#storyareatypelocation">StoryAreaTypeLocation in the Bot API</a>
 */
public record StoryAreaTypeLocation(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("address") @Nullable LocationAddress address
) implements StoryAreaType {

    public static StoryAreaTypeLocation of(double latitude, double longitude) {
        return new StoryAreaTypeLocation(StoryAreaTypeType.LOCATION, latitude, longitude, null);
    }

    public StoryAreaTypeLocation withLatitude(double latitude) {
        return new StoryAreaTypeLocation(type, latitude, longitude, address);
    }

    public StoryAreaTypeLocation withLongitude(double longitude) {
        return new StoryAreaTypeLocation(type, latitude, longitude, address);
    }

    public StoryAreaTypeLocation withAddress(@Nullable LocationAddress address) {
        return new StoryAreaTypeLocation(type, latitude, longitude, address);
    }
}
