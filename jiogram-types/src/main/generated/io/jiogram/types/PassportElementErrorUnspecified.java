package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;
import java.util.Objects;

/**
 * Represents an issue in an unspecified place. The error is considered resolved when new data is
 * added.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorunspecified">PassportElementErrorUnspecified in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PassportElementErrorUnspecified implements PassportElementError {

    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY)
    private final PassportElementErrorType source;

    @JsonProperty("type")
    private final PassportElementType type;

    @JsonProperty("element_hash")
    private final String elementHash;

    @JsonProperty("message")
    private final String message;

    /**
     * Creates a new {@code PassportElementErrorUnspecified} instance.
     *
     * @param source Error source, must be unspecified
     * @param type Type of element of the user's Telegram Passport which has the issue
     * @param elementHash Base64-encoded element hash
     * @param message Error message
     */
    @JsonCreator
    public PassportElementErrorUnspecified(
            @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
            @JsonProperty("type") PassportElementType type,
            @JsonProperty("element_hash") String elementHash,
            @JsonProperty("message") String message) {
        this.source = source;
        this.type = type;
        this.elementHash = elementHash;
        this.message = message;
    }

    public static PassportElementErrorUnspecified of(PassportElementType type, String elementHash, String message) {
        return new PassportElementErrorUnspecified(PassportElementErrorType.UNSPECIFIED, type, elementHash, message);
    }

    /**
     * Error source, must be unspecified
     */
    public PassportElementErrorType source() {
        return source;
    }

    /**
     * Type of element of the user's Telegram Passport which has the issue
     */
    public PassportElementType type() {
        return type;
    }

    /**
     * Base64-encoded element hash
     */
    public String elementHash() {
        return elementHash;
    }

    /**
     * Error message
     */
    public String message() {
        return message;
    }

    public PassportElementErrorUnspecified withType(PassportElementType type) {
        return new PassportElementErrorUnspecified(source, type, elementHash, message);
    }

    public PassportElementErrorUnspecified withElementHash(String elementHash) {
        return new PassportElementErrorUnspecified(source, type, elementHash, message);
    }

    public PassportElementErrorUnspecified withMessage(String message) {
        return new PassportElementErrorUnspecified(source, type, elementHash, message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassportElementErrorUnspecified)) {
            return false;
        }
        PassportElementErrorUnspecified that = (PassportElementErrorUnspecified) o;
        return Objects.equals(this.source, that.source)
                && Objects.equals(this.type, that.type)
                && Objects.equals(this.elementHash, that.elementHash)
                && Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.type, this.elementHash, this.message);
    }

    @Override
    public String toString() {
        return "PassportElementErrorUnspecified[source=" + this.source
                + ", type=" + this.type
                + ", elementHash=" + this.elementHash
                + ", message=" + this.message
                + "]";
    }
}
