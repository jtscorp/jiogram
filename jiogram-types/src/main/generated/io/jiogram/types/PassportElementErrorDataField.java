package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;
import java.util.Objects;

/**
 * Represents an issue in one of the data fields that was provided by the user. The error is
 * considered resolved when the field's value changes.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrordatafield">PassportElementErrorDataField in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PassportElementErrorDataField implements PassportElementError {

    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private final PassportElementErrorType source;

    @JsonProperty("type")
    private final PassportElementType type;

    @JsonProperty("field_name")
    private final String fieldName;

    @JsonProperty("data_hash")
    private final String dataHash;

    @JsonProperty("message")
    private final String message;

    /**
     * Creates a new {@code PassportElementErrorDataField} instance.
     *
     * @param source Error source, must be data
     * @param type The section of the user's Telegram Passport which has the error, one of
     *     'personal_details', 'passport', 'driver_license', 'identity_card', 'internal_passport',
     *     'address'
     * @param fieldName Name of the data field which has the error
     * @param dataHash Base64-encoded data hash
     * @param message Error message
     */
    @JsonCreator
    public PassportElementErrorDataField(
            @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("field_name") String fieldName,
            @JsonProperty("data_hash") String dataHash,
            @JsonProperty("message") String message) {
        this.source = source;
        this.type = type;
        this.fieldName = fieldName;
        this.dataHash = dataHash;
        this.message = message;
    }

    public static PassportElementErrorDataField of(PassportElementType type, String fieldName, String dataHash, String message) {
        return new PassportElementErrorDataField(PassportElementErrorType.DATA, type, fieldName, dataHash, message);
    }

    /**
     * Error source, must be data
     */
    public PassportElementErrorType source() {
        return source;
    }

    /**
     * The section of the user's Telegram Passport which has the error, one of 'personal_details',
     * 'passport', 'driver_license', 'identity_card', 'internal_passport', 'address'
     */
    public PassportElementType type() {
        return type;
    }

    /**
     * Name of the data field which has the error
     */
    public String fieldName() {
        return fieldName;
    }

    /**
     * Base64-encoded data hash
     */
    public String dataHash() {
        return dataHash;
    }

    /**
     * Error message
     */
    public String message() {
        return message;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassportElementErrorDataField)) {
            return false;
        }
        PassportElementErrorDataField that = (PassportElementErrorDataField) o;
        return Objects.equals(this.source, that.source)
                && Objects.equals(this.type, that.type)
                && Objects.equals(this.fieldName, that.fieldName)
                && Objects.equals(this.dataHash, that.dataHash)
                && Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.type, this.fieldName, this.dataHash, this.message);
    }

    @Override
    public String toString() {
        return "PassportElementErrorDataField[source=" + this.source
                + ", type=" + this.type
                + ", fieldName=" + this.fieldName
                + ", dataHash=" + this.dataHash
                + ", message=" + this.message
                + "]";
    }
}
