package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButton;
import io.jiogram.types.PreparedKeyboardButton;
import io.jiogram.types.TelegramMethod;

/**
 * Stores a keyboard button that can be used by a user within a Mini App. Returns a
 * PreparedKeyboardButton object.
 *
 * @param userId Unique identifier of the target user that can use the button
 * @param button A JSON-serialized object describing the button to be saved. The button must be of
 *     the type request_users, request_chat, or request_managed_bot
 * @see <a href="https://core.telegram.org/bots/api#savepreparedkeyboardbutton">savePreparedKeyboardButton in the Bot API</a>
 */
public record SavePreparedKeyboardButton(
    @JsonProperty("user_id") long userId,
    @JsonProperty("button") KeyboardButton button
) implements TelegramMethod<PreparedKeyboardButton> {

    @Override
    public String apiMethod() {
        return "savePreparedKeyboardButton";
    }

    @Override
    public String apiReturnType() {
        return "PreparedKeyboardButton";
    }

    public SavePreparedKeyboardButton withUserId(long userId) {
        return new SavePreparedKeyboardButton(userId, button);
    }

    public SavePreparedKeyboardButton withButton(KeyboardButton button) {
        return new SavePreparedKeyboardButton(userId, button);
    }
}
