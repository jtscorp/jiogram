package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyMarkup;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send phone contacts. On success, the sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendcontact">sendContact in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendContact implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("phone_number")
    private final String phoneNumber;

    @JsonProperty("first_name")
    private final String firstName;

    @JsonProperty("last_name")
    private final @Nullable String lastName;

    @JsonProperty("vcard")
    private final @Nullable String vcard;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("allow_paid_broadcast")
    private final @Nullable Boolean allowPaidBroadcast;

    @JsonProperty("message_effect_id")
    private final @Nullable String messageEffectId;

    @JsonProperty("suggested_post_parameters")
    private final @Nullable SuggestedPostParameters suggestedPostParameters;

    @JsonProperty("reply_parameters")
    private final @Nullable ReplyParameters replyParameters;

    @JsonProperty("reply_markup")
    private final @Nullable ReplyMarkup replyMarkup;

    /**
     * Creates a new {@code SendContact} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param phoneNumber Contact's phone number
     * @param firstName Contact's first name
     * @param lastName Contact's last name
     * @param vcard Additional data about the contact in the form of a vCard, 0-2048 bytes
     * @param disableNotification Sends the message silently. Users will receive a notification with
     *     no sound.
     * @param protectContent Protects the contents of the sent message from forwarding and saving
     * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
     *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will
     *     be withdrawn from the bot's balance
     * @param messageEffectId Unique identifier of the message effect to be added to the message;
     *     for private chats only
     * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
     *     suggested post to send; for direct messages chats only. If the message is sent as a reply
     *     to another suggested post, then that suggested post is automatically declined.
     * @param replyParameters Description of the message to reply to
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline
     *     keyboard, custom reply keyboard, instructions to remove a reply keyboard or to force a
     *     reply from the user
     */
    @JsonCreator
    public SendContact(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("vcard") @Nullable String vcard,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vcard = vcard;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.suggestedPostParameters = suggestedPostParameters;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "sendContact";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendContact of(ChatId chatId, String phoneNumber, String firstName) {
        return new SendContact(null, chatId, null, null, phoneNumber, firstName, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendContact answer(Message message, String phoneNumber, String firstName) {
        return new SendContact(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), phoneNumber, firstName, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendContact reply(Message message, String phoneNumber, String firstName) {
        return new SendContact(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), phoneNumber, firstName, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
    }

    /**
     * Unique identifier of the business connection on behalf of which the message will be sent
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Unique identifier for the target message thread (topic) of a forum; for forum supergroups and
     * private chats of bots with forum topic mode enabled only
     */
    public @Nullable Long messageThreadId() {
        return messageThreadId;
    }

    /**
     * Identifier of the direct messages topic to which the message will be sent; required if the
     * message is sent to a direct messages chat
     */
    public @Nullable Long directMessagesTopicId() {
        return directMessagesTopicId;
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
     * Sends the message silently. Users will receive a notification with no sound.
     */
    public @Nullable Boolean disableNotification() {
        return disableNotification;
    }

    /**
     * Protects the contents of the sent message from forwarding and saving
     */
    public @Nullable Boolean protectContent() {
        return protectContent;
    }

    /**
     * Pass True to allow up to 1000 messages per second, ignoring broadcasting limits for a fee of
     * 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     */
    public @Nullable Boolean allowPaidBroadcast() {
        return allowPaidBroadcast;
    }

    /**
     * Unique identifier of the message effect to be added to the message; for private chats only
     */
    public @Nullable String messageEffectId() {
        return messageEffectId;
    }

    /**
     * A JSON-serialized object containing the parameters of the suggested post to send; for direct
     * messages chats only. If the message is sent as a reply to another suggested post, then that
     * suggested post is automatically declined.
     */
    public @Nullable SuggestedPostParameters suggestedPostParameters() {
        return suggestedPostParameters;
    }

    /**
     * Description of the message to reply to
     */
    public @Nullable ReplyParameters replyParameters() {
        return replyParameters;
    }

    /**
     * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply
     * keyboard, instructions to remove a reply keyboard or to force a reply from the user
     */
    public @Nullable ReplyMarkup replyMarkup() {
        return replyMarkup;
    }

    public SendContact withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withChatId(ChatId chatId) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withPhoneNumber(String phoneNumber) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withFirstName(String firstName) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withLastName(@Nullable String lastName) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withVcard(@Nullable String vcard) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withProtectContent(@Nullable Boolean protectContent) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withMessageEffectId(@Nullable String messageEffectId) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendContact withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendContact(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, phoneNumber, firstName, lastName, vcard, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendContact)) {
            return false;
        }
        SendContact that = (SendContact) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.phoneNumber, that.phoneNumber)
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.vcard, that.vcard)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.allowPaidBroadcast, that.allowPaidBroadcast)
                && Objects.equals(this.messageEffectId, that.messageEffectId)
                && Objects.equals(this.suggestedPostParameters, that.suggestedPostParameters)
                && Objects.equals(this.replyParameters, that.replyParameters)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.phoneNumber, this.firstName, this.lastName, this.vcard, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendContact[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", phoneNumber=" + this.phoneNumber
                + ", firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", vcard=" + this.vcard
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", allowPaidBroadcast=" + this.allowPaidBroadcast
                + ", messageEffectId=" + this.messageEffectId
                + ", suggestedPostParameters=" + this.suggestedPostParameters
                + ", replyParameters=" + this.replyParameters
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
