package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButton;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class GetChatMenuButton implements TelegramMethod<MenuButton> {
    @JsonProperty("chat_id") @Nullable private final Long chatId;

    @JsonCreator
    public GetChatMenuButton(
            @JsonProperty("chat_id") @Nullable Long chatId
    ) {
        this.chatId = chatId;
    }

    public Long chatId() {
        return this.chatId;
    }

    @Override
    public String apiMethod() {
        return "getChatMenuButton";
    }

    @Override
    public String apiReturnType() {
        return "MenuButton";
    }

    public static GetChatMenuButton of() {
        return new GetChatMenuButton(null);
    }
}
