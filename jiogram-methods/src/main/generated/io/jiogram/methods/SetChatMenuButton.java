package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButton;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetChatMenuButton implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") @Nullable private final Long chatId;
    @JsonProperty("menu_button") @Nullable private final MenuButton menuButton;

    @JsonCreator
    public SetChatMenuButton(
            @JsonProperty("chat_id") @Nullable Long chatId,
            @JsonProperty("menu_button") @Nullable MenuButton menuButton
    ) {
        this.chatId = chatId;
        this.menuButton = menuButton;
    }

    public Long chatId() {
        return this.chatId;
    }

    public MenuButton menuButton() {
        return this.menuButton;
    }

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
