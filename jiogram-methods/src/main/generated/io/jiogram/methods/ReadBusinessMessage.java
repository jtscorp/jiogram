package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record ReadBusinessMessage(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_id") long messageId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "readBusinessMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
