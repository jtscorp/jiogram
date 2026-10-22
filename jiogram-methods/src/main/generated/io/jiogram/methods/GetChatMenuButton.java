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
 * Use this method to get the current value of the bot's menu button in a private chat, or the
 * default menu button. Returns MenuButton on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#getchatmenubutton">getChatMenuButton in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetChatMenuButton implements TelegramMethod<MenuButton> {

    @JsonProperty("chat_id")
    private final @Nullable Long chatId;

    /**
     * Creates a new {@code GetChatMenuButton} instance.
     *
     * @param chatId Unique identifier for the target private chat. If not specified, default bot's
     *     menu button will be returned
     */
    @JsonCreator
    public GetChatMenuButton(
            @JsonProperty("chat_id") @Nullable Long chatId) {
        this.chatId = chatId;
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

    /**
     * Unique identifier for the target private chat. If not specified, default bot's menu button
     * will be returned
     */
    public @Nullable Long chatId() {
        return chatId;
    }

    public GetChatMenuButton withChatId(@Nullable Long chatId) {
        return new GetChatMenuButton(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetChatMenuButton)) {
            return false;
        }
        GetChatMenuButton that = (GetChatMenuButton) o;
        return Objects.equals(this.chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }

    @Override
    public String toString() {
        return "GetChatMenuButton[chatId=" + this.chatId
                + "]";
    }
}
