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
 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On
 * success, the sent Message is returned. Bots can currently send animation files of up to 50 MB in
 * size, this limit may be changed in the future.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendanimation">sendAnimation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendAnimation implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("animation")
    private final InputFileOrString animation;

    @JsonProperty("duration")
    private final @Nullable Long duration;

    @JsonProperty("width")
    private final @Nullable Long width;

    @JsonProperty("height")
    private final @Nullable Long height;

    @JsonProperty("thumbnail")
    private final @Nullable InputFileOrString thumbnail;

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
     * Creates a new {@code SendAnimation} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param animation Animation to send. Pass a file_id as String to send an animation that exists
     *     on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get
     *     an animation from the Internet, or upload a new animation using multipart/form-data. More
     *     information on Sending Files
     * @param duration Duration of sent animation in seconds
     * @param width Animation width
     * @param height Animation height
     * @param thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the
     *     file is supported server-side. The thumbnail should be in JPEG format and less than 200
     *     kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is
     *     not uploaded using multipart/form-data. Thumbnails can't be reused and can be only
     *     uploaded as a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the
     *     thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. More
     *     information on Sending Files
     * @param caption Animation caption (may also be used when resending animation by file_id),
     *     0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the animation caption. See formatting options
     *     for more details.
     * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
     *     which can be specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param hasSpoiler Pass True if the animation needs to be covered with a spoiler animation
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
    public SendAnimation(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("animation") InputFileOrString animation,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
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
        this.animation = animation;
        this.duration = duration;
        this.width = width;
        this.height = height;
        this.thumbnail = thumbnail;
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
        return "sendAnimation";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendAnimation of(ChatId chatId, InputFileOrString animation) {
        return new SendAnimation(null, chatId, null, null, animation, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendAnimation answer(Message message, InputFileOrString animation) {
        return new SendAnimation(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), animation, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendAnimation reply(Message message, InputFileOrString animation) {
        return new SendAnimation(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), animation, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
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
     * Animation to send. Pass a file_id as String to send an animation that exists on the Telegram
     * servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the
     * Internet, or upload a new animation using multipart/form-data. More information on Sending
     * Files
     */
    public InputFileOrString animation() {
        return animation;
    }

    /**
     * Duration of sent animation in seconds
     */
    public @Nullable Long duration() {
        return duration;
    }

    /**
     * Animation width
     */
    public @Nullable Long width() {
        return width;
    }

    /**
     * Animation height
     */
    public @Nullable Long height() {
        return height;
    }

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported
     * server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A
     * thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using
     * multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so
     * you can pass 'attach://&lt;file_attach_name&gt;' if the thumbnail was uploaded using
     * multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
     */
    public @Nullable InputFileOrString thumbnail() {
        return thumbnail;
    }

    /**
     * Animation caption (may also be used when resending animation by file_id), 0-1024 characters
     * after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the animation caption. See formatting options for more details.
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
     * Pass True if the animation needs to be covered with a spoiler animation
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

    public SendAnimation withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withChatId(ChatId chatId) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withAnimation(InputFileOrString animation) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withDuration(@Nullable Long duration) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withWidth(@Nullable Long width) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withHeight(@Nullable Long height) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withCaption(@Nullable String caption) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withParseMode(@Nullable ParseMode parseMode) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withHasSpoiler(@Nullable Boolean hasSpoiler) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withProtectContent(@Nullable Boolean protectContent) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withMessageEffectId(@Nullable String messageEffectId) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAnimation withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendAnimation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, animation, duration, width, height, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendAnimation)) {
            return false;
        }
        SendAnimation that = (SendAnimation) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.animation, that.animation)
                && Objects.equals(this.duration, that.duration)
                && Objects.equals(this.width, that.width)
                && Objects.equals(this.height, that.height)
                && Objects.equals(this.thumbnail, that.thumbnail)
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
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.animation, this.duration, this.width, this.height, this.thumbnail, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.hasSpoiler, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendAnimation[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", animation=" + this.animation
                + ", duration=" + this.duration
                + ", width=" + this.width
                + ", height=" + this.height
                + ", thumbnail=" + this.thumbnail
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
