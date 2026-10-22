package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.EncryptedCredentials;
import io.jiogram.types.EncryptedPassportElement;
import java.util.List;
import java.util.Objects;

/**
 * Describes Telegram Passport data shared with the bot by the user.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportdata">PassportData in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PassportData {

    @JsonProperty("data")
    private final List<EncryptedPassportElement> data;

    @JsonProperty("credentials")
    private final EncryptedCredentials credentials;

    /**
     * Creates a new {@code PassportData} instance.
     *
     * @param data Array with information about documents and other Telegram Passport elements that
     *     was shared with the bot
     * @param credentials Encrypted credentials required to decrypt the data
     */
    @JsonCreator
    public PassportData(
            @JsonProperty("data") List<EncryptedPassportElement> data,
            @JsonProperty("credentials") EncryptedCredentials credentials) {
        this.data = data;
        this.credentials = credentials;
    }

    /**
     * Array with information about documents and other Telegram Passport elements that was shared
     * with the bot
     */
    public List<EncryptedPassportElement> data() {
        return data;
    }

    /**
     * Encrypted credentials required to decrypt the data
     */
    public EncryptedCredentials credentials() {
        return credentials;
    }

    public PassportData withData(List<EncryptedPassportElement> data) {
        return new PassportData(data, credentials);
    }

    public PassportData withCredentials(EncryptedCredentials credentials) {
        return new PassportData(data, credentials);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassportData)) {
            return false;
        }
        PassportData that = (PassportData) o;
        return Objects.equals(this.data, that.data)
                && Objects.equals(this.credentials, that.credentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.credentials);
    }

    @Override
    public String toString() {
        return "PassportData[data=" + this.data
                + ", credentials=" + this.credentials
                + "]";
    }
}
