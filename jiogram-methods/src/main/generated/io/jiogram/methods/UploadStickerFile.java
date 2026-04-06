package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;

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
