package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Contains information about the location of a Telegram Business account.
 *
 * @see <a href="https://core.telegram.org/bots/api#businesslocation">BusinessLocation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BusinessLocation {

    @JsonProperty("address")
    private final String address;

    @JsonProperty("location")
    private final @Nullable Location location;

    /**
     * Creates a new {@code BusinessLocation} instance.
     *
     * @param address Address of the business
     * @param location Location of the business
     */
    @JsonCreator
    public BusinessLocation(
            @JsonProperty("address") String address,
            @JsonProperty("location") @Nullable Location location) {
        this.address = address;
        this.location = location;
    }

    public static BusinessLocation of(String address) {
        return new BusinessLocation(address, null);
    }

    /**
     * Address of the business
     */
    public String address() {
        return address;
    }

    /**
     * Location of the business
     */
    public @Nullable Location location() {
        return location;
    }

    public BusinessLocation withAddress(String address) {
        return new BusinessLocation(address, location);
    }

    public BusinessLocation withLocation(@Nullable Location location) {
        return new BusinessLocation(address, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BusinessLocation)) {
            return false;
        }
        BusinessLocation that = (BusinessLocation) o;
        return Objects.equals(this.address, that.address)
                && Objects.equals(this.location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.address, this.location);
    }

    @Override
    public String toString() {
        return "BusinessLocation[address=" + this.address
                + ", location=" + this.location
                + "]";
    }
}
