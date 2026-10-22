package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.List;
import java.util.Objects;

/**
 * This object is received when messages are deleted from a connected business account.
 *
 * @see <a href="https://core.telegram.org/bots/api#businessmessagesdeleted">BusinessMessagesDeleted in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class BusinessMessagesDeleted {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("message_ids")
    private final List<Long> messageIds;

    /**
     * Creates a new {@code BusinessMessagesDeleted} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param chat Information about a chat in the business account. The bot may not have access to
     *     the chat or the corresponding user.
     * @param messageIds The list of identifiers of deleted messages in the chat of the business
     *     account
     */
    @JsonCreator
    public BusinessMessagesDeleted(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_ids") List<Long> messageIds) {
        this.businessConnectionId = businessConnectionId;
        this.chat = chat;
        this.messageIds = messageIds;
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Information about a chat in the business account. The bot may not have access to the chat or
     * the corresponding user.
     */
    public Chat chat() {
        return chat;
    }

    /**
     * The list of identifiers of deleted messages in the chat of the business account
     */
    public List<Long> messageIds() {
        return messageIds;
    }

    public BusinessMessagesDeleted withBusinessConnectionId(String businessConnectionId) {
        return new BusinessMessagesDeleted(businessConnectionId, chat, messageIds);
    }

    public BusinessMessagesDeleted withChat(Chat chat) {
        return new BusinessMessagesDeleted(businessConnectionId, chat, messageIds);
    }

    public BusinessMessagesDeleted withMessageIds(List<Long> messageIds) {
        return new BusinessMessagesDeleted(businessConnectionId, chat, messageIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BusinessMessagesDeleted)) {
            return false;
        }
        BusinessMessagesDeleted that = (BusinessMessagesDeleted) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chat, that.chat)
                && Objects.equals(this.messageIds, that.messageIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chat, this.messageIds);
    }

    @Override
    public String toString() {
        return "BusinessMessagesDeleted[businessConnectionId=" + this.businessConnectionId
                + ", chat=" + this.chat
                + ", messageIds=" + this.messageIds
                + "]";
    }
}
