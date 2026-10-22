package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageId;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to copy messages of any kind. If some of the specified messages can't be found or
 * copied, they are skipped. Service messages, paid media messages, giveaway messages, giveaway
 * winners messages, and invoice messages can't be copied. A quiz poll can be copied only if the
 * value of the field correct_option_id is known to the bot. The method is analogous to the method
 * forwardMessages, but the copied messages don't have a link to the original message. Album
 * grouping is kept for copied messages. On success, an array of MessageId of the sent messages is
 * returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#copymessages">copyMessages in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class CopyMessages implements TelegramMethod<List<MessageId>> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("from_chat_id")
    private final ChatId fromChatId;

    @JsonProperty("message_ids")
    private final List<Long> messageIds;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("remove_caption")
    private final @Nullable Boolean removeCaption;

    /**
     * Creates a new {@code CopyMessages} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the messages
     *     will be sent; required if the messages are sent to a direct messages chat
     * @param fromChatId Unique identifier for the chat where the original messages were sent (or
     *     channel username in the format &#64;channelusername)
     * @param messageIds A JSON-serialized list of 1-100 identifiers of messages in the chat
     *     from_chat_id to copy. The identifiers must be specified in a strictly increasing order.
     * @param disableNotification Sends the messages silently. Users will receive a notification
     *     with no sound.
     * @param protectContent Protects the contents of the sent messages from forwarding and saving
     * @param removeCaption Pass True to copy the messages without their captions
     */
    @JsonCreator
    public CopyMessages(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("from_chat_id") ChatId fromChatId,
            @JsonProperty("message_ids") List<Long> messageIds,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("remove_caption") @Nullable Boolean removeCaption) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.fromChatId = fromChatId;
        this.messageIds = messageIds;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.removeCaption = removeCaption;
    }

    @Override
    public String apiMethod() {
        return "copyMessages";
    }

    @Override
    public String apiReturnType() {
        return "Array of MessageId";
    }

    public static CopyMessages of(ChatId chatId, ChatId fromChatId, List<Long> messageIds) {
        return new CopyMessages(chatId, null, null, fromChatId, messageIds, null, null, null);
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
     * Unique identifier for the chat where the original messages were sent (or channel username in
     * the format &#64;channelusername)
     */
    public ChatId fromChatId() {
        return fromChatId;
    }

    /**
     * A JSON-serialized list of 1-100 identifiers of messages in the chat from_chat_id to copy. The
     * identifiers must be specified in a strictly increasing order.
     */
    public List<Long> messageIds() {
        return messageIds;
    }

    /**
     * Sends the messages silently. Users will receive a notification with no sound.
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
     * Pass True to copy the messages without their captions
     */
    public @Nullable Boolean removeCaption() {
        return removeCaption;
    }

    public CopyMessages withChatId(ChatId chatId) {
        return new CopyMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent, removeCaption);
    }

    public CopyMessages withMessageThreadId(@Nullable Long messageThreadId) {
        return new CopyMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent, removeCaption);
    }

    public CopyMessages withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new CopyMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent, removeCaption);
    }

    public CopyMessages withFromChatId(ChatId fromChatId) {
        return new CopyMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent, removeCaption);
    }

    public CopyMessages withMessageIds(List<Long> messageIds) {
        return new CopyMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent, removeCaption);
    }

    public CopyMessages withDisableNotification(@Nullable Boolean disableNotification) {
        return new CopyMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent, removeCaption);
    }

    public CopyMessages withProtectContent(@Nullable Boolean protectContent) {
        return new CopyMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent, removeCaption);
    }

    public CopyMessages withRemoveCaption(@Nullable Boolean removeCaption) {
        return new CopyMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent, removeCaption);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CopyMessages)) {
            return false;
        }
        CopyMessages that = (CopyMessages) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.fromChatId, that.fromChatId)
                && Objects.equals(this.messageIds, that.messageIds)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.removeCaption, that.removeCaption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageThreadId, this.directMessagesTopicId, this.fromChatId, this.messageIds, this.disableNotification, this.protectContent, this.removeCaption);
    }

    @Override
    public String toString() {
        return "CopyMessages[chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", fromChatId=" + this.fromChatId
                + ", messageIds=" + this.messageIds
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", removeCaption=" + this.removeCaption
                + "]";
    }
}
