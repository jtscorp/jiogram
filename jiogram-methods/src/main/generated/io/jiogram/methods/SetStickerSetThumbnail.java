package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to set the thumbnail of a regular or mask sticker set. The format of the
 * thumbnail file must match the format of the stickers in the set. Returns True on success.
 *
 * @param name Sticker set name
 * @param userId User identifier of the sticker set owner
 * @param thumbnail A .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size
 *     and have a width and height of exactly 100px, or a .TGS animation with a thumbnail up to 32
 *     kilobytes in size (see https://core.telegram.org/stickers#animation-requirements for animated
 *     sticker technical requirements), or a .WEBM video with the thumbnail up to 32 kilobytes in
 *     size; see https://core.telegram.org/stickers#video-requirements for video sticker technical
 *     requirements. Pass a file_id as a String to send a file that already exists on the Telegram
 *     servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload
 *     a new one using multipart/form-data. More information on Sending Files. Animated and video
 *     sticker set thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is
 *     dropped and the first sticker is used as the thumbnail.
 * @param format Format of the thumbnail, must be one of 'static' for a .WEBP or .PNG image,
 *     'animated' for a .TGS animation, or 'video' for a .WEBM video
 * @see <a href="https://core.telegram.org/bots/api#setstickersetthumbnail">setStickerSetThumbnail in the Bot API</a>
 */
public record SetStickerSetThumbnail(
    @JsonProperty("name") String name,
    @JsonProperty("user_id") long userId,
    @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
    @JsonProperty("format") String format
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerSetThumbnail";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetStickerSetThumbnail of(String name, long userId, String format) {
        return new SetStickerSetThumbnail(name, userId, null, format);
    }

    public SetStickerSetThumbnail withName(String name) {
        return new SetStickerSetThumbnail(name, userId, thumbnail, format);
    }

    public SetStickerSetThumbnail withUserId(long userId) {
        return new SetStickerSetThumbnail(name, userId, thumbnail, format);
    }

    public SetStickerSetThumbnail withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new SetStickerSetThumbnail(name, userId, thumbnail, format);
    }

    public SetStickerSetThumbnail withFormat(String format) {
        return new SetStickerSetThumbnail(name, userId, thumbnail, format);
    }
}
