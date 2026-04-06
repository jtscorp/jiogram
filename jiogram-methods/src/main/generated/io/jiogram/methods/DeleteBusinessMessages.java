package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public record DeleteBusinessMessages(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("message_ids") List<Long> messageIds
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteBusinessMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
