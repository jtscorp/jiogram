package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButton;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the bot's menu button in a private chat, or the default menu button.
 * Returns True on success.
 *
 * @param chatId Unique identifier for the target private chat. If not specified, default bot's menu
 *     button will be changed
 * @param menuButton A JSON-serialized object for the bot's new menu button. Defaults to
 *     MenuButtonDefault
 * @see <a href="https://core.telegram.org/bots/api#setchatmenubutton">setChatMenuButton in the Bot API</a>
 */
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

    public SetChatMenuButton withChatId(@Nullable Long chatId) {
        return new SetChatMenuButton(chatId, menuButton);
    }

    public SetChatMenuButton withMenuButton(@Nullable MenuButton menuButton) {
        return new SetChatMenuButton(chatId, menuButton);
    }
}
