package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a service message about a change in auto-delete timer settings.
 *
 * @param messageAutoDeleteTime New auto-delete time for messages in the chat; in seconds
 * @see <a href="https://core.telegram.org/bots/api#messageautodeletetimerchanged">MessageAutoDeleteTimerChanged in the Bot API</a>
 */
public record MessageAutoDeleteTimerChanged(
    @JsonProperty("message_auto_delete_time") long messageAutoDeleteTime
) {}
