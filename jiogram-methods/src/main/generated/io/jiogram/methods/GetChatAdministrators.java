package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatMember;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public record GetChatAdministrators(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<List<ChatMember>> {

    @Override
    public String apiMethod() {
        return "getChatAdministrators";
    }

    @Override
    public String apiReturnType() {
        return "Array of ChatMember";
    }
}
