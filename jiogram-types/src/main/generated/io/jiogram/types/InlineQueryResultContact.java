package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a contact with a phone number. By default, this contact will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content
 * instead of the contact.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcontact">InlineQueryResultContact in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultContact implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("phone_number")
    private final String phoneNumber;

    @JsonProperty("first_name")
    private final String firstName;

    @JsonProperty("last_name")
    private final @Nullable String lastName;

    @JsonProperty("vcard")
    private final @Nullable String vcard;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    @JsonProperty("thumbnail_url")
    private final @Nullable String thumbnailUrl;

    @JsonProperty("thumbnail_width")
    private final @Nullable Long thumbnailWidth;

    @JsonProperty("thumbnail_height")
    private final @Nullable Long thumbnailHeight;

    /**
     * Creates a new {@code InlineQueryResultContact} instance.
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
     */
    @JsonCreator
    public InlineQueryResultContact(
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
            @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight) {
        this.type = type;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vcard = vcard;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public static InlineQueryResultContact of(String id, String phoneNumber, String firstName) {
        return new InlineQueryResultContact(InlineQueryResultType.CONTACT, id, phoneNumber, firstName, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be contact
     */
    public InlineQueryResultType type() {
        return type;
    }

    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    public String id() {
        return id;
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

    /**
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the contact
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    /**
     * Url of the thumbnail for the result
     */
    public @Nullable String thumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Thumbnail width
     */
    public @Nullable Long thumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * Thumbnail height
     */
    public @Nullable Long thumbnailHeight() {
        return thumbnailHeight;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultContact)) {
            return false;
        }
        InlineQueryResultContact that = (InlineQueryResultContact) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.phoneNumber, that.phoneNumber)
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.vcard, that.vcard)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent)
                && Objects.equals(this.thumbnailUrl, that.thumbnailUrl)
                && Objects.equals(this.thumbnailWidth, that.thumbnailWidth)
                && Objects.equals(this.thumbnailHeight, that.thumbnailHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.phoneNumber, this.firstName, this.lastName, this.vcard, this.replyMarkup, this.inputMessageContent, this.thumbnailUrl, this.thumbnailWidth, this.thumbnailHeight);
    }

    @Override
    public String toString() {
        return "InlineQueryResultContact[type=" + this.type
                + ", id=" + this.id
                + ", phoneNumber=" + this.phoneNumber
                + ", firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", vcard=" + this.vcard
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + ", thumbnailUrl=" + this.thumbnailUrl
                + ", thumbnailWidth=" + this.thumbnailWidth
                + ", thumbnailHeight=" + this.thumbnailHeight
                + "]";
    }
}
