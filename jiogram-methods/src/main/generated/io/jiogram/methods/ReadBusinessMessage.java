package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class ReadBusinessMessage implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("chat_id") private final long chatId;
    @JsonProperty("message_id") private final long messageId;

    @JsonCreator
    public ReadBusinessMessage(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_id") long messageId
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public long chatId() {
        return this.chatId;
    }

    public long messageId() {
        return this.messageId;
    }

    @Override
    public String apiMethod() {
        return "readBusinessMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
