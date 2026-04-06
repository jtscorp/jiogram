package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatFullInfo;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record GetChat(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<ChatFullInfo> {

    @Override
    public String apiMethod() {
        return "getChat";
    }

    @Override
    public String apiReturnType() {
        return "ChatFullInfo";
    }
}
