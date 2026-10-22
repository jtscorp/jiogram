package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;
import java.util.List;
import java.util.Objects;

/**
 * Represents an issue with a list of scans. The error is considered resolved when the list of files
 * containing the scans changes.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorfiles">PassportElementErrorFiles in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PassportElementErrorFiles implements PassportElementError {

    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private final PassportElementErrorType source;

    @JsonProperty("type")
    private final PassportElementType type;

    @JsonProperty("file_hashes")
    private final List<String> fileHashes;

    @JsonProperty("message")
    private final String message;

    /**
     * Creates a new {@code PassportElementErrorFiles} instance.
     *
     * @param source Error source, must be files
     * @param type The section of the user's Telegram Passport which has the issue, one of
     *     'utility_bill', 'bank_statement', 'rental_agreement', 'passport_registration',
     *     'temporary_registration'
     * @param fileHashes List of base64-encoded file hashes
     * @param message Error message
     */
    @JsonCreator
    public PassportElementErrorFiles(
            @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("file_hashes") List<String> fileHashes,
            @JsonProperty("message") String message) {
        this.source = source;
        this.type = type;
        this.fileHashes = fileHashes;
        this.message = message;
    }

    public static PassportElementErrorFiles of(PassportElementType type, List<String> fileHashes, String message) {
        return new PassportElementErrorFiles(PassportElementErrorType.FILES, type, fileHashes, message);
    }

    /**
     * Error source, must be files
     */
    public PassportElementErrorType source() {
        return source;
    }

    /**
     * The section of the user's Telegram Passport which has the issue, one of 'utility_bill',
     * 'bank_statement', 'rental_agreement', 'passport_registration', 'temporary_registration'
     */
    public PassportElementType type() {
        return type;
    }

    /**
     * List of base64-encoded file hashes
     */
    public List<String> fileHashes() {
        return fileHashes;
    }

    /**
     * Error message
     */
    public String message() {
        return message;
    }

    public PassportElementErrorFiles withType(PassportElementType type) {
        return new PassportElementErrorFiles(source, type, fileHashes, message);
    }

    public PassportElementErrorFiles withFileHashes(List<String> fileHashes) {
        return new PassportElementErrorFiles(source, type, fileHashes, message);
    }

    public PassportElementErrorFiles withMessage(String message) {
        return new PassportElementErrorFiles(source, type, fileHashes, message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassportElementErrorFiles)) {
            return false;
        }
        PassportElementErrorFiles that = (PassportElementErrorFiles) o;
        return Objects.equals(this.source, that.source)
                && Objects.equals(this.type, that.type)
                && Objects.equals(this.fileHashes, that.fileHashes)
                && Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.type, this.fileHashes, this.message);
    }

    @Override
    public String toString() {
        return "PassportElementErrorFiles[source=" + this.source
                + ", type=" + this.type
                + ", fileHashes=" + this.fileHashes
                + ", message=" + this.message
                + "]";
    }
}
