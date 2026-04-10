package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaskPosition;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputSticker {
    @JsonProperty("sticker") private final String sticker;
    @JsonProperty("format") private final String format;
    @JsonProperty("emoji_list") private final List<String> emojiList;
    @JsonProperty("mask_position") @Nullable private final MaskPosition maskPosition;
    @JsonProperty("keywords") @Nullable private final List<String> keywords;

    @JsonCreator
    public InputSticker(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("format") String format,
            @JsonProperty("emoji_list") List<String> emojiList,
            @JsonProperty("mask_position") @Nullable MaskPosition maskPosition,
            @JsonProperty("keywords") @Nullable List<String> keywords
    ) {
        this.sticker = sticker;
        this.format = format;
        this.emojiList = emojiList;
        this.maskPosition = maskPosition;
        this.keywords = keywords;
    }

    public String sticker() {
        return this.sticker;
    }

    public String format() {
        return this.format;
    }

    public List<String> emojiList() {
        return this.emojiList;
    }

    public MaskPosition maskPosition() {
        return this.maskPosition;
    }

    public List<String> keywords() {
        return this.keywords;
    }
}
