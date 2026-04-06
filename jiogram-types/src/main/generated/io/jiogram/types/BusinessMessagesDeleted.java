package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.List;

public record BusinessMessagesDeleted(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_ids") List<Long> messageIds
) {}
