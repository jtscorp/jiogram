package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.TelegramMethod;

public record GetFile(
    @JsonProperty("file_id") String fileId
) implements TelegramMethod<File> {

    @Override
    public String apiMethod() {
        return "getFile";
    }

    @Override
    public String apiReturnType() {
        return "File";
    }
}
