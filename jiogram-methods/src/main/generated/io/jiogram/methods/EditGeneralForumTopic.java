package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record EditGeneralForumTopic(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("name") String name
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "editGeneralForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
