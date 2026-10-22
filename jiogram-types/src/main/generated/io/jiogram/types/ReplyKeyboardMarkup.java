package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.KeyboardButton;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a custom keyboard with reply options (see Introduction to bots for details
 * and examples). Not supported in channels and for messages sent on behalf of a Telegram Business
 * account.
 *
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">ReplyKeyboardMarkup in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReplyKeyboardMarkup implements ReplyMarkup {

    @JsonProperty("keyboard")
    private final List<List<KeyboardButton>> keyboard;

    @JsonProperty("is_persistent")
    private final @Nullable Boolean isPersistent;

    @JsonProperty("resize_keyboard")
    private final @Nullable Boolean resizeKeyboard;

    @JsonProperty("one_time_keyboard")
    private final @Nullable Boolean oneTimeKeyboard;

    @JsonProperty("input_field_placeholder")
    private final @Nullable String inputFieldPlaceholder;

    @JsonProperty("selective")
    private final @Nullable Boolean selective;

    /**
     * Creates a new {@code ReplyKeyboardMarkup} instance.
     *
     * @param keyboard Array of button rows, each represented by an Array of KeyboardButton objects
     * @param isPersistent Requests clients to always show the keyboard when the regular keyboard is
     *     hidden. Defaults to false, in which case the custom keyboard can be hidden and opened
     *     with a keyboard icon.
     * @param resizeKeyboard Requests clients to resize the keyboard vertically for optimal fit
     *     (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to
     *     false, in which case the custom keyboard is always of the same height as the app's
     *     standard keyboard.
     * @param oneTimeKeyboard Requests clients to hide the keyboard as soon as it's been used. The
     *     keyboard will still be available, but clients will automatically display the usual
     *     letter-keyboard in the chat - the user can press a special button in the input field to
     *     see the custom keyboard again. Defaults to false.
     * @param inputFieldPlaceholder The placeholder to be shown in the input field when the keyboard
     *     is active; 1-64 characters
     * @param selective Use this parameter if you want to show the keyboard to specific users only.
     *     Targets: 1) users that are &#64;mentioned in the text of the Message object; 2) if the
     *     bot's message is a reply to a message in the same chat and forum topic, sender of the
     *     original message. Example: A user requests to change the bot's language, bot replies to
     *     the request with a keyboard to select the new language. Other users in the group don't
     *     see the keyboard.
     */
    @JsonCreator
    public ReplyKeyboardMarkup(
            @JsonProperty("keyboard") List<List<KeyboardButton>> keyboard,
            @JsonProperty("is_persistent") @Nullable Boolean isPersistent,
            @JsonProperty("resize_keyboard") @Nullable Boolean resizeKeyboard,
            @JsonProperty("one_time_keyboard") @Nullable Boolean oneTimeKeyboard,
            @JsonProperty("input_field_placeholder") @Nullable String inputFieldPlaceholder,
            @JsonProperty("selective") @Nullable Boolean selective) {
        this.keyboard = keyboard;
        this.isPersistent = isPersistent;
        this.resizeKeyboard = resizeKeyboard;
        this.oneTimeKeyboard = oneTimeKeyboard;
        this.inputFieldPlaceholder = inputFieldPlaceholder;
        this.selective = selective;
    }

    public static ReplyKeyboardMarkup of(List<List<KeyboardButton>> keyboard) {
        return new ReplyKeyboardMarkup(keyboard, null, null, null, null, null);
    }

    /**
     * Array of button rows, each represented by an Array of KeyboardButton objects
     */
    public List<List<KeyboardButton>> keyboard() {
        return keyboard;
    }

    /**
     * Requests clients to always show the keyboard when the regular keyboard is hidden. Defaults to
     * false, in which case the custom keyboard can be hidden and opened with a keyboard icon.
     */
    public @Nullable Boolean isPersistent() {
        return isPersistent;
    }

    /**
     * Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard
     * smaller if there are just two rows of buttons). Defaults to false, in which case the custom
     * keyboard is always of the same height as the app's standard keyboard.
     */
    public @Nullable Boolean resizeKeyboard() {
        return resizeKeyboard;
    }

    /**
     * Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be
     * available, but clients will automatically display the usual letter-keyboard in the chat - the
     * user can press a special button in the input field to see the custom keyboard again. Defaults
     * to false.
     */
    public @Nullable Boolean oneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    /**
     * The placeholder to be shown in the input field when the keyboard is active; 1-64 characters
     */
    public @Nullable String inputFieldPlaceholder() {
        return inputFieldPlaceholder;
    }

    /**
     * Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users
     * that are &#64;mentioned in the text of the Message object; 2) if the bot's message is a reply
     * to a message in the same chat and forum topic, sender of the original message. Example: A
     * user requests to change the bot's language, bot replies to the request with a keyboard to
     * select the new language. Other users in the group don't see the keyboard.
     */
    public @Nullable Boolean selective() {
        return selective;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReplyKeyboardMarkup)) {
            return false;
        }
        ReplyKeyboardMarkup that = (ReplyKeyboardMarkup) o;
        return Objects.equals(this.keyboard, that.keyboard)
                && Objects.equals(this.isPersistent, that.isPersistent)
                && Objects.equals(this.resizeKeyboard, that.resizeKeyboard)
                && Objects.equals(this.oneTimeKeyboard, that.oneTimeKeyboard)
                && Objects.equals(this.inputFieldPlaceholder, that.inputFieldPlaceholder)
                && Objects.equals(this.selective, that.selective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.keyboard, this.isPersistent, this.resizeKeyboard, this.oneTimeKeyboard, this.inputFieldPlaceholder, this.selective);
    }

    @Override
    public String toString() {
        return "ReplyKeyboardMarkup[keyboard=" + this.keyboard
                + ", isPersistent=" + this.isPersistent
                + ", resizeKeyboard=" + this.resizeKeyboard
                + ", oneTimeKeyboard=" + this.oneTimeKeyboard
                + ", inputFieldPlaceholder=" + this.inputFieldPlaceholder
                + ", selective=" + this.selective
                + "]";
    }
}
