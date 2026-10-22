package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Upon receiving a message with this object, Telegram clients will remove the current custom
 * keyboard and display the default letter-keyboard. By default, custom keyboards are displayed
 * until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are
 * hidden immediately after the user presses a button (see ReplyKeyboardMarkup). Not supported in
 * channels and for messages sent on behalf of a Telegram Business account.
 *
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardremove">ReplyKeyboardRemove in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReplyKeyboardRemove implements ReplyMarkup {

    @JsonProperty("remove_keyboard")
    private final boolean removeKeyboard;

    @JsonProperty("selective")
    private final @Nullable Boolean selective;

    /**
     * Creates a new {@code ReplyKeyboardRemove} instance.
     *
     * @param removeKeyboard Requests clients to remove the custom keyboard (user will not be able
     *     to summon this keyboard; if you want to hide the keyboard from sight but keep it
     *     accessible, use one_time_keyboard in ReplyKeyboardMarkup)
     * @param selective Use this parameter if you want to remove the keyboard for specific users
     *     only. Targets: 1) users that are &#64;mentioned in the text of the Message object; 2) if
     *     the bot's message is a reply to a message in the same chat and forum topic, sender of the
     *     original message. Example: A user votes in a poll, bot returns confirmation message in
     *     reply to the vote and removes the keyboard for that user, while still showing the
     *     keyboard with poll options to users who haven't voted yet.
     */
    @JsonCreator
    public ReplyKeyboardRemove(
            @JsonProperty("remove_keyboard") boolean removeKeyboard,
            @JsonProperty("selective") @Nullable Boolean selective) {
        this.removeKeyboard = removeKeyboard;
        this.selective = selective;
    }

    public static ReplyKeyboardRemove of(boolean removeKeyboard) {
        return new ReplyKeyboardRemove(removeKeyboard, null);
    }

    /**
     * Requests clients to remove the custom keyboard (user will not be able to summon this
     * keyboard; if you want to hide the keyboard from sight but keep it accessible, use
     * one_time_keyboard in ReplyKeyboardMarkup)
     */
    public boolean removeKeyboard() {
        return removeKeyboard;
    }

    /**
     * Use this parameter if you want to remove the keyboard for specific users only. Targets: 1)
     * users that are &#64;mentioned in the text of the Message object; 2) if the bot's message is a
     * reply to a message in the same chat and forum topic, sender of the original message. Example:
     * A user votes in a poll, bot returns confirmation message in reply to the vote and removes the
     * keyboard for that user, while still showing the keyboard with poll options to users who
     * haven't voted yet.
     */
    public @Nullable Boolean selective() {
        return selective;
    }

    public ReplyKeyboardRemove withRemoveKeyboard(boolean removeKeyboard) {
        return new ReplyKeyboardRemove(removeKeyboard, selective);
    }

    public ReplyKeyboardRemove withSelective(@Nullable Boolean selective) {
        return new ReplyKeyboardRemove(removeKeyboard, selective);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReplyKeyboardRemove)) {
            return false;
        }
        ReplyKeyboardRemove that = (ReplyKeyboardRemove) o;
        return this.removeKeyboard == that.removeKeyboard
                && Objects.equals(this.selective, that.selective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.removeKeyboard, this.selective);
    }

    @Override
    public String toString() {
        return "ReplyKeyboardRemove[removeKeyboard=" + this.removeKeyboard
                + ", selective=" + this.selective
                + "]";
    }
}
