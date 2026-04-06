package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record ExportChatInviteLink(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<String> {

    @Override
    public String apiMethod() {
        return "exportChatInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "String";
    }
}
