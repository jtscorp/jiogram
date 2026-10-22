package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of a contact message to be sent as the result of an inline query.
 *
 * @param phoneNumber Contact's phone number
 * @param firstName Contact's first name
 * @param lastName Contact's last name
 * @param vcard Additional data about the contact in the form of a vCard, 0-2048 bytes
 * @see <a href="https://core.telegram.org/bots/api#inputcontactmessagecontent">InputContactMessageContent in the Bot API</a>
 */
public record InputContactMessageContent(
    @JsonProperty("phone_number") String phoneNumber,
    @JsonProperty("first_name") String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("vcard") @Nullable String vcard
) implements InputMessageContent {}
