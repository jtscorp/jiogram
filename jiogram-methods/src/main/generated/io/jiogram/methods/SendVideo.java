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
 * Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be
 * sent as Document). On success, the sent Message is returned. Bots can currently send video files
 * of up to 50 MB in size, this limit may be changed in the future.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendvideo">sendVideo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendVideo implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("video")
    private final InputFileOrString video;

    @JsonProperty("duration")
    private final @Nullable Long duration;

    @JsonProperty("width")
    private final @Nullable Long width;

    @JsonProperty("height")
    private final @Nullable Long height;

    @JsonProperty("thumbnail")
    private final @Nullable InputFileOrString thumbnail;

    @JsonProperty("cover")
    private final @Nullable InputFileOrString cover;

    @JsonProperty("start_timestamp")
    private final @Nullable Long startTimestamp;

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

    @JsonProperty("supports_streaming")
    private final @Nullable Boolean supportsStreaming;

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
     * Creates a new {@code SendVideo} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param video Video to send. Pass a file_id as String to send a video that exists on the
     *     Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video
     *     from the Internet, or upload a new video using multipart/form-data. More information on
     *     Sending Files
     * @param duration Duration of sent video in seconds
     * @param width Video width
     * @param height Video height
     * @param thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the
     *     file is supported server-side. The thumbnail should be in JPEG format and less than 200
     *     kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is
     *     not uploaded using multipart/form-data. Thumbnails can't be reused and can be only
     *     uploaded as a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the
     *     thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. More
     *     information on Sending Files
     * @param cover Cover for the video in the message. Pass a file_id to send a file that exists on
     *     the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the
     *     Internet, or pass 'attach://&lt;file_attach_name&gt;' to upload a new one using
     *     multipart/form-data under &lt;file_attach_name&gt; name. More information on Sending
     *     Files
     * @param startTimestamp Start timestamp for the video in the message
     * @param caption Video caption (may also be used when resending videos by file_id), 0-1024
     *     characters after entities parsing
     * @param parseMode Mode for parsing entities in the video caption. See formatting options for
     *     more details.
     * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
     *     which can be specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param hasSpoiler Pass True if the video needs to be covered with a spoiler animation
     * @param supportsStreaming Pass True if the uploaded video is suitable for streaming
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
    public SendVideo(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("video") InputFileOrString video,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
            @JsonProperty("cover") @Nullable InputFileOrString cover,
            @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler,
            @JsonProperty("supports_streaming") @Nullable Boolean supportsStreaming,
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
        this.video = video;
        this.duration = duration;
        this.width = width;
        this.height = height;
        this.thumbnail = thumbnail;
        this.cover = cover;
        this.startTimestamp = startTimestamp;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.hasSpoiler = hasSpoiler;
        this.supportsStreaming = supportsStreaming;
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
        return "sendVideo";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendVideo of(ChatId chatId, InputFileOrString video) {
        return new SendVideo(null, chatId, null, null, video, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendVideo answer(Message message, InputFileOrString video) {
        return new SendVideo(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), video, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendVideo reply(Message message, InputFileOrString video) {
        return new SendVideo(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), video, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
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
     * Video to send. Pass a file_id as String to send a video that exists on the Telegram servers
     * (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or
     * upload a new video using multipart/form-data. More information on Sending Files
     */
    public InputFileOrString video() {
        return video;
    }

    /**
     * Duration of sent video in seconds
     */
    public @Nullable Long duration() {
        return duration;
    }

    /**
     * Video width
     */
    public @Nullable Long width() {
        return width;
    }

    /**
     * Video height
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
     * Cover for the video in the message. Pass a file_id to send a file that exists on the Telegram
     * servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
     * 'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
     * &lt;file_attach_name&gt; name. More information on Sending Files
     */
    public @Nullable InputFileOrString cover() {
        return cover;
    }

    /**
     * Start timestamp for the video in the message
     */
    public @Nullable Long startTimestamp() {
        return startTimestamp;
    }

    /**
     * Video caption (may also be used when resending videos by file_id), 0-1024 characters after
     * entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the video caption. See formatting options for more details.
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
     * Pass True if the video needs to be covered with a spoiler animation
     */
    public @Nullable Boolean hasSpoiler() {
        return hasSpoiler;
    }

    /**
     * Pass True if the uploaded video is suitable for streaming
     */
    public @Nullable Boolean supportsStreaming() {
        return supportsStreaming;
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

    public SendVideo withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withChatId(ChatId chatId) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withVideo(InputFileOrString video) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withDuration(@Nullable Long duration) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withWidth(@Nullable Long width) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withHeight(@Nullable Long height) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withCover(@Nullable InputFileOrString cover) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withStartTimestamp(@Nullable Long startTimestamp) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withCaption(@Nullable String caption) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withParseMode(@Nullable ParseMode parseMode) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withHasSpoiler(@Nullable Boolean hasSpoiler) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withSupportsStreaming(@Nullable Boolean supportsStreaming) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withProtectContent(@Nullable Boolean protectContent) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withMessageEffectId(@Nullable String messageEffectId) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVideo withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendVideo(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, video, duration, width, height, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler, supportsStreaming, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendVideo)) {
            return false;
        }
        SendVideo that = (SendVideo) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.video, that.video)
                && Objects.equals(this.duration, that.duration)
                && Objects.equals(this.width, that.width)
                && Objects.equals(this.height, that.height)
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.cover, that.cover)
                && Objects.equals(this.startTimestamp, that.startTimestamp)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.hasSpoiler, that.hasSpoiler)
                && Objects.equals(this.supportsStreaming, that.supportsStreaming)
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
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.video, this.duration, this.width, this.height, this.thumbnail, this.cover, this.startTimestamp, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.hasSpoiler, this.supportsStreaming, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendVideo[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", video=" + this.video
                + ", duration=" + this.duration
                + ", width=" + this.width
                + ", height=" + this.height
                + ", thumbnail=" + this.thumbnail
                + ", cover=" + this.cover
                + ", startTimestamp=" + this.startTimestamp
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", hasSpoiler=" + this.hasSpoiler
                + ", supportsStreaming=" + this.supportsStreaming
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
