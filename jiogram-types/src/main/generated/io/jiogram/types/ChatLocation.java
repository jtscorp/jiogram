package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import java.util.Objects;

/**
 * Represents a location to which a chat is connected.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatlocation">ChatLocation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatLocation {

    @JsonProperty("location")
    private final Location location;

    @JsonProperty("address")
    private final String address;

    /**
     * Creates a new {@code ChatLocation} instance.
     *
     * @param location The location to which the supergroup is connected. Can't be a live location.
     * @param address Location address; 1-64 characters, as defined by the chat owner
     */
    @JsonCreator
    public ChatLocation(
            @JsonProperty("location") Location location,
            @JsonProperty("address") String address) {
        this.location = location;
        this.address = address;
    }

    /**
     * The location to which the supergroup is connected. Can't be a live location.
     */
    public Location location() {
        return location;
    }

    /**
     * Location address; 1-64 characters, as defined by the chat owner
     */
    public String address() {
        return address;
    }

    public ChatLocation withLocation(Location location) {
        return new ChatLocation(location, address);
    }

    public ChatLocation withAddress(String address) {
        return new ChatLocation(location, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatLocation)) {
            return false;
        }
        ChatLocation that = (ChatLocation) o;
        return Objects.equals(this.location, that.location)
                && Objects.equals(this.address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.location, this.address);
    }

    @Override
    public String toString() {
        return "ChatLocation[location=" + this.location
                + ", address=" + this.address
                + "]";
    }
}
