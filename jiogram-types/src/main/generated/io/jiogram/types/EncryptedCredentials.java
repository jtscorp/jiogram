package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes data required for decrypting and authenticating EncryptedPassportElement. See the
 * Telegram Passport Documentation for a complete description of the data decryption and
 * authentication processes.
 *
 * @param data Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes
 *     and secrets required for EncryptedPassportElement decryption and authentication
 * @param hash Base64-encoded data hash for data authentication
 * @param secret Base64-encoded secret, encrypted with the bot's public RSA key, required for data
 *     decryption
 * @see <a href="https://core.telegram.org/bots/api#encryptedcredentials">EncryptedCredentials in the Bot API</a>
 */
public record EncryptedCredentials(
    @JsonProperty("data") String data,
    @JsonProperty("hash") String hash,
    @JsonProperty("secret") String secret
) {

    public EncryptedCredentials withData(String data) {
        return new EncryptedCredentials(data, hash, secret);
    }

    public EncryptedCredentials withHash(String hash) {
        return new EncryptedCredentials(data, hash, secret);
    }

    public EncryptedCredentials withSecret(String secret) {
        return new EncryptedCredentials(data, hash, secret);
    }
}
