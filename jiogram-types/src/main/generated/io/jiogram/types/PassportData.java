package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.EncryptedCredentials;
import io.jiogram.types.EncryptedPassportElement;
import java.util.List;

/**
 * Describes Telegram Passport data shared with the bot by the user.
 *
 * @param data Array with information about documents and other Telegram Passport elements that was
 *     shared with the bot
 * @param credentials Encrypted credentials required to decrypt the data
 * @see <a href="https://core.telegram.org/bots/api#passportdata">PassportData in the Bot API</a>
 */
public record PassportData(
    @JsonProperty("data") List<EncryptedPassportElement> data,
    @JsonProperty("credentials") EncryptedCredentials credentials
) {}
