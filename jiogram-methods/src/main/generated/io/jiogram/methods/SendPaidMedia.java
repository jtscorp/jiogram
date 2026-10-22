package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputPaidMedia;
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
 * Use this method to send paid media. On success, the sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendpaidmedia">sendPaidMedia in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendPaidMedia implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("star_count")
    private final long starCount;

    @JsonProperty("media")
    private final List<InputPaidMedia> media;

    @JsonProperty("payload")
    private final @Nullable String payload;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("show_caption_above_media")
    private final @Nullable Boolean showCaptionAboveMedia;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("allow_paid_broadcast")
    private final @Nullable Boolean allowPaidBroadcast;

    @JsonProperty("suggested_post_parameters")
    private final @Nullable SuggestedPostParameters suggestedPostParameters;

    @JsonProperty("reply_parameters")
    private final @Nullable ReplyParameters replyParameters;

    @JsonProperty("reply_markup")
    private final @Nullable ReplyMarkup replyMarkup;

    /**
     * Creates a new {@code SendPaidMedia} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername). If the chat is a channel, all Telegram Star proceeds from
     *     this media will be credited to the chat's balance. Otherwise, they will be credited to
     *     the bot's balance.
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param starCount The number of Telegram Stars that must be paid to buy access to the media;
     *     1-25000
     * @param media A JSON-serialized array describing the media to be sent; up to 10 items
     * @param payload Bot-defined paid media payload, 0-128 bytes. This will not be displayed to the
     *     user, use it for your internal processes.
     * @param caption Media caption, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the media caption. See formatting options for
     *     more details.
     * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
     *     which can be specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param disableNotification Sends the message silently. Users will receive a notification with
     *     no sound.
     * @param protectContent Protects the contents of the sent message from forwarding and saving
     * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
     *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will
     *     be withdrawn from the bot's balance
     * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
     *     suggested post to send; for direct messages chats only. If the message is sent as a reply
     *     to another suggested post, then that suggested post is automatically declined.
     * @param replyParameters Description of the message to reply to
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline
     *     keyboard, custom reply keyboard, instructions to remove a reply keyboard or to force a
     *     reply from the user
     */
    @JsonCreator
    public SendPaidMedia(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("star_count") long starCount,
            @JsonProperty("media") List<InputPaidMedia> media,
            @JsonProperty("payload") @Nullable String payload,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.starCount = starCount;
        this.media = media;
        this.payload = payload;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.suggestedPostParameters = suggestedPostParameters;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "sendPaidMedia";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendPaidMedia of(ChatId chatId, long starCount, List<InputPaidMedia> media) {
        return new SendPaidMedia(null, chatId, null, null, starCount, media, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendPaidMedia answer(Message message, long starCount, List<InputPaidMedia> media) {
        return new SendPaidMedia(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), starCount, media, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendPaidMedia reply(Message message, long starCount, List<InputPaidMedia> media) {
        return new SendPaidMedia(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), starCount, media, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
    }

    /**
     * Unique identifier of the business connection on behalf of which the message will be sent
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername). If the chat is a channel, all Telegram Star proceeds from this media
     * will be credited to the chat's balance. Otherwise, they will be credited to the bot's
     * balance.
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
     * The number of Telegram Stars that must be paid to buy access to the media; 1-25000
     */
    public long starCount() {
        return starCount;
    }

    /**
     * A JSON-serialized array describing the media to be sent; up to 10 items
     */
    public List<InputPaidMedia> media() {
        return media;
    }

    /**
     * Bot-defined paid media payload, 0-128 bytes. This will not be displayed to the user, use it
     * for your internal processes.
     */
    public @Nullable String payload() {
        return payload;
    }

    /**
     * Media caption, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the media caption. See formatting options for more details.
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

    public SendPaidMedia withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withChatId(ChatId chatId) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withStarCount(long starCount) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withMedia(List<InputPaidMedia> media) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withPayload(@Nullable String payload) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withCaption(@Nullable String caption) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withParseMode(@Nullable ParseMode parseMode) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withProtectContent(@Nullable Boolean protectContent) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendPaidMedia withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendPaidMedia(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, starCount, media, payload, caption, parseMode, captionEntities, showCaptionAboveMedia, disableNotification, protectContent, allowPaidBroadcast, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendPaidMedia)) {
            return false;
        }
        SendPaidMedia that = (SendPaidMedia) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && this.starCount == that.starCount
                && Objects.equals(this.media, that.media)
                && Objects.equals(this.payload, that.payload)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.allowPaidBroadcast, that.allowPaidBroadcast)
                && Objects.equals(this.suggestedPostParameters, that.suggestedPostParameters)
                && Objects.equals(this.replyParameters, that.replyParameters)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.starCount, this.media, this.payload, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendPaidMedia[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", starCount=" + this.starCount
                + ", media=" + this.media
                + ", payload=" + this.payload
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", allowPaidBroadcast=" + this.allowPaidBroadcast
                + ", suggestedPostParameters=" + this.suggestedPostParameters
                + ", replyParameters=" + this.replyParameters
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
