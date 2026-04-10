package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EncryptedCredentials {
    @JsonProperty("data") private final String data;
    @JsonProperty("hash") private final String hash;
    @JsonProperty("secret") private final String secret;

    @JsonCreator
    public EncryptedCredentials(
            @JsonProperty("data") String data,
            @JsonProperty("hash") String hash,
            @JsonProperty("secret") String secret
    ) {
        this.data = data;
        this.hash = hash;
        this.secret = secret;
    }

    public String data() {
        return this.data;
    }

    public String hash() {
        return this.hash;
    }

    public String secret() {
        return this.secret;
    }
}
