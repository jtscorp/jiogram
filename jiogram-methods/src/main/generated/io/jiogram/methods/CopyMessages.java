package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageId;
import io.jiogram.types.TelegramMethod;
import java.util.List;
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
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the messages will
 *     be sent; required if the messages are sent to a direct messages chat
 * @param fromChatId Unique identifier for the chat where the original messages were sent (or
 *     channel username in the format &#64;channelusername)
 * @param messageIds A JSON-serialized list of 1-100 identifiers of messages in the chat
 *     from_chat_id to copy. The identifiers must be specified in a strictly increasing order.
 * @param disableNotification Sends the messages silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the sent messages from forwarding and saving
 * @param removeCaption Pass True to copy the messages without their captions
 * @see <a href="https://core.telegram.org/bots/api#copymessages">copyMessages in the Bot API</a>
 */
public record CopyMessages(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("from_chat_id") ChatId fromChatId,
    @JsonProperty("message_ids") List<Long> messageIds,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("remove_caption") @Nullable Boolean removeCaption
) implements TelegramMethod<List<MessageId>> {

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
}
