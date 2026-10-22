package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputMedia;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send a group of photos, videos, documents or audios as an album. Documents and
 * audio files can be only grouped in an album with messages of the same type. On success, an array
 * of Message objects that were sent is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendmediagroup">sendMediaGroup in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendMediaGroup implements TelegramMethod<List<Message>> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("media")
    private final List<InputMedia> media;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("allow_paid_broadcast")
    private final @Nullable Boolean allowPaidBroadcast;

    @JsonProperty("message_effect_id")
    private final @Nullable String messageEffectId;

    @JsonProperty("reply_parameters")
    private final @Nullable ReplyParameters replyParameters;

    /**
     * Creates a new {@code SendMediaGroup} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the messages
     *     will be sent; required if the messages are sent to a direct messages chat
     * @param media A JSON-serialized array describing messages to be sent, must include 2-10 items
     * @param disableNotification Sends messages silently. Users will receive a notification with no
     *     sound.
     * @param protectContent Protects the contents of the sent messages from forwarding and saving
     * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
     *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will
     *     be withdrawn from the bot's balance
     * @param messageEffectId Unique identifier of the message effect to be added to the message;
     *     for private chats only
     * @param replyParameters Description of the message to reply to
     */
    @JsonCreator
    public SendMediaGroup(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("media") List<InputMedia> media,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.media = media;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.replyParameters = replyParameters;
    }

    @Override
    public String apiMethod() {
        return "sendMediaGroup";
    }

    @Override
    public String apiReturnType() {
        return "Array of Message";
    }

    public static SendMediaGroup of(ChatId chatId, List<InputMedia> media) {
        return new SendMediaGroup(null, chatId, null, null, media, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendMediaGroup answer(Message message, List<InputMedia> media) {
        return new SendMediaGroup(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), media, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendMediaGroup reply(Message message, List<InputMedia> media) {
        return new SendMediaGroup(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), media, null, null, null, null, ReplyTarget.replyTo(message));
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
     * Identifier of the direct messages topic to which the messages will be sent; required if the
     * messages are sent to a direct messages chat
     */
    public @Nullable Long directMessagesTopicId() {
        return directMessagesTopicId;
    }

    /**
     * A JSON-serialized array describing messages to be sent, must include 2-10 items
     */
    public List<InputMedia> media() {
        return media;
    }

    /**
     * Sends messages silently. Users will receive a notification with no sound.
     */
    public @Nullable Boolean disableNotification() {
        return disableNotification;
    }

    /**
     * Protects the contents of the sent messages from forwarding and saving
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
     * Description of the message to reply to
     */
    public @Nullable ReplyParameters replyParameters() {
        return replyParameters;
    }

    public SendMediaGroup withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withChatId(ChatId chatId) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withMedia(List<InputMedia> media) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withProtectContent(@Nullable Boolean protectContent) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withMessageEffectId(@Nullable String messageEffectId) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    public SendMediaGroup withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendMediaGroup(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, media, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, replyParameters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendMediaGroup)) {
            return false;
        }
        SendMediaGroup that = (SendMediaGroup) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.media, that.media)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.allowPaidBroadcast, that.allowPaidBroadcast)
                && Objects.equals(this.messageEffectId, that.messageEffectId)
                && Objects.equals(this.replyParameters, that.replyParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.media, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.replyParameters);
    }

    @Override
    public String toString() {
        return "SendMediaGroup[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", media=" + this.media
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", allowPaidBroadcast=" + this.allowPaidBroadcast
                + ", messageEffectId=" + this.messageEffectId
                + ", replyParameters=" + this.replyParameters
                + "]";
    }
}
