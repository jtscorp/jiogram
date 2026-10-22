package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

/**
 * Represents an issue with one of the files that constitute the translation of a document. The
 * error is considered resolved when the file changes.
 *
 * @param source Error source, must be translation_file
 * @param type Type of element of the user's Telegram Passport which has the issue, one of
 *     'passport', 'driver_license', 'identity_card', 'internal_passport', 'utility_bill',
 *     'bank_statement', 'rental_agreement', 'passport_registration', 'temporary_registration'
 * @param fileHash Base64-encoded file hash
 * @param message Error message
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfile">PassportElementErrorTranslationFile in the Bot API</a>
 */
public record PassportElementErrorTranslationFile(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("file_hash") String fileHash,
    @JsonProperty("message") String message
) implements PassportElementError {

    public PassportElementErrorTranslationFile withType(PassportElementType type) {
        return new PassportElementErrorTranslationFile(source, type, fileHash, message);
    }

    public PassportElementErrorTranslationFile withFileHash(String fileHash) {
        return new PassportElementErrorTranslationFile(source, type, fileHash, message);
    }

    public PassportElementErrorTranslationFile withMessage(String message) {
        return new PassportElementErrorTranslationFile(source, type, fileHash, message);
    }
}
