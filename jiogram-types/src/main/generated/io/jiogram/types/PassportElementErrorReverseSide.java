package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

/**
 * Represents an issue with the reverse side of a document. The error is considered resolved when
 * the file with reverse side of the document changes.
 *
 * @param source Error source, must be reverse_side
 * @param type The section of the user's Telegram Passport which has the issue, one of
 *     'driver_license', 'identity_card'
 * @param fileHash Base64-encoded hash of the file with the reverse side of the document
 * @param message Error message
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorreverseside">PassportElementErrorReverseSide in the Bot API</a>
 */
public record PassportElementErrorReverseSide(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("file_hash") String fileHash,
    @JsonProperty("message") String message
) implements PassportElementError {

    public static PassportElementErrorReverseSide of(PassportElementType type, String fileHash, String message) {
        return new PassportElementErrorReverseSide(PassportElementErrorType.REVERSE_SIDE, type, fileHash, message);
    }

    public PassportElementErrorReverseSide withType(PassportElementType type) {
        return new PassportElementErrorReverseSide(source, type, fileHash, message);
    }

    public PassportElementErrorReverseSide withFileHash(String fileHash) {
        return new PassportElementErrorReverseSide(source, type, fileHash, message);
    }

    public PassportElementErrorReverseSide withMessage(String message) {
        return new PassportElementErrorReverseSide(source, type, fileHash, message);
    }
}
