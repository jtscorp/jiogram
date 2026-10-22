package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputMedia;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send a group of photos, videos, documents or audios as an album. Documents and
 * audio files can be only grouped in an album with messages of the same type. On success, an array
 * of Message objects that were sent is returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the messages will
 *     be sent; required if the messages are sent to a direct messages chat
 * @param media A JSON-serialized array describing messages to be sent, must include 2-10 items
 * @param disableNotification Sends messages silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the sent messages from forwarding and saving
 * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
 *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will be
 *     withdrawn from the bot's balance
 * @param messageEffectId Unique identifier of the message effect to be added to the message; for
 *     private chats only
 * @param replyParameters Description of the message to reply to
 * @see <a href="https://core.telegram.org/bots/api#sendmediagroup">sendMediaGroup in the Bot API</a>
 */
public record SendMediaGroup(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("media") List<InputMedia> media,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters
) implements TelegramMethod<List<Message>> {

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
}
