package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PassportElementErrorType;
import io.jiogram.types.PassportElementType;

/**
 * Represents an issue in an unspecified place. The error is considered resolved when new data is
 * added.
 *
 * @param source Error source, must be unspecified
 * @param type Type of element of the user's Telegram Passport which has the issue
 * @param elementHash Base64-encoded element hash
 * @param message Error message
 * @see <a href="https://core.telegram.org/bots/api#passportelementerrorunspecified">PassportElementErrorUnspecified in the Bot API</a>
 */
public record PassportElementErrorUnspecified(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) PassportElementErrorType source,
    @JsonProperty("type") PassportElementType type,
    @JsonProperty("element_hash") String elementHash,
    @JsonProperty("message") String message
) implements PassportElementError {}
