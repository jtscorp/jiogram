package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class EditGeneralForumTopic implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("name") private final String name;

    @JsonCreator
    public EditGeneralForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("name") String name
    ) {
        this.chatId = chatId;
        this.name = name;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String apiMethod() {
        return "editGeneralForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
