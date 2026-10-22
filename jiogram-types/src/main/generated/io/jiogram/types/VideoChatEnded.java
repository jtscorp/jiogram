package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a service message about a video chat ended in the chat.
 *
 * @param duration Video chat duration in seconds
 * @see <a href="https://core.telegram.org/bots/api#videochatended">VideoChatEnded in the Bot API</a>
 */
public record VideoChatEnded(
    @JsonProperty("duration") long duration
) {

    public VideoChatEnded withDuration(long duration) {
        return new VideoChatEnded(duration);
    }
}
