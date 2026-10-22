package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;
import java.util.Objects;

/**
 * Represents an issue with a document scan. The error is considered resolved when the file with the
 * document scan changes.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorfile">PassportElementErrorFile in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PassportElementErrorFile implements PassportElementError {

    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private final PassportElementErrorType source;

    @JsonProperty("type")
    private final PassportElementType type;

    @JsonProperty("file_hash")
    private final String fileHash;

    @JsonProperty("message")
    private final String message;

    /**
     * Creates a new {@code PassportElementErrorFile} instance.
     *
     * @param source Error source, must be file
     * @param type The section of the user's Telegram Passport which has the issue, one of
     *     'utility_bill', 'bank_statement', 'rental_agreement', 'passport_registration',
     *     'temporary_registration'
     * @param fileHash Base64-encoded file hash
     * @param message Error message
     */
    @JsonCreator
    public PassportElementErrorFile(
            @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("file_hash") String fileHash,
            @JsonProperty("message") String message) {
        this.source = source;
        this.type = type;
        this.fileHash = fileHash;
        this.message = message;
    }

    public static PassportElementErrorFile of(PassportElementType type, String fileHash, String message) {
        return new PassportElementErrorFile(PassportElementErrorType.FILE, type, fileHash, message);
    }

    /**
     * Error source, must be file
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
     * Base64-encoded file hash
     */
    public String fileHash() {
        return fileHash;
    }

    /**
     * Error message
     */
    public String message() {
        return message;
    }

    public PassportElementErrorFile withType(PassportElementType type) {
        return new PassportElementErrorFile(source, type, fileHash, message);
    }

    public PassportElementErrorFile withFileHash(String fileHash) {
        return new PassportElementErrorFile(source, type, fileHash, message);
    }

    public PassportElementErrorFile withMessage(String message) {
        return new PassportElementErrorFile(source, type, fileHash, message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassportElementErrorFile)) {
            return false;
        }
        PassportElementErrorFile that = (PassportElementErrorFile) o;
        return Objects.equals(this.source, that.source)
                && Objects.equals(this.type, that.type)
                && Objects.equals(this.fileHash, that.fileHash)
                && Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.type, this.fileHash, this.message);
    }

    @Override
    public String toString() {
        return "PassportElementErrorFile[source=" + this.source
                + ", type=" + this.type
                + ", fileHash=" + this.fileHash
                + ", message=" + this.message
                + "]";
    }
}
