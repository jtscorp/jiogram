package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to get basic information about a file and prepare it for downloading. For the
 * moment, bots can download files of up to 20MB in size. On success, a File object is returned. The
 * file can then be downloaded via the link
 * https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;, where &lt;file_path&gt; is
 * taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When
 * the link expires, a new one can be requested by calling getFile again.
 * <br>Note: This function may not preserve the original file name and MIME type. You should save
 * the file's MIME type and name (if available) when the File object is received.
 *
 * @see <a href="https://core.telegram.org/bots/api#getfile">getFile in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetFile implements TelegramMethod<File> {

    @JsonProperty("file_id")
    private final String fileId;

    /**
     * Creates a new {@code GetFile} instance.
     *
     * @param fileId File identifier to get information about
     */
    @JsonCreator
    public GetFile(
            @JsonProperty("file_id") String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String apiMethod() {
        return "getFile";
    }

    @Override
    public String apiReturnType() {
        return "File";
    }

    /**
     * File identifier to get information about
     */
    public String fileId() {
        return fileId;
    }

    public GetFile withFileId(String fileId) {
        return new GetFile(fileId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetFile)) {
            return false;
        }
        GetFile that = (GetFile) o;
        return Objects.equals(this.fileId, that.fileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId);
    }

    @Override
    public String toString() {
        return "GetFile[fileId=" + this.fileId
                + "]";
    }
}
