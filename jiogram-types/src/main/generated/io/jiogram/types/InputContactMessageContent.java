package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of a contact message to be sent as the result of an inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputcontactmessagecontent">InputContactMessageContent in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputContactMessageContent implements InputMessageContent {

    @JsonProperty("phone_number")
    private final String phoneNumber;

    @JsonProperty("first_name")
    private final String firstName;

    @JsonProperty("last_name")
    private final @Nullable String lastName;

    @JsonProperty("vcard")
    private final @Nullable String vcard;

    /**
     * Creates a new {@code InputContactMessageContent} instance.
     *
     * @param phoneNumber Contact's phone number
     * @param firstName Contact's first name
     * @param lastName Contact's last name
     * @param vcard Additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    @JsonCreator
    public InputContactMessageContent(
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("vcard") @Nullable String vcard) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vcard = vcard;
    }

    public static InputContactMessageContent of(String phoneNumber, String firstName) {
        return new InputContactMessageContent(phoneNumber, firstName, null, null);
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
     * Additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    public @Nullable String vcard() {
        return vcard;
    }

    public InputContactMessageContent withPhoneNumber(String phoneNumber) {
        return new InputContactMessageContent(phoneNumber, firstName, lastName, vcard);
    }

    public InputContactMessageContent withFirstName(String firstName) {
        return new InputContactMessageContent(phoneNumber, firstName, lastName, vcard);
    }

    public InputContactMessageContent withLastName(@Nullable String lastName) {
        return new InputContactMessageContent(phoneNumber, firstName, lastName, vcard);
    }

    public InputContactMessageContent withVcard(@Nullable String vcard) {
        return new InputContactMessageContent(phoneNumber, firstName, lastName, vcard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputContactMessageContent)) {
            return false;
        }
        InputContactMessageContent that = (InputContactMessageContent) o;
        return Objects.equals(this.phoneNumber, that.phoneNumber)
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.vcard, that.vcard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.phoneNumber, this.firstName, this.lastName, this.vcard);
    }

    @Override
    public String toString() {
        return "InputContactMessageContent[phoneNumber=" + this.phoneNumber
                + ", firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", vcard=" + this.vcard
                + "]";
    }
}
