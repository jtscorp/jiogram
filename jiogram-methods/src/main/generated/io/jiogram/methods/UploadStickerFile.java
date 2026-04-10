package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;

public class UploadStickerFile implements TelegramMethod<File> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("sticker") private final InputFile sticker;
    @JsonProperty("sticker_format") private final String stickerFormat;

    @JsonCreator
    public UploadStickerFile(
            @JsonProperty("user_id") long userId,
            @JsonProperty("sticker") InputFile sticker,
            @JsonProperty("sticker_format") String stickerFormat
    ) {
        this.userId = userId;
        this.sticker = sticker;
        this.stickerFormat = stickerFormat;
    }

    public long userId() {
        return this.userId;
    }

    public InputFile sticker() {
        return this.sticker;
    }

    public String stickerFormat() {
        return this.stickerFormat;
    }

    @Override
    public String apiMethod() {
        return "uploadStickerFile";
    }

    @Override
    public String apiReturnType() {
        return "File";
    }
}
