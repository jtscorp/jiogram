package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.TelegramMethod;

public class GetFile implements TelegramMethod<File> {
    @JsonProperty("file_id") private final String fileId;

    @JsonCreator
    public GetFile(
            @JsonProperty("file_id") String fileId
    ) {
        this.fileId = fileId;
    }

    public String fileId() {
        return this.fileId;
    }

    @Override
    public String apiMethod() {
        return "getFile";
    }

    @Override
    public String apiReturnType() {
        return "File";
    }
}
