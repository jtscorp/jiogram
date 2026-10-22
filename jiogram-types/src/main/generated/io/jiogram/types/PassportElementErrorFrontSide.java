package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

/**
 * Represents an issue with the front side of a document. The error is considered resolved when the
 * file with the front side of the document changes.
 *
 * @param source Error source, must be front_side
 * @param type The section of the user's Telegram Passport which has the issue, one of 'passport',
 *     'driver_license', 'identity_card', 'internal_passport'
 * @param fileHash Base64-encoded hash of the file with the front side of the document
 * @param message Error message
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorfrontside">PassportElementErrorFrontSide in the Bot API</a>
 */
public record PassportElementErrorFrontSide(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("file_hash") String fileHash,
    @JsonProperty("message") String message
) implements PassportElementError {

    public static PassportElementErrorFrontSide of(PassportElementType type, String fileHash, String message) {
        return new PassportElementErrorFrontSide(PassportElementErrorType.FRONT_SIDE, type, fileHash, message);
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
}
