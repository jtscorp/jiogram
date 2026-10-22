package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;
import java.util.Objects;

/**
 * Represents an issue with the front side of a document. The error is considered resolved when the
 * file with the front side of the document changes.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorfrontside">PassportElementErrorFrontSide in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PassportElementErrorFrontSide implements PassportElementError {

    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private final PassportElementErrorType source;

    @JsonProperty("type")
    private final PassportElementType type;

    @JsonProperty("file_hash")
    private final String fileHash;

    @JsonProperty("message")
    private final String message;

    /**
     * Creates a new {@code PassportElementErrorFrontSide} instance.
     *
     * @param source Error source, must be front_side
     * @param type The section of the user's Telegram Passport which has the issue, one of
     *     'passport', 'driver_license', 'identity_card', 'internal_passport'
     * @param fileHash Base64-encoded hash of the file with the front side of the document
     * @param message Error message
     */
    @JsonCreator
    public PassportElementErrorFrontSide(
            @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("file_hash") String fileHash,
            @JsonProperty("message") String message) {
        this.source = source;
        this.type = type;
        this.fileHash = fileHash;
        this.message = message;
    }

    public static PassportElementErrorFrontSide of(PassportElementType type, String fileHash, String message) {
        return new PassportElementErrorFrontSide(PassportElementErrorType.FRONT_SIDE, type, fileHash, message);
    }

    /**
     * Error source, must be front_side
     */
    public PassportElementErrorType source() {
        return source;
    }

    /**
     * The section of the user's Telegram Passport which has the issue, one of 'passport',
     * 'driver_license', 'identity_card', 'internal_passport'
     */
    public PassportElementType type() {
        return type;
    }

    /**
     * Base64-encoded hash of the file with the front side of the document
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

    public PassportElementErrorFrontSide withType(PassportElementType type) {
        return new PassportElementErrorFrontSide(source, type, fileHash, message);
    }

    public PassportElementErrorFrontSide withFileHash(String fileHash) {
        return new PassportElementErrorFrontSide(source, type, fileHash, message);
    }

    public PassportElementErrorFrontSide withMessage(String message) {
        return new PassportElementErrorFrontSide(source, type, fileHash, message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassportElementErrorFrontSide)) {
            return false;
        }
        PassportElementErrorFrontSide that = (PassportElementErrorFrontSide) o;
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
        return "PassportElementErrorFrontSide[source=" + this.source
                + ", type=" + this.type
                + ", fileHash=" + this.fileHash
                + ", message=" + this.message
                + "]";
    }
}
