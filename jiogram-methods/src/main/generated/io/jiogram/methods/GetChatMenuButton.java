package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButton;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get the current value of the bot's menu button in a private chat, or the
 * default menu button. Returns MenuButton on success.
 *
 * @param chatId Unique identifier for the target private chat. If not specified, default bot's menu
 *     button will be returned
 * @see <a href="https://core.telegram.org/bots/api#getchatmenubutton">getChatMenuButton in the Bot API</a>
 */
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
