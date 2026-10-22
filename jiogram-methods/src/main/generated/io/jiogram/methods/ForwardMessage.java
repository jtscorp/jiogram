package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to forward messages of any kind. Service messages and messages with protected
 * content can't be forwarded. On success, the sent Message is returned.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the message will be
 *     forwarded; required if the message is forwarded to a direct messages chat
 * @param fromChatId Unique identifier for the chat where the original message was sent (or channel
 *     username in the format &#64;channelusername)
 * @param videoStartTimestamp New start timestamp for the forwarded video in the message
 * @param disableNotification Sends the message silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the forwarded message from forwarding and saving
 * @param messageEffectId Unique identifier of the message effect to be added to the message; only
 *     available when forwarding to private chats
 * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
 *     suggested post to send; for direct messages chats only
 * @param messageId Message identifier in the chat specified in from_chat_id
 * @see <a href="https://core.telegram.org/bots/api#forwardmessage">forwardMessage in the Bot API</a>
 */
public record ForwardMessage(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("from_chat_id") ChatId fromChatId,
    @JsonProperty("video_start_timestamp") @Nullable Long videoStartTimestamp,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
    @JsonProperty("message_id") long messageId
) implements TelegramMethod<Message> {

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
}
