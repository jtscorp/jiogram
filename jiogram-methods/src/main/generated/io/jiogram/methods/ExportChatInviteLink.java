package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class ExportChatInviteLink implements TelegramMethod<String> {
    @JsonProperty("chat_id") private final ChatId chatId;

    @JsonCreator
    public ExportChatInviteLink(
            @JsonProperty("chat_id") ChatId chatId
    ) {
        this.chatId = chatId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    @Override
    public String apiMethod() {
        return "exportChatInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "String";
    }
}
