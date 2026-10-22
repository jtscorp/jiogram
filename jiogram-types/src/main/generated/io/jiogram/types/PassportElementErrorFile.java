package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

/**
 * Represents an issue with a document scan. The error is considered resolved when the file with the
 * document scan changes.
 *
 * @param source Error source, must be file
 * @param type The section of the user's Telegram Passport which has the issue, one of
 *     'utility_bill', 'bank_statement', 'rental_agreement', 'passport_registration',
 *     'temporary_registration'
 * @param fileHash Base64-encoded file hash
 * @param message Error message
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorfile">PassportElementErrorFile in the Bot API</a>
 */
public record PassportElementErrorFile(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("file_hash") String fileHash,
    @JsonProperty("message") String message
) implements PassportElementError {

    public PassportElementErrorFile withType(PassportElementType type) {
        return new PassportElementErrorFile(source, type, fileHash, message);
    }

    public PassportElementErrorFile withFileHash(String fileHash) {
        return new PassportElementErrorFile(source, type, fileHash, message);
    }

    public PassportElementErrorFile withMessage(String message) {
        return new PassportElementErrorFile(source, type, fileHash, message);
    }
}
