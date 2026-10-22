package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to forward messages of any kind. Service messages and messages with protected
 * content can't be forwarded. On success, the sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#forwardmessage">forwardMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ForwardMessage implements TelegramMethod<Message> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("from_chat_id")
    private final ChatId fromChatId;

    @JsonProperty("video_start_timestamp")
    private final @Nullable Long videoStartTimestamp;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("message_effect_id")
    private final @Nullable String messageEffectId;

    @JsonProperty("suggested_post_parameters")
    private final @Nullable SuggestedPostParameters suggestedPostParameters;

    @JsonProperty("message_id")
    private final long messageId;

    /**
     * Creates a new {@code ForwardMessage} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be forwarded; required if the message is forwarded to a direct messages chat
     * @param fromChatId Unique identifier for the chat where the original message was sent (or
     *     channel username in the format &#64;channelusername)
     * @param videoStartTimestamp New start timestamp for the forwarded video in the message
     * @param disableNotification Sends the message silently. Users will receive a notification with
     *     no sound.
     * @param protectContent Protects the contents of the forwarded message from forwarding and
     *     saving
     * @param messageEffectId Unique identifier of the message effect to be added to the message;
     *     only available when forwarding to private chats
     * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
     *     suggested post to send; for direct messages chats only
     * @param messageId Message identifier in the chat specified in from_chat_id
     */
    @JsonCreator
    public ForwardMessage(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("from_chat_id") ChatId fromChatId,
            @JsonProperty("video_start_timestamp") @Nullable Long videoStartTimestamp,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
            @JsonProperty("message_id") long messageId) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.fromChatId = fromChatId;
        this.videoStartTimestamp = videoStartTimestamp;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.messageEffectId = messageEffectId;
        this.suggestedPostParameters = suggestedPostParameters;
        this.messageId = messageId;
    }

    @Override
    public String apiMethod() {
        return "forwardMessage";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static ForwardMessage of(ChatId chatId, ChatId fromChatId, long messageId) {
        return new ForwardMessage(chatId, null, null, fromChatId, null, null, null, null, null, messageId);
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
     * Identifier of the direct messages topic to which the message will be forwarded; required if
     * the message is forwarded to a direct messages chat
     */
    public @Nullable Long directMessagesTopicId() {
        return directMessagesTopicId;
    }

    /**
     * Unique identifier for the chat where the original message was sent (or channel username in
     * the format &#64;channelusername)
     */
    public ChatId fromChatId() {
        return fromChatId;
    }

    /**
     * New start timestamp for the forwarded video in the message
     */
    public @Nullable Long videoStartTimestamp() {
        return videoStartTimestamp;
    }

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    public @Nullable Boolean disableNotification() {
        return disableNotification;
    }

    /**
     * Protects the contents of the forwarded message from forwarding and saving
     */
    public @Nullable Boolean protectContent() {
        return protectContent;
    }

    /**
     * Unique identifier of the message effect to be added to the message; only available when
     * forwarding to private chats
     */
    public @Nullable String messageEffectId() {
        return messageEffectId;
    }

    /**
     * A JSON-serialized object containing the parameters of the suggested post to send; for direct
     * messages chats only
     */
    public @Nullable SuggestedPostParameters suggestedPostParameters() {
        return suggestedPostParameters;
    }

    /**
     * Message identifier in the chat specified in from_chat_id
     */
    public long messageId() {
        return messageId;
    }

    public ForwardMessage withChatId(ChatId chatId) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withMessageThreadId(@Nullable Long messageThreadId) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withFromChatId(ChatId fromChatId) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withVideoStartTimestamp(@Nullable Long videoStartTimestamp) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withDisableNotification(@Nullable Boolean disableNotification) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withProtectContent(@Nullable Boolean protectContent) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withMessageEffectId(@Nullable String messageEffectId) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    public ForwardMessage withMessageId(long messageId) {
        return new ForwardMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, videoStartTimestamp, disableNotification, protectContent, messageEffectId, suggestedPostParameters, messageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ForwardMessage)) {
            return false;
        }
        ForwardMessage that = (ForwardMessage) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.fromChatId, that.fromChatId)
                && Objects.equals(this.videoStartTimestamp, that.videoStartTimestamp)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.messageEffectId, that.messageEffectId)
                && Objects.equals(this.suggestedPostParameters, that.suggestedPostParameters)
                && this.messageId == that.messageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageThreadId, this.directMessagesTopicId, this.fromChatId, this.videoStartTimestamp, this.disableNotification, this.protectContent, this.messageEffectId, this.suggestedPostParameters, this.messageId);
    }

    @Override
    public String toString() {
        return "ForwardMessage[chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", fromChatId=" + this.fromChatId
                + ", videoStartTimestamp=" + this.videoStartTimestamp
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", messageEffectId=" + this.messageEffectId
                + ", suggestedPostParameters=" + this.suggestedPostParameters
                + ", messageId=" + this.messageId
                + "]";
    }
}
