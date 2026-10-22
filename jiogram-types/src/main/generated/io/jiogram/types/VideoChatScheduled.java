package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a service message about a video chat scheduled in the chat.
 *
 * @param startDate Point in time (Unix timestamp) when the video chat is supposed to be started by
 *     a chat administrator
 * @see <a href="https://core.telegram.org/bots/api#videochatscheduled">VideoChatScheduled in the Bot API</a>
 */
public record VideoChatScheduled(
    @JsonProperty("start_date") long startDate
) {

    public VideoChatScheduled withStartDate(long startDate) {
        return new VideoChatScheduled(startDate);
    }
}
