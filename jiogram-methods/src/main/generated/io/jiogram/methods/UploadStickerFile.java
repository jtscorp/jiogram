package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to upload a file with a sticker for later use in the createNewStickerSet,
 * addStickerToSet, or replaceStickerInSet methods (the file can be used multiple times). Returns
 * the uploaded File on success.
 *
 * @param userId User identifier of sticker file owner
 * @param sticker A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See
 *     https://core.telegram.org/stickers for technical requirements. More information on Sending
 *     Files
 * @param stickerFormat Format of the sticker, must be one of 'static', 'animated', 'video'
 * @see <a href="https://core.telegram.org/bots/api#uploadstickerfile">uploadStickerFile in the Bot API</a>
 */
public record UploadStickerFile(
    @JsonProperty("user_id") long userId,
    @JsonProperty("sticker") InputFile sticker,
    @JsonProperty("sticker_format") String stickerFormat
) implements TelegramMethod<File> {

    @Override
    public String apiMethod() {
        return "uploadStickerFile";
    }

    @Override
    public String apiReturnType() {
        return "File";
    }
}
