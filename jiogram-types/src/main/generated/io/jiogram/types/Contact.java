package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a phone contact.
 *
 * @param phoneNumber Contact's phone number
 * @param firstName Contact's first name
 * @param lastName Contact's last name
 * @param userId Contact's user identifier in Telegram. This number may have more than 32
 *     significant bits and some programming languages may have difficulty/silent defects in
 *     interpreting it. But it has at most 52 significant bits, so a 64-bit integer or
 *     double-precision float type are safe for storing this identifier.
 * @param vcard Additional data about the contact in the form of a vCard
 * @see <a href="https://core.telegram.org/bots/api#contact">Contact in the Bot API</a>
 */
public record Contact(
    @JsonProperty("phone_number") String phoneNumber,
    @JsonProperty("first_name") String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("user_id") @Nullable Long userId,
    @JsonProperty("vcard") @Nullable String vcard
) {

    public static Contact of(String phoneNumber, String firstName) {
        return new Contact(phoneNumber, firstName, null, null, null);
    }

    public Contact withPhoneNumber(String phoneNumber) {
        return new Contact(phoneNumber, firstName, lastName, userId, vcard);
    }

    public Contact withFirstName(String firstName) {
        return new Contact(phoneNumber, firstName, lastName, userId, vcard);
    }

    public Contact withLastName(@Nullable String lastName) {
        return new Contact(phoneNumber, firstName, lastName, userId, vcard);
    }

    public Contact withUserId(@Nullable Long userId) {
        return new Contact(phoneNumber, firstName, lastName, userId, vcard);
    }

    public Contact withVcard(@Nullable String vcard) {
        return new Contact(phoneNumber, firstName, lastName, userId, vcard);
    }
}
