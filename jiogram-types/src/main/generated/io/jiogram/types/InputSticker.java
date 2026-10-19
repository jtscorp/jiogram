package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.MaskPosition;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputSticker(
    @JsonProperty("sticker") InputFileOrString sticker,
    @JsonProperty("format") String format,
    @JsonProperty("emoji_list") List<String> emojiList,
    @JsonProperty("mask_position") @Nullable MaskPosition maskPosition,
    @JsonProperty("keywords") @Nullable List<String> keywords
) {}
