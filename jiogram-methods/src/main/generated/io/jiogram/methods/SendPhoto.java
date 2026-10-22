package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.ReplyMarkup;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send photos. On success, the sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendphoto">sendPhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendPhoto implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("photo")
    private final InputFileOrString photo;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("show_caption_above_media")
    private final @Nullable Boolean showCaptionAboveMedia;

    @JsonProperty("has_spoiler")
    private final @Nullable Boolean hasSpoiler;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("allow_paid_broadcast")
    private final @Nullable Boolean allowPaidBroadcast;

    @JsonProperty("message_effect_id")
    private final @Nullable String messageEffectId;

    @JsonProperty("suggested_post_parameters")
    private final @Nullable SuggestedPostParameters suggestedPostParameters;

    @JsonProperty("reply_parameters")
    private final @Nullable ReplyParameters replyParameters;

    @JsonProperty("reply_markup")
    private final @Nullable ReplyMarkup replyMarkup;

    /**
     * Creates a new {@code SendPhoto} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param photo Photo to send. Pass a file_id as String to send a photo that exists on the
     *     Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo
     *     from the Internet, or upload a new photo using multipart/form-data. The photo must be at
     *     most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width
     *     and height ratio must be at most 20. More information on Sending Files
     * @param caption Photo caption (may also be used when resending photos by file_id), 0-1024
     *     characters after entities parsing
     * @param parseMode Mode for parsing entities in the photo caption. See formatting options for
     *     more details.
     * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
     *     which can be specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param hasSpoiler Pass True if the photo needs to be covered with a spoiler animation
     * @param disableNotification Sends the message silently. Users will receive a notification with
     *     no sound.
     * @param protectContent Protects the contents of the sent message from forwarding and saving
     * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
     *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will
     *     be withdrawn from the bot's balance
     * @param messageEffectId Unique identifier of the message effect to be added to the message;
     *     for private chats only
     * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
     *     suggested post to send; for direct messages chats only. If the message is sent as a reply
     *     to another suggested post, then that suggested post is automatically declined.
     * @param replyParameters Description of the message to reply to
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline
     *     keyboard, custom reply keyboard, instructions to remove a reply keyboard or to force a
     *     reply from the user
     */
    @JsonCreator
    public SendPhoto(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("photo") InputFileOrString photo,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.photo = photo;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.hasSpoiler = hasSpoiler;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.suggestedPostParameters = suggestedPostParameters;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "sendPhoto";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendPhoto of(ChatId chatId, InputFileOrString photo) {
        return new SendPhoto(null, chatId, null, null, photo, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendPhoto answer(Message message, InputFileOrString photo) {
        return new SendPhoto(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), photo, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendPhoto reply(Message message, InputFileOrString photo) {
        return new SendPhoto(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), photo, null, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
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
     * Identifier of the direct messages topic to which the message will be sent; required if the
     * message is sent to a direct messages chat
     */
    public @Nullable Long directMessagesTopicId() {
        return directMessagesTopicId;
    }

    /**
     * Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers
     * (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or
     * upload a new photo using multipart/form-data. The photo must be at most 10 MB in size. The
     * photo's width and height must not exceed 10000 in total. Width and height ratio must be at
     * most 20. More information on Sending Files
     */
    public InputFileOrString photo() {
        return photo;
    }

    /**
     * Photo caption (may also be used when resending photos by file_id), 0-1024 characters after
     * entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the photo caption. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * A JSON-serialized list of special entities that appear in the caption, which can be specified
     * instead of parse_mode
     */
    public @Nullable List<MessageEntity> captionEntities() {
        return captionEntities;
    }

    /**
     * Pass True, if the caption must be shown above the message media
     */
    public @Nullable Boolean showCaptionAboveMedia() {
        return showCaptionAboveMedia;
    }

    /**
     * Pass True if the photo needs to be covered with a spoiler animation
     */
    public @Nullable Boolean hasSpoiler() {
        return hasSpoiler;
    }

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    public @Nullable Boolean disableNotification() {
        return disableNotification;
    }

    /**
     * Protects the contents of the sent message from forwarding and saving
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
     * A JSON-serialized object containing the parameters of the suggested post to send; for direct
     * messages chats only. If the message is sent as a reply to another suggested post, then that
     * suggested post is automatically declined.
     */
    public @Nullable SuggestedPostParameters suggestedPostParameters() {
        return suggestedPostParameters;
    }

    /**
     * Description of the message to reply to
     */
    public @Nullable ReplyParameters replyParameters() {
        return replyParameters;
    }

    /**
     * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply
     * keyboard, instructions to remove a reply keyboard or to force a reply from the user
     */
    public @Nullable ReplyMarkup replyMarkup() {
        return replyMarkup;
    }

    public SendPhoto withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withChatId(ChatId chatId) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withPhoto(InputFileOrString photo) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withCaption(@Nullable String caption) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withParseMode(@Nullable ParseMode parseMode) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withHasSpoiler(@Nullable Boolean hasSpoiler) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withProtectContent(@Nullable Boolean protectContent) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withMessageEffectId(@Nullable String messageEffectId) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPhoto withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendPhoto(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, photo, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendPhoto)) {
            return false;
        }
        SendPhoto that = (SendPhoto) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.photo, that.photo)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.hasSpoiler, that.hasSpoiler)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.allowPaidBroadcast, that.allowPaidBroadcast)
                && Objects.equals(this.messageEffectId, that.messageEffectId)
                && Objects.equals(this.suggestedPostParameters, that.suggestedPostParameters)
                && Objects.equals(this.replyParameters, that.replyParameters)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.photo, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.hasSpoiler, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendPhoto[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", photo=" + this.photo
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", hasSpoiler=" + this.hasSpoiler
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", allowPaidBroadcast=" + this.allowPaidBroadcast
                + ", messageEffectId=" + this.messageEffectId
                + ", suggestedPostParameters=" + this.suggestedPostParameters
                + ", replyParameters=" + this.replyParameters
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
