package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.EncryptedCredentials;
import io.jiogram.types.EncryptedPassportElement;
import java.util.List;

public record PassportData(
    @JsonProperty("data") List<EncryptedPassportElement> data,
    @JsonProperty("credentials") EncryptedCredentials credentials
) {}
