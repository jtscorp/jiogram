package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public class DeleteBusinessMessages implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("message_ids") private final List<Long> messageIds;

    @JsonCreator
    public DeleteBusinessMessages(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("message_ids") List<Long> messageIds
    ) {
        this.businessConnectionId = businessConnectionId;
        this.messageIds = messageIds;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public List<Long> messageIds() {
        return this.messageIds;
    }

    @Override
    public String apiMethod() {
        return "deleteBusinessMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
