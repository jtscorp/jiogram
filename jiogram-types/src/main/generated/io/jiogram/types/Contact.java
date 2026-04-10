package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class Contact {
    @JsonProperty("phone_number") private final String phoneNumber;
    @JsonProperty("first_name") private final String firstName;
    @JsonProperty("last_name") @Nullable private final String lastName;
    @JsonProperty("user_id") @Nullable private final Long userId;
    @JsonProperty("vcard") @Nullable private final String vcard;

    @JsonCreator
    public Contact(
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("user_id") @Nullable Long userId,
            @JsonProperty("vcard") @Nullable String vcard
    ) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.vcard = vcard;
    }

    public String phoneNumber() {
        return this.phoneNumber;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public Long userId() {
        return this.userId;
    }

    public String vcard() {
        return this.vcard;
    }
}
