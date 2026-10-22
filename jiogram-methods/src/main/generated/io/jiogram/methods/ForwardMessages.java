package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageId;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to forward multiple messages of any kind. If some of the specified messages can't
 * be found or forwarded, they are skipped. Service messages and messages with protected content
 * can't be forwarded. Album grouping is kept for forwarded messages. On success, an array of
 * MessageId of the sent messages is returned.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the messages will
 *     be forwarded; required if the messages are forwarded to a direct messages chat
 * @param fromChatId Unique identifier for the chat where the original messages were sent (or
 *     channel username in the format &#64;channelusername)
 * @param messageIds A JSON-serialized list of 1-100 identifiers of messages in the chat
 *     from_chat_id to forward. The identifiers must be specified in a strictly increasing order.
 * @param disableNotification Sends the messages silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the forwarded messages from forwarding and saving
 * @see <a href="https://core.telegram.org/bots/api#forwardmessages">forwardMessages in the Bot API</a>
 */
public record ForwardMessages(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("from_chat_id") ChatId fromChatId,
    @JsonProperty("message_ids") List<Long> messageIds,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent
) implements TelegramMethod<List<MessageId>> {

    @Override
    public String apiMethod() {
        return "forwardMessages";
    }

    @Override
    public String apiReturnType() {
        return "Array of MessageId";
    }

    public static ForwardMessages of(ChatId chatId, ChatId fromChatId, List<Long> messageIds) {
        return new ForwardMessages(chatId, null, null, fromChatId, messageIds, null, null);
    }

    public ForwardMessages withChatId(ChatId chatId) {
        return new ForwardMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent);
    }

    public ForwardMessages withMessageThreadId(@Nullable Long messageThreadId) {
        return new ForwardMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent);
    }

    public ForwardMessages withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new ForwardMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent);
    }

    public ForwardMessages withFromChatId(ChatId fromChatId) {
        return new ForwardMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent);
    }

    public ForwardMessages withMessageIds(List<Long> messageIds) {
        return new ForwardMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent);
    }

    public ForwardMessages withDisableNotification(@Nullable Boolean disableNotification) {
        return new ForwardMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent);
    }

    public ForwardMessages withProtectContent(@Nullable Boolean protectContent) {
        return new ForwardMessages(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageIds, disableNotification, protectContent);
    }
}
