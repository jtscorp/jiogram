package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;

/**
 * Delete messages on behalf of a business account. Requires the can_delete_sent_messages business
 * bot right to delete messages sent by the bot itself, or the can_delete_all_messages business bot
 * right to delete any message. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletebusinessmessages">deleteBusinessMessages in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteBusinessMessages implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("message_ids")
    private final List<Long> messageIds;

    /**
     * Creates a new {@code DeleteBusinessMessages} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     to delete the messages
     * @param messageIds A JSON-serialized list of 1-100 identifiers of messages to delete. All
     *     messages must be from the same chat. See deleteMessage for limitations on which messages
     *     can be deleted
     */
    @JsonCreator
    public DeleteBusinessMessages(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("message_ids") List<Long> messageIds) {
        this.businessConnectionId = businessConnectionId;
        this.messageIds = messageIds;
    }

    @Override
    public String apiMethod() {
        return "deleteBusinessMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier of the business connection on behalf of which to delete the messages
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * A JSON-serialized list of 1-100 identifiers of messages to delete. All messages must be from
     * the same chat. See deleteMessage for limitations on which messages can be deleted
     */
    public List<Long> messageIds() {
        return messageIds;
    }

    public DeleteBusinessMessages withBusinessConnectionId(String businessConnectionId) {
        return new DeleteBusinessMessages(businessConnectionId, messageIds);
    }

    public DeleteBusinessMessages withMessageIds(List<Long> messageIds) {
        return new DeleteBusinessMessages(businessConnectionId, messageIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteBusinessMessages)) {
            return false;
        }
        DeleteBusinessMessages that = (DeleteBusinessMessages) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.messageIds, that.messageIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.messageIds);
    }

    @Override
    public String toString() {
        return "DeleteBusinessMessages[businessConnectionId=" + this.businessConnectionId
                + ", messageIds=" + this.messageIds
                + "]";
    }
}
