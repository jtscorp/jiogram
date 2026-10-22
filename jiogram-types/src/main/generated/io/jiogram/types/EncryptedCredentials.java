package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes data required for decrypting and authenticating EncryptedPassportElement. See the
 * Telegram Passport Documentation for a complete description of the data decryption and
 * authentication processes.
 *
 * @see <a href="https://core.telegram.org/bots/api#encryptedcredentials">EncryptedCredentials in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EncryptedCredentials {

    @JsonProperty("data")
    private final String data;

    @JsonProperty("hash")
    private final String hash;

    @JsonProperty("secret")
    private final String secret;

    /**
     * Creates a new {@code EncryptedCredentials} instance.
     *
     * @param data Base64-encoded encrypted JSON-serialized data with unique user's payload, data
     *     hashes and secrets required for EncryptedPassportElement decryption and authentication
     * @param hash Base64-encoded data hash for data authentication
     * @param secret Base64-encoded secret, encrypted with the bot's public RSA key, required for
     *     data decryption
     */
    @JsonCreator
    public EncryptedCredentials(
            @JsonProperty("data") String data,
            @JsonProperty("hash") String hash,
            @JsonProperty("secret") String secret) {
        this.data = data;
        this.hash = hash;
        this.secret = secret;
    }

    /**
     * Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and
     * secrets required for EncryptedPassportElement decryption and authentication
     */
    public String data() {
        return data;
    }

    /**
     * Base64-encoded data hash for data authentication
     */
    public String hash() {
        return hash;
    }

    /**
     * Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
     */
    public String secret() {
        return secret;
    }

    public EncryptedCredentials withData(String data) {
        return new EncryptedCredentials(data, hash, secret);
    }

    public EncryptedCredentials withHash(String hash) {
        return new EncryptedCredentials(data, hash, secret);
    }

    public EncryptedCredentials withSecret(String secret) {
        return new EncryptedCredentials(data, hash, secret);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EncryptedCredentials)) {
            return false;
        }
        EncryptedCredentials that = (EncryptedCredentials) o;
        return Objects.equals(this.data, that.data)
                && Objects.equals(this.hash, that.hash)
                && Objects.equals(this.secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.hash, this.secret);
    }

    @Override
    public String toString() {
        return "EncryptedCredentials[data=" + this.data
                + ", hash=" + this.hash
                + ", secret=" + this.secret
                + "]";
    }
}
