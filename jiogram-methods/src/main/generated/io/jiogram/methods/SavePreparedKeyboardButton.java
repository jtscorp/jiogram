package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButton;
import io.jiogram.types.PreparedKeyboardButton;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Stores a keyboard button that can be used by a user within a Mini App. Returns a
 * PreparedKeyboardButton object.
 *
 * @see <a href="https://core.telegram.org/bots/api#savepreparedkeyboardbutton">savePreparedKeyboardButton in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SavePreparedKeyboardButton implements TelegramMethod<PreparedKeyboardButton> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("button")
    private final KeyboardButton button;

    /**
     * Creates a new {@code SavePreparedKeyboardButton} instance.
     *
     * @param userId Unique identifier of the target user that can use the button
     * @param button A JSON-serialized object describing the button to be saved. The button must be
     *     of the type request_users, request_chat, or request_managed_bot
     */
    @JsonCreator
    public SavePreparedKeyboardButton(
            @JsonProperty("user_id") long userId,
            @JsonProperty("button") KeyboardButton button) {
        this.userId = userId;
        this.button = button;
    }

    @Override
    public String apiMethod() {
        return "savePreparedKeyboardButton";
    }

    @Override
    public String apiReturnType() {
        return "PreparedKeyboardButton";
    }

    /**
     * Unique identifier of the target user that can use the button
     */
    public long userId() {
        return userId;
    }

    /**
     * A JSON-serialized object describing the button to be saved. The button must be of the type
     * request_users, request_chat, or request_managed_bot
     */
    public KeyboardButton button() {
        return button;
    }

    public SavePreparedKeyboardButton withUserId(long userId) {
        return new SavePreparedKeyboardButton(userId, button);
    }

    public SavePreparedKeyboardButton withButton(KeyboardButton button) {
        return new SavePreparedKeyboardButton(userId, button);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SavePreparedKeyboardButton)) {
            return false;
        }
        SavePreparedKeyboardButton that = (SavePreparedKeyboardButton) o;
        return this.userId == that.userId
                && Objects.equals(this.button, that.button);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.button);
    }

    @Override
    public String toString() {
        return "SavePreparedKeyboardButton[userId=" + this.userId
                + ", button=" + this.button
                + "]";
    }
}
