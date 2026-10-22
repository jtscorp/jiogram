package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * This object represents a service message about a video chat started in the chat. Currently holds
 * no information.
 *
 * @see <a href="https://core.telegram.org/bots/api#videochatstarted">VideoChatStarted in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class VideoChatStarted {

    /**
     * Creates a new {@code VideoChatStarted} instance.
     */
    public VideoChatStarted() {
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof VideoChatStarted;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "VideoChatStarted[]";
    }
}
