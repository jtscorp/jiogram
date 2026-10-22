package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardButton;
import java.util.List;
import java.util.Objects;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">InlineKeyboardMarkup in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineKeyboardMarkup implements ReplyMarkup {

    @JsonProperty("inline_keyboard")
    private final List<List<InlineKeyboardButton>> inlineKeyboard;

    /**
     * Creates a new {@code InlineKeyboardMarkup} instance.
     *
     * @param inlineKeyboard Array of button rows, each represented by an Array of
     *     InlineKeyboardButton objects
     */
    @JsonCreator
    public InlineKeyboardMarkup(
            @JsonProperty("inline_keyboard") List<List<InlineKeyboardButton>> inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    /**
     * Array of button rows, each represented by an Array of InlineKeyboardButton objects
     */
    public List<List<InlineKeyboardButton>> inlineKeyboard() {
        return inlineKeyboard;
    }

    public InlineKeyboardMarkup withInlineKeyboard(List<List<InlineKeyboardButton>> inlineKeyboard) {
        return new InlineKeyboardMarkup(inlineKeyboard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineKeyboardMarkup)) {
            return false;
        }
        InlineKeyboardMarkup that = (InlineKeyboardMarkup) o;
        return Objects.equals(this.inlineKeyboard, that.inlineKeyboard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.inlineKeyboard);
    }

    @Override
    public String toString() {
        return "InlineKeyboardMarkup[inlineKeyboard=" + this.inlineKeyboard
                + "]";
    }
}
