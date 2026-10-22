package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MenuButton;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the bot's menu button in a private chat, or the default menu button.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setchatmenubutton">setChatMenuButton in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetChatMenuButton implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final @Nullable Long chatId;

    @JsonProperty("menu_button")
    private final @Nullable MenuButton menuButton;

    /**
     * Creates a new {@code SetChatMenuButton} instance.
     *
     * @param chatId Unique identifier for the target private chat. If not specified, default bot's
     *     menu button will be changed
     * @param menuButton A JSON-serialized object for the bot's new menu button. Defaults to
     *     MenuButtonDefault
     */
    @JsonCreator
    public SetChatMenuButton(
            @JsonProperty("chat_id") @Nullable Long chatId,
            @JsonProperty("menu_button") @Nullable MenuButton menuButton) {
        this.chatId = chatId;
        this.menuButton = menuButton;
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

    /**
     * Unique identifier for the target private chat. If not specified, default bot's menu button
     * will be changed
     */
    public @Nullable Long chatId() {
        return chatId;
    }

    /**
     * A JSON-serialized object for the bot's new menu button. Defaults to MenuButtonDefault
     */
    public @Nullable MenuButton menuButton() {
        return menuButton;
    }

    public SetChatMenuButton withChatId(@Nullable Long chatId) {
        return new SetChatMenuButton(chatId, menuButton);
    }

    public SetChatMenuButton withMenuButton(@Nullable MenuButton menuButton) {
        return new SetChatMenuButton(chatId, menuButton);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetChatMenuButton)) {
            return false;
        }
        SetChatMenuButton that = (SetChatMenuButton) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.menuButton, that.menuButton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.menuButton);
    }

    @Override
    public String toString() {
        return "SetChatMenuButton[chatId=" + this.chatId
                + ", menuButton=" + this.menuButton
                + "]";
    }
}
