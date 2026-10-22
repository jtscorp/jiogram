package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButton;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a custom keyboard with reply options (see Introduction to bots for details
 * and examples). Not supported in channels and for messages sent on behalf of a Telegram Business
 * account.
 *
 * @param keyboard Array of button rows, each represented by an Array of KeyboardButton objects
 * @param isPersistent Requests clients to always show the keyboard when the regular keyboard is
 *     hidden. Defaults to false, in which case the custom keyboard can be hidden and opened with a
 *     keyboard icon.
 * @param resizeKeyboard Requests clients to resize the keyboard vertically for optimal fit (e.g.,
 *     make the keyboard smaller if there are just two rows of buttons). Defaults to false, in which
 *     case the custom keyboard is always of the same height as the app's standard keyboard.
 * @param oneTimeKeyboard Requests clients to hide the keyboard as soon as it's been used. The
 *     keyboard will still be available, but clients will automatically display the usual
 *     letter-keyboard in the chat - the user can press a special button in the input field to see
 *     the custom keyboard again. Defaults to false.
 * @param inputFieldPlaceholder The placeholder to be shown in the input field when the keyboard is
 *     active; 1-64 characters
 * @param selective Use this parameter if you want to show the keyboard to specific users only.
 *     Targets: 1) users that are &#64;mentioned in the text of the Message object; 2) if the bot's
 *     message is a reply to a message in the same chat and forum topic, sender of the original
 *     message. Example: A user requests to change the bot's language, bot replies to the request
 *     with a keyboard to select the new language. Other users in the group don't see the keyboard.
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">ReplyKeyboardMarkup in the Bot API</a>
 */
public record ReplyKeyboardMarkup(
    @JsonProperty("keyboard") List<List<KeyboardButton>> keyboard,
    @JsonProperty("is_persistent") @Nullable Boolean isPersistent,
    @JsonProperty("resize_keyboard") @Nullable Boolean resizeKeyboard,
    @JsonProperty("one_time_keyboard") @Nullable Boolean oneTimeKeyboard,
    @JsonProperty("input_field_placeholder") @Nullable String inputFieldPlaceholder,
    @JsonProperty("selective") @Nullable Boolean selective
) implements ReplyMarkup {

    public ReplyKeyboardMarkup withKeyboard(List<List<KeyboardButton>> keyboard) {
        return new ReplyKeyboardMarkup(keyboard, isPersistent, resizeKeyboard, oneTimeKeyboard, inputFieldPlaceholder, selective);
    }

    public ReplyKeyboardMarkup withIsPersistent(@Nullable Boolean isPersistent) {
        return new ReplyKeyboardMarkup(keyboard, isPersistent, resizeKeyboard, oneTimeKeyboard, inputFieldPlaceholder, selective);
    }

    public ReplyKeyboardMarkup withResizeKeyboard(@Nullable Boolean resizeKeyboard) {
        return new ReplyKeyboardMarkup(keyboard, isPersistent, resizeKeyboard, oneTimeKeyboard, inputFieldPlaceholder, selective);
    }

    public ReplyKeyboardMarkup withOneTimeKeyboard(@Nullable Boolean oneTimeKeyboard) {
        return new ReplyKeyboardMarkup(keyboard, isPersistent, resizeKeyboard, oneTimeKeyboard, inputFieldPlaceholder, selective);
    }

    public ReplyKeyboardMarkup withInputFieldPlaceholder(@Nullable String inputFieldPlaceholder) {
        return new ReplyKeyboardMarkup(keyboard, isPersistent, resizeKeyboard, oneTimeKeyboard, inputFieldPlaceholder, selective);
    }

    public ReplyKeyboardMarkup withSelective(@Nullable Boolean selective) {
        return new ReplyKeyboardMarkup(keyboard, isPersistent, resizeKeyboard, oneTimeKeyboard, inputFieldPlaceholder, selective);
    }
}
