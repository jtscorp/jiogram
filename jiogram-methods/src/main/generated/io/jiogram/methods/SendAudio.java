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
 * Use this method to send audio files, if you want Telegram clients to display them in the music
 * player. Your audio must be in the .MP3 or .M4A format. On success, the sent Message is returned.
 * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the
 * future.
 * <br>For sending voice messages, use the sendVoice method instead.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendaudio">sendAudio in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendAudio implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("audio")
    private final InputFileOrString audio;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("duration")
    private final @Nullable Long duration;

    @JsonProperty("performer")
    private final @Nullable String performer;

    @JsonProperty("title")
    private final @Nullable String title;

    @JsonProperty("thumbnail")
    private final @Nullable InputFileOrString thumbnail;

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
     * Creates a new {@code SendAudio} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param audio Audio file to send. Pass a file_id as String to send an audio file that exists
     *     on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get
     *     an audio file from the Internet, or upload a new one using multipart/form-data. More
     *     information on Sending Files
     * @param caption Audio caption, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the audio caption. See formatting options for
     *     more details.
     * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
     *     which can be specified instead of parse_mode
     * @param duration Duration of the audio in seconds
     * @param performer Performer
     * @param title Track name
     * @param thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the
     *     file is supported server-side. The thumbnail should be in JPEG format and less than 200
     *     kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is
     *     not uploaded using multipart/form-data. Thumbnails can't be reused and can be only
     *     uploaded as a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the
     *     thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. More
     *     information on Sending Files
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
    public SendAudio(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("audio") InputFileOrString audio,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("performer") @Nullable String performer,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
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
        this.audio = audio;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
        this.thumbnail = thumbnail;
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
        return "sendAudio";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendAudio of(ChatId chatId, InputFileOrString audio) {
        return new SendAudio(null, chatId, null, null, audio, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendAudio answer(Message message, InputFileOrString audio) {
        return new SendAudio(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), audio, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendAudio reply(Message message, InputFileOrString audio) {
        return new SendAudio(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), audio, null, null, null, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
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
     * Audio file to send. Pass a file_id as String to send an audio file that exists on the
     * Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio
     * file from the Internet, or upload a new one using multipart/form-data. More information on
     * Sending Files
     */
    public InputFileOrString audio() {
        return audio;
    }

    /**
     * Audio caption, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the audio caption. See formatting options for more details.
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
     * Duration of the audio in seconds
     */
    public @Nullable Long duration() {
        return duration;
    }

    /**
     * Performer
     */
    public @Nullable String performer() {
        return performer;
    }

    /**
     * Track name
     */
    public @Nullable String title() {
        return title;
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

    public SendAudio withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withChatId(ChatId chatId) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withAudio(InputFileOrString audio) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withCaption(@Nullable String caption) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withParseMode(@Nullable ParseMode parseMode) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withDuration(@Nullable Long duration) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withPerformer(@Nullable String performer) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withTitle(@Nullable String title) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withProtectContent(@Nullable Boolean protectContent) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withMessageEffectId(@Nullable String messageEffectId) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendAudio withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendAudio(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, audio, caption, parseMode, captionEntities, duration, performer, title, thumbnail, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendAudio)) {
            return false;
        }
        SendAudio that = (SendAudio) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.audio, that.audio)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.duration, that.duration)
                && Objects.equals(this.performer, that.performer)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.thumbnail, that.thumbnail)
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
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.audio, this.caption, this.parseMode, this.captionEntities, this.duration, this.performer, this.title, this.thumbnail, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendAudio[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", audio=" + this.audio
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", duration=" + this.duration
                + ", performer=" + this.performer
                + ", title=" + this.title
                + ", thumbnail=" + this.thumbnail
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
