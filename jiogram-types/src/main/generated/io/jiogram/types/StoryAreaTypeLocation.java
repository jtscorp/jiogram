package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LocationAddress;
import io.jiogram.types.StoryAreaTypeType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a story area pointing to a location. Currently, a story can have up to 10 location
 * areas.
 *
 * @see <a href="https://core.telegram.org/bots/api#storyareatypelocation">StoryAreaTypeLocation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StoryAreaTypeLocation implements StoryAreaType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final StoryAreaTypeType type;

    @JsonProperty("latitude")
    private final double latitude;

    @JsonProperty("longitude")
    private final double longitude;

    @JsonProperty("address")
    private final @Nullable LocationAddress address;

    /**
     * Creates a new {@code StoryAreaTypeLocation} instance.
     *
     * @param type Type of the area, always 'location'
     * @param latitude Location latitude in degrees
     * @param longitude Location longitude in degrees
     * @param address Address of the location
     */
    @JsonCreator
    public StoryAreaTypeLocation(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("address") @Nullable LocationAddress address) {
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public static StoryAreaTypeLocation of(double latitude, double longitude) {
        return new StoryAreaTypeLocation(StoryAreaTypeType.LOCATION, latitude, longitude, null);
    }

    /**
     * Type of the area, always 'location'
     */
    public StoryAreaTypeType type() {
        return type;
    }

    /**
     * Location latitude in degrees
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Location longitude in degrees
     */
    public double longitude() {
        return longitude;
    }

    /**
     * Address of the location
     */
    public @Nullable LocationAddress address() {
        return address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoryAreaTypeLocation)) {
            return false;
        }
        StoryAreaTypeLocation that = (StoryAreaTypeLocation) o;
        return Objects.equals(this.type, that.type)
                && Double.compare(this.latitude, that.latitude) == 0
                && Double.compare(this.longitude, that.longitude) == 0
                && Objects.equals(this.address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.latitude, this.longitude, this.address);
    }

    @Override
    public String toString() {
        return "StoryAreaTypeLocation[type=" + this.type
                + ", latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", address=" + this.address
                + "]";
    }
}
