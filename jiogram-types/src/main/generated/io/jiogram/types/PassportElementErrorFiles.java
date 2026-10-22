package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;
import java.util.List;

/**
 * Represents an issue with a list of scans. The error is considered resolved when the list of files
 * containing the scans changes.
 *
 * @param source Error source, must be files
 * @param type The section of the user's Telegram Passport which has the issue, one of
 *     'utility_bill', 'bank_statement', 'rental_agreement', 'passport_registration',
 *     'temporary_registration'
 * @param fileHashes List of base64-encoded file hashes
 * @param message Error message
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorfiles">PassportElementErrorFiles in the Bot API</a>
 */
public record PassportElementErrorFiles(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("file_hashes") List<String> fileHashes,
    @JsonProperty("message") String message
) implements PassportElementError {}
