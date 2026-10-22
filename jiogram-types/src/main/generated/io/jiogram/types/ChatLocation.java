package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;

/**
 * Represents a location to which a chat is connected.
 *
 * @param location The location to which the supergroup is connected. Can't be a live location.
 * @param address Location address; 1-64 characters, as defined by the chat owner
 * @see <a href="https://core.telegram.org/bots/api#chatlocation">ChatLocation in the Bot API</a>
 */
public record ChatLocation(
    @JsonProperty("location") Location location,
    @JsonProperty("address") String address
) {

    public ChatLocation withLocation(Location location) {
        return new ChatLocation(location, address);
    }

    public ChatLocation withAddress(String address) {
        return new ChatLocation(location, address);
    }
}
