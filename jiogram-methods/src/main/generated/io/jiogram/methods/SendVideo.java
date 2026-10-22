package io.jiogram.methods;

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

/**
 * Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be
 * sent as Document). On success, the sent Message is returned. Bots can currently send video files
 * of up to 50 MB in size, this limit may be changed in the future.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the message will be
 *     sent; required if the message is sent to a direct messages chat
 * @param video Video to send. Pass a file_id as String to send a video that exists on the Telegram
 *     servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the
 *     Internet, or upload a new video using multipart/form-data. More information on Sending Files
 * @param duration Duration of sent video in seconds
 * @param width Video width
 * @param height Video height
 * @param thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file
 *     is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in
 *     size. A thumbnail's width and height should not exceed 320. Ignored if the file is not
 *     uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a
 *     new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the thumbnail was uploaded
 *     using multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
 * @param cover Cover for the video in the message. Pass a file_id to send a file that exists on the
 *     Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the
 *     Internet, or pass 'attach://&lt;file_attach_name&gt;' to upload a new one using
 *     multipart/form-data under &lt;file_attach_name&gt; name. More information on Sending Files
 * @param startTimestamp Start timestamp for the video in the message
 * @param caption Video caption (may also be used when resending videos by file_id), 0-1024
 *     characters after entities parsing
 * @param parseMode Mode for parsing entities in the video caption. See formatting options for more
 *     details.
 * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
 *     which can be specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
 * @param hasSpoiler Pass True if the video needs to be covered with a spoiler animation
 * @param supportsStreaming Pass True if the uploaded video is suitable for streaming
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
 * @see <a href="https://core.telegram.org/bots/api#sendvideo">sendVideo in the Bot API</a>
 */
public record SendVideo(
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
) implements TelegramMethod<Message> {

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
}
