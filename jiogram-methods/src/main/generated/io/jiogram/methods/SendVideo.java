package io.jiogram.methods;

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
import org.jspecify.annotations.Nullable;

public class SendVideo implements TelegramMethod<Message> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("direct_messages_topic_id") @Nullable private final Long directMessagesTopicId;
    @JsonProperty("video") private final InputFileOrString video;
    @JsonProperty("duration") @Nullable private final Long duration;
    @JsonProperty("width") @Nullable private final Long width;
    @JsonProperty("height") @Nullable private final Long height;
    @JsonProperty("thumbnail") @Nullable private final InputFileOrString thumbnail;
    @JsonProperty("cover") @Nullable private final InputFileOrString cover;
    @JsonProperty("start_timestamp") @Nullable private final Long startTimestamp;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("show_caption_above_media") @Nullable private final Boolean showCaptionAboveMedia;
    @JsonProperty("has_spoiler") @Nullable private final Boolean hasSpoiler;
    @JsonProperty("supports_streaming") @Nullable private final Boolean supportsStreaming;
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;
    @JsonProperty("allow_paid_broadcast") @Nullable private final Boolean allowPaidBroadcast;
    @JsonProperty("message_effect_id") @Nullable private final String messageEffectId;
    @JsonProperty("suggested_post_parameters") @Nullable private final SuggestedPostParameters suggestedPostParameters;
    @JsonProperty("reply_parameters") @Nullable private final ReplyParameters replyParameters;
    @JsonProperty("reply_markup") @Nullable private final ReplyMarkup replyMarkup;

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
            @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup
    ) {
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

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageThreadId() {
        return this.messageThreadId;
    }

    public Long directMessagesTopicId() {
        return this.directMessagesTopicId;
    }

    public InputFileOrString video() {
        return this.video;
    }

    public Long duration() {
        return this.duration;
    }

    public Long width() {
        return this.width;
    }

    public Long height() {
        return this.height;
    }

    public InputFileOrString thumbnail() {
        return this.thumbnail;
    }

    public InputFileOrString cover() {
        return this.cover;
    }

    public Long startTimestamp() {
        return this.startTimestamp;
    }

    public String caption() {
        return this.caption;
    }

    public ParseMode parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> captionEntities() {
        return this.captionEntities;
    }

    public Boolean showCaptionAboveMedia() {
        return this.showCaptionAboveMedia;
    }

    public Boolean hasSpoiler() {
        return this.hasSpoiler;
    }

    public Boolean supportsStreaming() {
        return this.supportsStreaming;
    }

    public Boolean disableNotification() {
        return this.disableNotification;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

    public Boolean allowPaidBroadcast() {
        return this.allowPaidBroadcast;
    }

    public String messageEffectId() {
        return this.messageEffectId;
    }

    public SuggestedPostParameters suggestedPostParameters() {
        return this.suggestedPostParameters;
    }

    public ReplyParameters replyParameters() {
        return this.replyParameters;
    }

    public ReplyMarkup replyMarkup() {
        return this.replyMarkup;
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
}
