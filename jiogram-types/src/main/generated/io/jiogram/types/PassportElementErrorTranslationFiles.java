package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;
import java.util.List;

/**
 * Represents an issue with the translated version of a document. The error is considered resolved
 * when a file with the document translation change.
 *
 * @param source Error source, must be translation_files
 * @param type Type of element of the user's Telegram Passport which has the issue, one of
 *     'passport', 'driver_license', 'identity_card', 'internal_passport', 'utility_bill',
 *     'bank_statement', 'rental_agreement', 'passport_registration', 'temporary_registration'
 * @param fileHashes List of base64-encoded file hashes
 * @param message Error message
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrortranslationfiles">PassportElementErrorTranslationFiles in the Bot API</a>
 */
public record PassportElementErrorTranslationFiles(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("file_hashes") List<String> fileHashes,
    @JsonProperty("message") String message
) implements PassportElementError {

    public static PassportElementErrorTranslationFiles of(PassportElementType type, List<String> fileHashes, String message) {
        return new PassportElementErrorTranslationFiles(PassportElementErrorType.TRANSLATION_FILES, type, fileHashes, message);
    }

    public PassportElementErrorTranslationFiles withType(PassportElementType type) {
        return new PassportElementErrorTranslationFiles(source, type, fileHashes, message);
    }

    public PassportElementErrorTranslationFiles withFileHashes(List<String> fileHashes) {
        return new PassportElementErrorTranslationFiles(source, type, fileHashes, message);
    }

    public PassportElementErrorTranslationFiles withMessage(String message) {
        return new PassportElementErrorTranslationFiles(source, type, fileHashes, message);
    }
}
