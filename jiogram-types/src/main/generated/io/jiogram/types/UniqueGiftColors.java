package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This object contains information about the color scheme for a user's name, message replies and
 * link previews based on a unique gift.
 *
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftcolors">UniqueGiftColors in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UniqueGiftColors {

    @JsonProperty("model_custom_emoji_id")
    private final String modelCustomEmojiId;

    @JsonProperty("symbol_custom_emoji_id")
    private final String symbolCustomEmojiId;

    @JsonProperty("light_theme_main_color")
    private final long lightThemeMainColor;

    @JsonProperty("light_theme_other_colors")
    private final List<Long> lightThemeOtherColors;

    @JsonProperty("dark_theme_main_color")
    private final long darkThemeMainColor;

    @JsonProperty("dark_theme_other_colors")
    private final List<Long> darkThemeOtherColors;

    /**
     * Creates a new {@code UniqueGiftColors} instance.
     *
     * @param modelCustomEmojiId Custom emoji identifier of the unique gift's model
     * @param symbolCustomEmojiId Custom emoji identifier of the unique gift's symbol
     * @param lightThemeMainColor Main color used in light themes; RGB format
     * @param lightThemeOtherColors List of 1-3 additional colors used in light themes; RGB format
     * @param darkThemeMainColor Main color used in dark themes; RGB format
     * @param darkThemeOtherColors List of 1-3 additional colors used in dark themes; RGB format
     */
    @JsonCreator
    public UniqueGiftColors(
            @JsonProperty("model_custom_emoji_id") String modelCustomEmojiId,
            @JsonProperty("symbol_custom_emoji_id") String symbolCustomEmojiId,
            @JsonProperty("light_theme_main_color") long lightThemeMainColor,
            @JsonProperty("light_theme_other_colors") List<Long> lightThemeOtherColors,
            @JsonProperty("dark_theme_main_color") long darkThemeMainColor,
            @JsonProperty("dark_theme_other_colors") List<Long> darkThemeOtherColors) {
        this.modelCustomEmojiId = modelCustomEmojiId;
        this.symbolCustomEmojiId = symbolCustomEmojiId;
        this.lightThemeMainColor = lightThemeMainColor;
        this.lightThemeOtherColors = lightThemeOtherColors;
        this.darkThemeMainColor = darkThemeMainColor;
        this.darkThemeOtherColors = darkThemeOtherColors;
    }

    /**
     * Custom emoji identifier of the unique gift's model
     */
    public String modelCustomEmojiId() {
        return modelCustomEmojiId;
    }

    /**
     * Custom emoji identifier of the unique gift's symbol
     */
    public String symbolCustomEmojiId() {
        return symbolCustomEmojiId;
    }

    /**
     * Main color used in light themes; RGB format
     */
    public long lightThemeMainColor() {
        return lightThemeMainColor;
    }

    /**
     * List of 1-3 additional colors used in light themes; RGB format
     */
    public List<Long> lightThemeOtherColors() {
        return lightThemeOtherColors;
    }

    /**
     * Main color used in dark themes; RGB format
     */
    public long darkThemeMainColor() {
        return darkThemeMainColor;
    }

    /**
     * List of 1-3 additional colors used in dark themes; RGB format
     */
    public List<Long> darkThemeOtherColors() {
        return darkThemeOtherColors;
    }

    public UniqueGiftColors withModelCustomEmojiId(String modelCustomEmojiId) {
        return new UniqueGiftColors(modelCustomEmojiId, symbolCustomEmojiId, lightThemeMainColor, lightThemeOtherColors, darkThemeMainColor, darkThemeOtherColors);
    }

    public UniqueGiftColors withSymbolCustomEmojiId(String symbolCustomEmojiId) {
        return new UniqueGiftColors(modelCustomEmojiId, symbolCustomEmojiId, lightThemeMainColor, lightThemeOtherColors, darkThemeMainColor, darkThemeOtherColors);
    }

    public UniqueGiftColors withLightThemeMainColor(long lightThemeMainColor) {
        return new UniqueGiftColors(modelCustomEmojiId, symbolCustomEmojiId, lightThemeMainColor, lightThemeOtherColors, darkThemeMainColor, darkThemeOtherColors);
    }

    public UniqueGiftColors withLightThemeOtherColors(List<Long> lightThemeOtherColors) {
        return new UniqueGiftColors(modelCustomEmojiId, symbolCustomEmojiId, lightThemeMainColor, lightThemeOtherColors, darkThemeMainColor, darkThemeOtherColors);
    }

    public UniqueGiftColors withDarkThemeMainColor(long darkThemeMainColor) {
        return new UniqueGiftColors(modelCustomEmojiId, symbolCustomEmojiId, lightThemeMainColor, lightThemeOtherColors, darkThemeMainColor, darkThemeOtherColors);
    }

    public UniqueGiftColors withDarkThemeOtherColors(List<Long> darkThemeOtherColors) {
        return new UniqueGiftColors(modelCustomEmojiId, symbolCustomEmojiId, lightThemeMainColor, lightThemeOtherColors, darkThemeMainColor, darkThemeOtherColors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniqueGiftColors)) {
            return false;
        }
        UniqueGiftColors that = (UniqueGiftColors) o;
        return Objects.equals(this.modelCustomEmojiId, that.modelCustomEmojiId)
                && Objects.equals(this.symbolCustomEmojiId, that.symbolCustomEmojiId)
                && this.lightThemeMainColor == that.lightThemeMainColor
                && Objects.equals(this.lightThemeOtherColors, that.lightThemeOtherColors)
                && this.darkThemeMainColor == that.darkThemeMainColor
                && Objects.equals(this.darkThemeOtherColors, that.darkThemeOtherColors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.modelCustomEmojiId, this.symbolCustomEmojiId, this.lightThemeMainColor, this.lightThemeOtherColors, this.darkThemeMainColor, this.darkThemeOtherColors);
    }

    @Override
    public String toString() {
        return "UniqueGiftColors[modelCustomEmojiId=" + this.modelCustomEmojiId
                + ", symbolCustomEmojiId=" + this.symbolCustomEmojiId
                + ", lightThemeMainColor=" + this.lightThemeMainColor
                + ", lightThemeOtherColors=" + this.lightThemeOtherColors
                + ", darkThemeMainColor=" + this.darkThemeMainColor
                + ", darkThemeOtherColors=" + this.darkThemeOtherColors
                + "]";
    }
}
