package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a service message about a change in auto-delete timer settings.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageautodeletetimerchanged">MessageAutoDeleteTimerChanged in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageAutoDeleteTimerChanged {

    @JsonProperty("message_auto_delete_time")
    private final long messageAutoDeleteTime;

    /**
     * Creates a new {@code MessageAutoDeleteTimerChanged} instance.
     *
     * @param messageAutoDeleteTime New auto-delete time for messages in the chat; in seconds
     */
    @JsonCreator
    public MessageAutoDeleteTimerChanged(
            @JsonProperty("message_auto_delete_time") long messageAutoDeleteTime) {
        this.messageAutoDeleteTime = messageAutoDeleteTime;
    }

    /**
     * New auto-delete time for messages in the chat; in seconds
     */
    public long messageAutoDeleteTime() {
        return messageAutoDeleteTime;
    }

    public MessageAutoDeleteTimerChanged withMessageAutoDeleteTime(long messageAutoDeleteTime) {
        return new MessageAutoDeleteTimerChanged(messageAutoDeleteTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageAutoDeleteTimerChanged)) {
            return false;
        }
        MessageAutoDeleteTimerChanged that = (MessageAutoDeleteTimerChanged) o;
        return this.messageAutoDeleteTime == that.messageAutoDeleteTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageAutoDeleteTime);
    }

    @Override
    public String toString() {
        return "MessageAutoDeleteTimerChanged[messageAutoDeleteTime=" + this.messageAutoDeleteTime
                + "]";
    }
}
