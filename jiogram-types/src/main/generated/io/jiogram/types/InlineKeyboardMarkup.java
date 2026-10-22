package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardButton;
import java.util.List;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 *
 * @param inlineKeyboard Array of button rows, each represented by an Array of InlineKeyboardButton
 *     objects
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">InlineKeyboardMarkup in the Bot API</a>
 */
public record InlineKeyboardMarkup(
    @JsonProperty("inline_keyboard") List<List<InlineKeyboardButton>> inlineKeyboard
) implements ReplyMarkup {}
