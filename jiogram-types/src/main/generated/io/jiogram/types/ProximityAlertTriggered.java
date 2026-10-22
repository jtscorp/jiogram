package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

/**
 * This object represents the content of a service message, sent whenever a user in the chat
 * triggers a proximity alert set by another user.
 *
 * @param traveler User that triggered the alert
 * @param watcher User that set the alert
 * @param distance The distance between the users
 * @see <a href="https://core.telegram.org/bots/api#proximityalerttriggered">ProximityAlertTriggered in the Bot API</a>
 */
public record ProximityAlertTriggered(
    @JsonProperty("traveler") User traveler,
    @JsonProperty("watcher") User watcher,
    @JsonProperty("distance") long distance
) {}
