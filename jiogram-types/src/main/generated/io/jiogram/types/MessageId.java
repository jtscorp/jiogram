package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a unique message identifier.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageid">MessageId in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageId {

    @JsonProperty("message_id")
    private final long messageId;

    /**
     * Creates a new {@code MessageId} instance.
     *
     * @param messageId Unique message identifier. In specific instances (e.g., message containing a
     *     video sent to a big chat), the server might automatically schedule a message instead of
     *     sending it immediately. In such cases, this field will be 0 and the relevant message will
     *     be unusable until it is actually sent
     */
    @JsonCreator
    public MessageId(
            @JsonProperty("message_id") long messageId) {
        this.messageId = messageId;
    }

    /**
     * Unique message identifier. In specific instances (e.g., message containing a video sent to a
     * big chat), the server might automatically schedule a message instead of sending it
     * immediately. In such cases, this field will be 0 and the relevant message will be unusable
     * until it is actually sent
     */
    public long messageId() {
        return messageId;
    }

    public MessageId withMessageId(long messageId) {
        return new MessageId(messageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageId)) {
            return false;
        }
        MessageId that = (MessageId) o;
        return this.messageId == that.messageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageId);
    }

    @Override
    public String toString() {
        return "MessageId[messageId=" + this.messageId
                + "]";
    }
}
