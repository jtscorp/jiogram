package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class UniqueGiftColors {
    @JsonProperty("model_custom_emoji_id") private final String modelCustomEmojiId;
    @JsonProperty("symbol_custom_emoji_id") private final String symbolCustomEmojiId;
    @JsonProperty("light_theme_main_color") private final long lightThemeMainColor;
    @JsonProperty("light_theme_other_colors") private final List<Long> lightThemeOtherColors;
    @JsonProperty("dark_theme_main_color") private final long darkThemeMainColor;
    @JsonProperty("dark_theme_other_colors") private final List<Long> darkThemeOtherColors;

    @JsonCreator
    public UniqueGiftColors(
            @JsonProperty("model_custom_emoji_id") String modelCustomEmojiId,
            @JsonProperty("symbol_custom_emoji_id") String symbolCustomEmojiId,
            @JsonProperty("light_theme_main_color") long lightThemeMainColor,
            @JsonProperty("light_theme_other_colors") List<Long> lightThemeOtherColors,
            @JsonProperty("dark_theme_main_color") long darkThemeMainColor,
            @JsonProperty("dark_theme_other_colors") List<Long> darkThemeOtherColors
    ) {
        this.modelCustomEmojiId = modelCustomEmojiId;
        this.symbolCustomEmojiId = symbolCustomEmojiId;
        this.lightThemeMainColor = lightThemeMainColor;
        this.lightThemeOtherColors = lightThemeOtherColors;
        this.darkThemeMainColor = darkThemeMainColor;
        this.darkThemeOtherColors = darkThemeOtherColors;
    }

    public String modelCustomEmojiId() {
        return this.modelCustomEmojiId;
    }

    public String symbolCustomEmojiId() {
        return this.symbolCustomEmojiId;
    }

    public long lightThemeMainColor() {
        return this.lightThemeMainColor;
    }

    public List<Long> lightThemeOtherColors() {
        return this.lightThemeOtherColors;
    }

    public long darkThemeMainColor() {
        return this.darkThemeMainColor;
    }

    public List<Long> darkThemeOtherColors() {
        return this.darkThemeOtherColors;
    }
}
