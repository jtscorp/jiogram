package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButton;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetChatMenuButton(
    @JsonProperty("chat_id") @Nullable Long chatId
) implements TelegramMethod<MenuButton> {

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
