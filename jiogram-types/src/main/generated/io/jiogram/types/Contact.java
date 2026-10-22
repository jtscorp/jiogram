package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a phone contact.
 *
 * @see <a href="https://core.telegram.org/bots/api#contact">Contact in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Contact {

    @JsonProperty("phone_number")
    private final String phoneNumber;

    @JsonProperty("first_name")
    private final String firstName;

    @JsonProperty("last_name")
    private final @Nullable String lastName;

    @JsonProperty("user_id")
    private final @Nullable Long userId;

    @JsonProperty("vcard")
    private final @Nullable String vcard;

    /**
     * Creates a new {@code Contact} instance.
     *
     * @param phoneNumber Contact's phone number
     * @param firstName Contact's first name
     * @param lastName Contact's last name
     * @param userId Contact's user identifier in Telegram. This number may have more than 32
     *     significant bits and some programming languages may have difficulty/silent defects in
     *     interpreting it. But it has at most 52 significant bits, so a 64-bit integer or
     *     double-precision float type are safe for storing this identifier.
     * @param vcard Additional data about the contact in the form of a vCard
     */
    @JsonCreator
    public Contact(
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("user_id") @Nullable Long userId,
            @JsonProperty("vcard") @Nullable String vcard) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.vcard = vcard;
    }

    public static Contact of(String phoneNumber, String firstName) {
        return new Contact(phoneNumber, firstName, null, null, null);
    }

    /**
     * Contact's phone number
     */
    public String phoneNumber() {
        return phoneNumber;
    }

    /**
     * Contact's first name
     */
    public String firstName() {
        return firstName;
    }

    /**
     * Contact's last name
     */
    public @Nullable String lastName() {
        return lastName;
    }

    /**
     * Contact's user identifier in Telegram. This number may have more than 32 significant bits and
     * some programming languages may have difficulty/silent defects in interpreting it. But it has
     * at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for
     * storing this identifier.
     */
    public @Nullable Long userId() {
        return userId;
    }

    /**
     * Additional data about the contact in the form of a vCard
     */
    public @Nullable String vcard() {
        return vcard;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }
        Contact that = (Contact) o;
        return Objects.equals(this.phoneNumber, that.phoneNumber)
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.userId, that.userId)
                && Objects.equals(this.vcard, that.vcard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.phoneNumber, this.firstName, this.lastName, this.userId, this.vcard);
    }

    @Override
    public String toString() {
        return "Contact[phoneNumber=" + this.phoneNumber
                + ", firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", userId=" + this.userId
                + ", vcard=" + this.vcard
                + "]";
    }
}
