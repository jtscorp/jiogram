package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyMarkup;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * As of v.4.0, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use
 * this method to send video messages. On success, the sent Message is returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the message will be
 *     sent; required if the message is sent to a direct messages chat
 * @param videoNote Video note to send. Pass a file_id as String to send a video note that exists on
 *     the Telegram servers (recommended) or upload a new video using multipart/form-data. More
 *     information on Sending Files. Sending video notes by a URL is currently unsupported
 * @param duration Duration of sent video in seconds
 * @param length Video width and height, i.e. diameter of the video message
 * @param thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file
 *     is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in
 *     size. A thumbnail's width and height should not exceed 320. Ignored if the file is not
 *     uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a
 *     new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the thumbnail was uploaded
 *     using multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
 * @param disableNotification Sends the message silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the sent message from forwarding and saving
 * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
 *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will be
 *     withdrawn from the bot's balance
 * @param messageEffectId Unique identifier of the message effect to be added to the message; for
 *     private chats only
 * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
 *     suggested post to send; for direct messages chats only. If the message is sent as a reply to
 *     another suggested post, then that suggested post is automatically declined.
 * @param replyParameters Description of the message to reply to
 * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard,
 *     custom reply keyboard, instructions to remove a reply keyboard or to force a reply from the
 *     user
 * @see <a href="https://core.telegram.org/bots/api#sendvideonote">sendVideoNote in the Bot API</a>
 */
public record SendVideoNote(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("video_note") InputFileOrString videoNote,
    @JsonProperty("duration") @Nullable Long duration,
    @JsonProperty("length") @Nullable Long length,
    @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
    @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
    @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "sendVideoNote";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendVideoNote of(ChatId chatId, InputFileOrString videoNote) {
        return new SendVideoNote(null, chatId, null, null, videoNote, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendVideoNote answer(Message message, InputFileOrString videoNote) {
        return new SendVideoNote(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), videoNote, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendVideoNote reply(Message message, InputFileOrString videoNote) {
        return new SendVideoNote(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), videoNote, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
    }

    public SendVideoNote withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withChatId(ChatId chatId) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withVideoNote(InputFileOrString videoNote) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withDuration(@Nullable Long duration) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withLength(@Nullable Long length) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withProtectContent(@Nullable Boolean protectContent) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withMessageEffectId(@Nullable String messageEffectId) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideoNote withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendVideoNote(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, videoNote, duration, length, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }
}
