package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EncryptedCredentials(
    @JsonProperty("data") String data,
    @JsonProperty("hash") String hash,
    @JsonProperty("secret") String secret
) {}
