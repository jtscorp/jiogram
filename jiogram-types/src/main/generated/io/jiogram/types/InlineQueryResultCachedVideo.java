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
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a video file stored on the Telegram servers. By default, this video file
 * will be sent by the user with an optional caption. Alternatively, you can use
 * input_message_content to send a message with the specified content instead of the video.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedvideo">InlineQueryResultCachedVideo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultCachedVideo implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("video_file_id")
    private final String videoFileId;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("description")
    private final @Nullable String description;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("show_caption_above_media")
    private final @Nullable Boolean showCaptionAboveMedia;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    /**
     * Creates a new {@code InlineQueryResultCachedVideo} instance.
     *
     * @param type Type of the result, must be video
     * @param id Unique identifier for this result, 1-64 bytes
     * @param videoFileId A valid file identifier for the video file
     * @param title Title for the result
     * @param description Short description of the result
     * @param caption Caption of the video to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the video caption. See formatting options for
     *     more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the video
     */
    @JsonCreator
    public InlineQueryResultCachedVideo(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("video_file_id") String videoFileId,
            @JsonProperty("title") String title,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.videoFileId = videoFileId;
        this.title = title;
        this.description = description;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultCachedVideo of(String id, String videoFileId, String title) {
        return new InlineQueryResultCachedVideo(InlineQueryResultType.VIDEO, id, videoFileId, title, null, null, null, null, null, null, null);
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
     * A valid file identifier for the video file
     */
    public String videoFileId() {
        return videoFileId;
    }

    /**
     * Title for the result
     */
    public String title() {
        return title;
    }

    /**
     * Short description of the result
     */
    public @Nullable String description() {
        return description;
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
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the video
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedVideo withId(String id) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withVideoFileId(String videoFileId) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withTitle(String title) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withDescription(@Nullable String description) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withCaption(@Nullable String caption) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVideo withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultCachedVideo(type, id, videoFileId, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultCachedVideo)) {
            return false;
        }
        InlineQueryResultCachedVideo that = (InlineQueryResultCachedVideo) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.videoFileId, that.videoFileId)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.videoFileId, this.title, this.description, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedVideo[type=" + this.type
                + ", id=" + this.id
                + ", videoFileId=" + this.videoFileId
                + ", title=" + this.title
                + ", description=" + this.description
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
