package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a service message about a video chat ended in the chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#videochatended">VideoChatEnded in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class VideoChatEnded {

    @JsonProperty("duration")
    private final long duration;

    /**
     * Creates a new {@code VideoChatEnded} instance.
     *
     * @param duration Video chat duration in seconds
     */
    @JsonCreator
    public VideoChatEnded(
            @JsonProperty("duration") long duration) {
        this.duration = duration;
    }

    /**
     * Video chat duration in seconds
     */
    public long duration() {
        return duration;
    }

    public VideoChatEnded withDuration(long duration) {
        return new VideoChatEnded(duration);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VideoChatEnded)) {
            return false;
        }
        VideoChatEnded that = (VideoChatEnded) o;
        return this.duration == that.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.duration);
    }

    @Override
    public String toString() {
        return "VideoChatEnded[duration=" + this.duration
                + "]";
    }
}
