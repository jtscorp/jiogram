package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

/**
 * Represents an issue in one of the data fields that was provided by the user. The error is
 * considered resolved when the field's value changes.
 *
 * @param source Error source, must be data
 * @param type The section of the user's Telegram Passport which has the error, one of
 *     'personal_details', 'passport', 'driver_license', 'identity_card', 'internal_passport',
 *     'address'
 * @param fieldName Name of the data field which has the error
 * @param dataHash Base64-encoded data hash
 * @param message Error message
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrordatafield">PassportElementErrorDataField in the Bot API</a>
 */
public record PassportElementErrorDataField(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("field_name") String fieldName,
    @JsonProperty("data_hash") String dataHash,
    @JsonProperty("message") String message
) implements PassportElementError {

    public static PassportElementErrorDataField of(PassportElementType type, String fieldName, String dataHash, String message) {
        return new PassportElementErrorDataField(PassportElementErrorType.DATA, type, fieldName, dataHash, message);
    }

    public PassportElementErrorDataField withType(PassportElementType type) {
        return new PassportElementErrorDataField(source, type, fieldName, dataHash, message);
    }

    public PassportElementErrorDataField withFieldName(String fieldName) {
        return new PassportElementErrorDataField(source, type, fieldName, dataHash, message);
    }

    public PassportElementErrorDataField withDataHash(String dataHash) {
        return new PassportElementErrorDataField(source, type, fieldName, dataHash, message);
    }

    public PassportElementErrorDataField withMessage(String message) {
        return new PassportElementErrorDataField(source, type, fieldName, dataHash, message);
    }
}
