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
 * Use this method to send static .WEBP, animated .TGS, or video .WEBM stickers. On success, the
 * sent Message is returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the message will be
 *     sent; required if the message is sent to a direct messages chat
 * @param sticker Sticker to send. Pass a file_id as String to send a file that exists on the
 *     Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP
 *     sticker from the Internet, or upload a new .WEBP, .TGS, or .WEBM sticker using
 *     multipart/form-data. More information on Sending Files. Video and animated stickers can't be
 *     sent via an HTTP URL.
 * @param emoji Emoji associated with the sticker; only for just uploaded stickers
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
 * @see <a href="https://core.telegram.org/bots/api#sendsticker">sendSticker in the Bot API</a>
 */
public record SendSticker(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("sticker") InputFileOrString sticker,
    @JsonProperty("emoji") @Nullable String emoji,
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
        return "sendSticker";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendSticker of(ChatId chatId, InputFileOrString sticker) {
        return new SendSticker(null, chatId, null, null, sticker, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendSticker answer(Message message, InputFileOrString sticker) {
        return new SendSticker(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), sticker, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendSticker reply(Message message, InputFileOrString sticker) {
        return new SendSticker(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), sticker, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
    }

    public SendSticker withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withChatId(ChatId chatId) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withSticker(InputFileOrString sticker) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withEmoji(@Nullable String emoji) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withProtectContent(@Nullable Boolean protectContent) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withMessageEffectId(@Nullable String messageEffectId) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendSticker withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendSticker(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, sticker, emoji, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }
}
