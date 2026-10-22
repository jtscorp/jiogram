package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.VideoMimeType;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a page containing an embedded video player or a video file. By default, this
 * video file will be sent by the user with an optional caption. Alternatively, you can use
 * input_message_content to send a message with the specified content instead of the video.
 * <br>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you must
 * replace its content using input_message_content.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultvideo">InlineQueryResultVideo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultVideo implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("video_url")
    private final String videoUrl;

    @JsonProperty("mime_type")
    private final VideoMimeType mimeType;

    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("show_caption_above_media")
    private final @Nullable Boolean showCaptionAboveMedia;

    @JsonProperty("video_width")
    private final @Nullable Long videoWidth;

    @JsonProperty("video_height")
    private final @Nullable Long videoHeight;

    @JsonProperty("video_duration")
    private final @Nullable Long videoDuration;

    @JsonProperty("description")
    private final @Nullable String description;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    /**
     * Creates a new {@code InlineQueryResultVideo} instance.
     *
     * @param type Type of the result, must be video
     * @param id Unique identifier for this result, 1-64 bytes
     * @param videoUrl A valid URL for the embedded video player or video file
     * @param mimeType MIME type of the content of the video URL, 'text/html' or 'video/mp4'
     * @param thumbnailUrl URL of the thumbnail (JPEG only) for the video
     * @param title Title for the result
     * @param caption Caption of the video to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the video caption. See formatting options for
     *     more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param videoWidth Video width
     * @param videoHeight Video height
     * @param videoDuration Video duration in seconds
     * @param description Short description of the result
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the video. This field
     *     is required if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a
     *     YouTube video).
     */
    @JsonCreator
    public InlineQueryResultVideo(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("video_url") String videoUrl,
            @JsonProperty("mime_type") VideoMimeType mimeType,
            @JsonProperty("thumbnail_url") String thumbnailUrl,
            @JsonProperty("title") String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("video_width") @Nullable Long videoWidth,
            @JsonProperty("video_height") @Nullable Long videoHeight,
            @JsonProperty("video_duration") @Nullable Long videoDuration,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.videoUrl = videoUrl;
        this.mimeType = mimeType;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
        this.videoDuration = videoDuration;
        this.description = description;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultVideo of(String id, String videoUrl, VideoMimeType mimeType, String thumbnailUrl, String title) {
        return new InlineQueryResultVideo(InlineQueryResultType.VIDEO, id, videoUrl, mimeType, thumbnailUrl, title, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be video
     */
    public InlineQueryResultType type() {
        return type;
    }

    /**
     * Unique identifier for this result, 1-64 bytes
     */
    public String id() {
        return id;
    }

    /**
     * A valid URL for the embedded video player or video file
     */
    public String videoUrl() {
        return videoUrl;
    }

    /**
     * MIME type of the content of the video URL, 'text/html' or 'video/mp4'
     */
    public VideoMimeType mimeType() {
        return mimeType;
    }

    /**
     * URL of the thumbnail (JPEG only) for the video
     */
    public String thumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Title for the result
     */
    public String title() {
        return title;
    }

    /**
     * Caption of the video to be sent, 0-1024 characters after entities parsing
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
     * List of special entities that appear in the caption, which can be specified instead of
     * parse_mode
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
     * Video width
     */
    public @Nullable Long videoWidth() {
        return videoWidth;
    }

    /**
     * Video height
     */
    public @Nullable Long videoHeight() {
        return videoHeight;
    }

    /**
     * Video duration in seconds
     */
    public @Nullable Long videoDuration() {
        return videoDuration;
    }

    /**
     * Short description of the result
     */
    public @Nullable String description() {
        return description;
    }

    /**
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the video. This field is required if
     * InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultVideo withId(String id) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withVideoUrl(String videoUrl) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withMimeType(VideoMimeType mimeType) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withThumbnailUrl(String thumbnailUrl) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withTitle(String title) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withCaption(@Nullable String caption) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withVideoWidth(@Nullable Long videoWidth) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withVideoHeight(@Nullable Long videoHeight) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withVideoDuration(@Nullable Long videoDuration) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withDescription(@Nullable String description) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVideo withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultVideo(type, id, videoUrl, mimeType, thumbnailUrl, title, caption, parseMode, captionEntities, showCaptionAboveMedia, videoWidth, videoHeight, videoDuration, description, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultVideo)) {
            return false;
        }
        InlineQueryResultVideo that = (InlineQueryResultVideo) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.videoUrl, that.videoUrl)
                && Objects.equals(this.mimeType, that.mimeType)
                && Objects.equals(this.thumbnailUrl, that.thumbnailUrl)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.videoWidth, that.videoWidth)
                && Objects.equals(this.videoHeight, that.videoHeight)
                && Objects.equals(this.videoDuration, that.videoDuration)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.videoUrl, this.mimeType, this.thumbnailUrl, this.title, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.videoWidth, this.videoHeight, this.videoDuration, this.description, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultVideo[type=" + this.type
                + ", id=" + this.id
                + ", videoUrl=" + this.videoUrl
                + ", mimeType=" + this.mimeType
                + ", thumbnailUrl=" + this.thumbnailUrl
                + ", title=" + this.title
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", videoWidth=" + this.videoWidth
                + ", videoHeight=" + this.videoHeight
                + ", videoDuration=" + this.videoDuration
                + ", description=" + this.description
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
