package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.List;

/**
 * This object is received when messages are deleted from a connected business account.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param chat Information about a chat in the business account. The bot may not have access to the
 *     chat or the corresponding user.
 * @param messageIds The list of identifiers of deleted messages in the chat of the business account
 * @see <a href="https://core.telegram.org/bots/api#businessmessagesdeleted">BusinessMessagesDeleted in the Bot API</a>
 */
public record BusinessMessagesDeleted(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_ids") List<Long> messageIds
) {}
