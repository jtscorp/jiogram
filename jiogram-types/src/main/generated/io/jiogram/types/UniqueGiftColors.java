package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * This object contains information about the color scheme for a user's name, message replies and
 * link previews based on a unique gift.
 *
 * @param modelCustomEmojiId Custom emoji identifier of the unique gift's model
 * @param symbolCustomEmojiId Custom emoji identifier of the unique gift's symbol
 * @param lightThemeMainColor Main color used in light themes; RGB format
 * @param lightThemeOtherColors List of 1-3 additional colors used in light themes; RGB format
 * @param darkThemeMainColor Main color used in dark themes; RGB format
 * @param darkThemeOtherColors List of 1-3 additional colors used in dark themes; RGB format
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftcolors">UniqueGiftColors in the Bot API</a>
 */
public record UniqueGiftColors(
    @JsonProperty("model_custom_emoji_id") String modelCustomEmojiId,
    @JsonProperty("symbol_custom_emoji_id") String symbolCustomEmojiId,
    @JsonProperty("light_theme_main_color") long lightThemeMainColor,
    @JsonProperty("light_theme_other_colors") List<Long> lightThemeOtherColors,
    @JsonProperty("dark_theme_main_color") long darkThemeMainColor,
    @JsonProperty("dark_theme_other_colors") List<Long> darkThemeOtherColors
) {}
