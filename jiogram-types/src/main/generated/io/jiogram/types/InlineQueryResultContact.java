package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

/**
 * Represents a contact with a phone number. By default, this contact will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content
 * instead of the contact.
 *
 * @param type Type of the result, must be contact
 * @param id Unique identifier for this result, 1-64 Bytes
 * @param phoneNumber Contact's phone number
 * @param firstName Contact's first name
 * @param lastName Contact's last name
 * @param vcard Additional data about the contact in the form of a vCard, 0-2048 bytes
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the contact
 * @param thumbnailUrl Url of the thumbnail for the result
 * @param thumbnailWidth Thumbnail width
 * @param thumbnailHeight Thumbnail height
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcontact">InlineQueryResultContact in the Bot API</a>
 */
public record InlineQueryResultContact(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("phone_number") String phoneNumber,
    @JsonProperty("first_name") String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("vcard") @Nullable String vcard,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent,
    @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl,
    @JsonProperty("thumbnail_width") @Nullable Long thumbnailWidth,
    @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight
) implements InlineQueryResult {

    public InlineQueryResultContact withId(String id) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withPhoneNumber(String phoneNumber) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withFirstName(String firstName) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withLastName(@Nullable String lastName) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withVcard(@Nullable String vcard) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withThumbnailUrl(@Nullable String thumbnailUrl) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withThumbnailWidth(@Nullable Long thumbnailWidth) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultContact withThumbnailHeight(@Nullable Long thumbnailHeight) {
        return new InlineQueryResultContact(type, id, phoneNumber, firstName, lastName, vcard, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }
}
