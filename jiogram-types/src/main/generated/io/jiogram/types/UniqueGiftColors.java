package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record UniqueGiftColors(
    @JsonProperty("model_custom_emoji_id") String modelCustomEmojiId,
    @JsonProperty("symbol_custom_emoji_id") String symbolCustomEmojiId,
    @JsonProperty("light_theme_main_color") long lightThemeMainColor,
    @JsonProperty("light_theme_other_colors") List<Long> lightThemeOtherColors,
    @JsonProperty("dark_theme_main_color") long darkThemeMainColor,
    @JsonProperty("dark_theme_other_colors") List<Long> darkThemeOtherColors
) {}
