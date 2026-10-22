package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * This object represents the content of a service message, sent whenever a user in the chat
 * triggers a proximity alert set by another user.
 *
 * @see <a href="https://core.telegram.org/bots/api#proximityalerttriggered">ProximityAlertTriggered in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ProximityAlertTriggered {

    @JsonProperty("traveler")
    private final User traveler;

    @JsonProperty("watcher")
    private final User watcher;

    @JsonProperty("distance")
    private final long distance;

    /**
     * Creates a new {@code ProximityAlertTriggered} instance.
     *
     * @param traveler User that triggered the alert
     * @param watcher User that set the alert
     * @param distance The distance between the users
     */
    @JsonCreator
    public ProximityAlertTriggered(
            @JsonProperty("traveler") User traveler,
            @JsonProperty("watcher") User watcher,
            @JsonProperty("distance") long distance) {
        this.traveler = traveler;
        this.watcher = watcher;
        this.distance = distance;
    }

    /**
     * User that triggered the alert
     */
    public User traveler() {
        return traveler;
    }

    /**
     * User that set the alert
     */
    public User watcher() {
        return watcher;
    }

    /**
     * The distance between the users
     */
    public long distance() {
        return distance;
    }

    public ProximityAlertTriggered withTraveler(User traveler) {
        return new ProximityAlertTriggered(traveler, watcher, distance);
    }

    public ProximityAlertTriggered withWatcher(User watcher) {
        return new ProximityAlertTriggered(traveler, watcher, distance);
    }

    public ProximityAlertTriggered withDistance(long distance) {
        return new ProximityAlertTriggered(traveler, watcher, distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProximityAlertTriggered)) {
            return false;
        }
        ProximityAlertTriggered that = (ProximityAlertTriggered) o;
        return Objects.equals(this.traveler, that.traveler)
                && Objects.equals(this.watcher, that.watcher)
                && this.distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.traveler, this.watcher, this.distance);
    }

    @Override
    public String toString() {
        return "ProximityAlertTriggered[traveler=" + this.traveler
                + ", watcher=" + this.watcher
                + ", distance=" + this.distance
                + "]";
    }
}
