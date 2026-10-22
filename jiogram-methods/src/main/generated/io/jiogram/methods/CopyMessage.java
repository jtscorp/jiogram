package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.MessageId;
import io.jiogram.types.ParseMode;
import io.jiogram.types.ReplyMarkup;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to copy messages of any kind. Service messages, paid media messages, giveaway
 * messages, giveaway winners messages, and invoice messages can't be copied. A quiz poll can be
 * copied only if the value of the field correct_option_id is known to the bot. The method is
 * analogous to the method forwardMessage, but the copied message doesn't have a link to the
 * original message. Returns the MessageId of the sent message on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the message will be
 *     sent; required if the message is sent to a direct messages chat
 * @param fromChatId Unique identifier for the chat where the original message was sent (or channel
 *     username in the format &#64;channelusername)
 * @param messageId Message identifier in the chat specified in from_chat_id
 * @param videoStartTimestamp New start timestamp for the copied video in the message
 * @param caption New caption for media, 0-1024 characters after entities parsing. If not specified,
 *     the original caption is kept
 * @param parseMode Mode for parsing entities in the new caption. See formatting options for more
 *     details.
 * @param captionEntities A JSON-serialized list of special entities that appear in the new caption,
 *     which can be specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media.
 *     Ignored if a new caption isn't specified.
 * @param disableNotification Sends the message silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the sent message from forwarding and saving
 * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
 *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will be
 *     withdrawn from the bot's balance
 * @param messageEffectId Unique identifier of the message effect to be added to the message; only
 *     available when copying to private chats
 * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
 *     suggested post to send; for direct messages chats only. If the message is sent as a reply to
 *     another suggested post, then that suggested post is automatically declined.
 * @param replyParameters Description of the message to reply to
 * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard,
 *     custom reply keyboard, instructions to remove a reply keyboard or to force a reply from the
 *     user
 * @see <a href="https://core.telegram.org/bots/api#copymessage">copyMessage in the Bot API</a>
 */
public record CopyMessage(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("from_chat_id") ChatId fromChatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("video_start_timestamp") @Nullable Long videoStartTimestamp,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
    @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
    @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup
) implements TelegramMethod<MessageId> {

    @Override
    public String apiMethod() {
        return "copyMessage";
    }

    @Override
    public String apiReturnType() {
        return "MessageId";
    }

    public static CopyMessage of(ChatId chatId, ChatId fromChatId, long messageId) {
        return new CopyMessage(chatId, null, null, fromChatId, messageId, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static CopyMessage answer(Message message, ChatId fromChatId, long messageId) {
        return new CopyMessage(ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), fromChatId, messageId, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static CopyMessage reply(Message message, ChatId fromChatId, long messageId) {
        return new CopyMessage(ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), fromChatId, messageId, null, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
    }

    public CopyMessage withChatId(ChatId chatId) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withMessageThreadId(@Nullable Long messageThreadId) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withFromChatId(ChatId fromChatId) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withMessageId(long messageId) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withVideoStartTimestamp(@Nullable Long videoStartTimestamp) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withCaption(@Nullable String caption) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withParseMode(@Nullable ParseMode parseMode) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withDisableNotification(@Nullable Boolean disableNotification) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withProtectContent(@Nullable Boolean protectContent) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withMessageEffectId(@Nullable String messageEffectId) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public CopyMessage withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new CopyMessage(chatId, messageThreadId, directMessagesTopicId, fromChatId, messageId, videoStartTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }
}
