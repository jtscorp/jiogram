package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButton;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetChatMenuButton(
    @JsonProperty("chat_id") @Nullable Long chatId,
    @JsonProperty("menu_button") @Nullable MenuButton menuButton
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatMenuButton";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatMenuButton of() {
        return new SetChatMenuButton(null, null);
    }
}
