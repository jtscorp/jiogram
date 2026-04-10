package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.EncryptedCredentials;
import io.jiogram.types.EncryptedPassportElement;
import java.util.List;

public class PassportData {
    @JsonProperty("data") private final List<EncryptedPassportElement> data;
    @JsonProperty("credentials") private final EncryptedCredentials credentials;

    @JsonCreator
    public PassportData(
            @JsonProperty("data") List<EncryptedPassportElement> data,
            @JsonProperty("credentials") EncryptedCredentials credentials
    ) {
        this.data = data;
        this.credentials = credentials;
    }

    public List<EncryptedPassportElement> data() {
        return this.data;
    }

    public EncryptedCredentials credentials() {
        return this.credentials;
    }
}
