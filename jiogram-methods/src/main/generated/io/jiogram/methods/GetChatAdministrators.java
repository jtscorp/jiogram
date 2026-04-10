package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatMember;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public class GetChatAdministrators implements TelegramMethod<List<ChatMember>> {
    @JsonProperty("chat_id") private final ChatId chatId;

    @JsonCreator
    public GetChatAdministrators(
            @JsonProperty("chat_id") ChatId chatId
    ) {
        this.chatId = chatId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    @Override
    public String apiMethod() {
        return "getChatAdministrators";
    }

    @Override
    public String apiReturnType() {
        return "Array of ChatMember";
    }
}
