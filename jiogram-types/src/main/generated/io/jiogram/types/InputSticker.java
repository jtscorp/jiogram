package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.MaskPosition;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object describes a sticker to be added to a sticker set.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputsticker">InputSticker in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputSticker {

    @JsonProperty("sticker")
    private final InputFileOrString sticker;

    @JsonProperty("format")
    private final String format;

    @JsonProperty("emoji_list")
    private final List<String> emojiList;

    @JsonProperty("mask_position")
    private final @Nullable MaskPosition maskPosition;

    @JsonProperty("keywords")
    private final @Nullable List<String> keywords;

    /**
     * Creates a new {@code InputSticker} instance.
     *
     * @param sticker The added sticker. Pass a file_id as a String to send a file that already
     *     exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file
     *     from the Internet, or pass 'attach://&lt;file_attach_name&gt;' to upload a new file using
     *     multipart/form-data under &lt;file_attach_name&gt; name. Animated and video stickers
     *     can't be uploaded via HTTP URL. More information on Sending Files
     * @param format Format of the added sticker, must be one of 'static' for a .WEBP or .PNG image,
     *     'animated' for a .TGS animation, 'video' for a .WEBM video
     * @param emojiList List of 1-20 emoji associated with the sticker
     * @param maskPosition Position where the mask should be placed on faces. For 'mask' stickers
     *     only.
     * @param keywords List of 0-20 search keywords for the sticker with total length of up to 64
     *     characters. For 'regular' and 'custom_emoji' stickers only.
     */
    @JsonCreator
    public InputSticker(
            @JsonProperty("sticker") InputFileOrString sticker,
            @JsonProperty("format") String format,
            @JsonProperty("emoji_list") List<String> emojiList,
            @JsonProperty("mask_position") @Nullable MaskPosition maskPosition,
            @JsonProperty("keywords") @Nullable List<String> keywords) {
        this.sticker = sticker;
        this.format = format;
        this.emojiList = emojiList;
        this.maskPosition = maskPosition;
        this.keywords = keywords;
    }

    public static InputSticker of(InputFileOrString sticker, String format, List<String> emojiList) {
        return new InputSticker(sticker, format, emojiList, null, null);
    }

    /**
     * The added sticker. Pass a file_id as a String to send a file that already exists on the
     * Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet,
     * or pass 'attach://&lt;file_attach_name&gt;' to upload a new file using multipart/form-data
     * under &lt;file_attach_name&gt; name. Animated and video stickers can't be uploaded via HTTP
     * URL. More information on Sending Files
     */
    public InputFileOrString sticker() {
        return sticker;
    }

    /**
     * Format of the added sticker, must be one of 'static' for a .WEBP or .PNG image, 'animated'
     * for a .TGS animation, 'video' for a .WEBM video
     */
    public String format() {
        return format;
    }

    /**
     * List of 1-20 emoji associated with the sticker
     */
    public List<String> emojiList() {
        return emojiList;
    }

    /**
     * Position where the mask should be placed on faces. For 'mask' stickers only.
     */
    public @Nullable MaskPosition maskPosition() {
        return maskPosition;
    }

    /**
     * List of 0-20 search keywords for the sticker with total length of up to 64 characters. For
     * 'regular' and 'custom_emoji' stickers only.
     */
    public @Nullable List<String> keywords() {
        return keywords;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputSticker)) {
            return false;
        }
        InputSticker that = (InputSticker) o;
        return Objects.equals(this.sticker, that.sticker)
                && Objects.equals(this.format, that.format)
                && Objects.equals(this.emojiList, that.emojiList)
                && Objects.equals(this.maskPosition, that.maskPosition)
                && Objects.equals(this.keywords, that.keywords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sticker, this.format, this.emojiList, this.maskPosition, this.keywords);
    }

    @Override
    public String toString() {
        return "InputSticker[sticker=" + this.sticker
                + ", format=" + this.format
                + ", emojiList=" + this.emojiList
                + ", maskPosition=" + this.maskPosition
                + ", keywords=" + this.keywords
                + "]";
    }
}
