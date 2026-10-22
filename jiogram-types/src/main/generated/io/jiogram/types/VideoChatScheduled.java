package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a service message about a video chat scheduled in the chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#videochatscheduled">VideoChatScheduled in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class VideoChatScheduled {

    @JsonProperty("start_date")
    private final long startDate;

    /**
     * Creates a new {@code VideoChatScheduled} instance.
     *
     * @param startDate Point in time (Unix timestamp) when the video chat is supposed to be started
     *     by a chat administrator
     */
    @JsonCreator
    public VideoChatScheduled(
            @JsonProperty("start_date") long startDate) {
        this.startDate = startDate;
    }

    /**
     * Point in time (Unix timestamp) when the video chat is supposed to be started by a chat
     * administrator
     */
    public long startDate() {
        return startDate;
    }

    public VideoChatScheduled withStartDate(long startDate) {
        return new VideoChatScheduled(startDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VideoChatScheduled)) {
            return false;
        }
        VideoChatScheduled that = (VideoChatScheduled) o;
        return this.startDate == that.startDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.startDate);
    }

    @Override
    public String toString() {
        return "VideoChatScheduled[startDate=" + this.startDate
                + "]";
    }
}
