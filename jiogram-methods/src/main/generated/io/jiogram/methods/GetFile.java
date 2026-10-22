package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.TelegramMethod;

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
 * @param fileId File identifier to get information about
 * @see <a href="https://core.telegram.org/bots/api#getfile">getFile in the Bot API</a>
 */
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
