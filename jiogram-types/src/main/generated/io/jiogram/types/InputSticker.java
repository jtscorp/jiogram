package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.MaskPosition;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object describes a sticker to be added to a sticker set.
 *
 * @param sticker The added sticker. Pass a file_id as a String to send a file that already exists
 *     on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the
 *     Internet, or pass 'attach://&lt;file_attach_name&gt;' to upload a new file using
 *     multipart/form-data under &lt;file_attach_name&gt; name. Animated and video stickers can't be
 *     uploaded via HTTP URL. More information on Sending Files
 * @param format Format of the added sticker, must be one of 'static' for a .WEBP or .PNG image,
 *     'animated' for a .TGS animation, 'video' for a .WEBM video
 * @param emojiList List of 1-20 emoji associated with the sticker
 * @param maskPosition Position where the mask should be placed on faces. For 'mask' stickers only.
 * @param keywords List of 0-20 search keywords for the sticker with total length of up to 64
 *     characters. For 'regular' and 'custom_emoji' stickers only.
 * @see <a href="https://core.telegram.org/bots/api#inputsticker">InputSticker in the Bot API</a>
 */
public record InputSticker(
    @JsonProperty("sticker") InputFileOrString sticker,
    @JsonProperty("format") String format,
    @JsonProperty("emoji_list") List<String> emojiList,
    @JsonProperty("mask_position") @Nullable MaskPosition maskPosition,
    @JsonProperty("keywords") @Nullable List<String> keywords
) {

    public static InputSticker of(InputFileOrString sticker, String format, List<String> emojiList) {
        return new InputSticker(sticker, format, emojiList, null, null);
    }

    public InputSticker withSticker(InputFileOrString sticker) {
        return new InputSticker(sticker, format, emojiList, maskPosition, keywords);
    }

    public InputSticker withFormat(String format) {
        return new InputSticker(sticker, format, emojiList, maskPosition, keywords);
    }

    public InputSticker withEmojiList(List<String> emojiList) {
        return new InputSticker(sticker, format, emojiList, maskPosition, keywords);
    }

    public InputSticker withMaskPosition(@Nullable MaskPosition maskPosition) {
        return new InputSticker(sticker, format, emojiList, maskPosition, keywords);
    }

    public InputSticker withKeywords(@Nullable List<String> keywords) {
        return new InputSticker(sticker, format, emojiList, maskPosition, keywords);
    }
}
