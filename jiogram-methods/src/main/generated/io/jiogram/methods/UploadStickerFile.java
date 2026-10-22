package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to upload a file with a sticker for later use in the createNewStickerSet,
 * addStickerToSet, or replaceStickerInSet methods (the file can be used multiple times). Returns
 * the uploaded File on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#uploadstickerfile">uploadStickerFile in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UploadStickerFile implements TelegramMethod<File> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("sticker")
    private final InputFile sticker;

    @JsonProperty("sticker_format")
    private final String stickerFormat;

    /**
     * Creates a new {@code UploadStickerFile} instance.
     *
     * @param userId User identifier of sticker file owner
     * @param sticker A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See
     *     https://core.telegram.org/stickers for technical requirements. More information on
     *     Sending Files
     * @param stickerFormat Format of the sticker, must be one of 'static', 'animated', 'video'
     */
    @JsonCreator
    public UploadStickerFile(
            @JsonProperty("user_id") long userId,
            @JsonProperty("sticker") InputFile sticker,
            @JsonProperty("sticker_format") String stickerFormat) {
        this.userId = userId;
        this.sticker = sticker;
        this.stickerFormat = stickerFormat;
    }

    @Override
    public String apiMethod() {
        return "uploadStickerFile";
    }

    @Override
    public String apiReturnType() {
        return "File";
    }

    /**
     * User identifier of sticker file owner
     */
    public long userId() {
        return userId;
    }

    /**
     * A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See
     * https://core.telegram.org/stickers for technical requirements. More information on Sending
     * Files
     */
    public InputFile sticker() {
        return sticker;
    }

    /**
     * Format of the sticker, must be one of 'static', 'animated', 'video'
     */
    public String stickerFormat() {
        return stickerFormat;
    }

    public UploadStickerFile withUserId(long userId) {
        return new UploadStickerFile(userId, sticker, stickerFormat);
    }

    public UploadStickerFile withSticker(InputFile sticker) {
        return new UploadStickerFile(userId, sticker, stickerFormat);
    }

    public UploadStickerFile withStickerFormat(String stickerFormat) {
        return new UploadStickerFile(userId, sticker, stickerFormat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UploadStickerFile)) {
            return false;
        }
        UploadStickerFile that = (UploadStickerFile) o;
        return this.userId == that.userId
                && Objects.equals(this.sticker, that.sticker)
                && Objects.equals(this.stickerFormat, that.stickerFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.sticker, this.stickerFormat);
    }

    @Override
    public String toString() {
        return "UploadStickerFile[userId=" + this.userId
                + ", sticker=" + this.sticker
                + ", stickerFormat=" + this.stickerFormat
                + "]";
    }
}
