package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.List;

public class BusinessMessagesDeleted {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("message_ids") private final List<Long> messageIds;

    @JsonCreator
    public BusinessMessagesDeleted(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_ids") List<Long> messageIds
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chat = chat;
        this.messageIds = messageIds;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public Chat chat() {
        return this.chat;
    }

    public List<Long> messageIds() {
        return this.messageIds;
    }
}
