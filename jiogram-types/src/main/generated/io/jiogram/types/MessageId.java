package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a unique message identifier.
 *
 * @param messageId Unique message identifier. In specific instances (e.g., message containing a
 *     video sent to a big chat), the server might automatically schedule a message instead of
 *     sending it immediately. In such cases, this field will be 0 and the relevant message will be
 *     unusable until it is actually sent
 * @see <a href="https://core.telegram.org/bots/api#messageid">MessageId in the Bot API</a>
 */
public record MessageId(
    @JsonProperty("message_id") long messageId
) {

    public MessageId withMessageId(long messageId) {
        return new MessageId(messageId);
    }
}
