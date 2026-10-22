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
import io.jiogram.types.ThumbnailMimeType;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this
 * animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use
 * input_message_content to send a message with the specified content instead of the animation.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultmpeg4gif">InlineQueryResultMpeg4Gif in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultMpeg4Gif implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("mpeg4_url")
    private final String mpeg4Url;

    @JsonProperty("mpeg4_width")
    private final @Nullable Long mpeg4Width;

    @JsonProperty("mpeg4_height")
    private final @Nullable Long mpeg4Height;

    @JsonProperty("mpeg4_duration")
    private final @Nullable Long mpeg4Duration;

    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;

    @JsonProperty("thumbnail_mime_type")
    private final @Nullable ThumbnailMimeType thumbnailMimeType;

    @JsonProperty("title")
    private final @Nullable String title;

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
     * Creates a new {@code InlineQueryResultMpeg4Gif} instance.
     *
     * @param type Type of the result, must be mpeg4_gif
     * @param id Unique identifier for this result, 1-64 bytes
     * @param mpeg4Url A valid URL for the MPEG4 file
     * @param mpeg4Width Video width
     * @param mpeg4Height Video height
     * @param mpeg4Duration Video duration in seconds
     * @param thumbnailUrl URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the
     *     result
     * @param thumbnailMimeType MIME type of the thumbnail, must be one of 'image/jpeg',
     *     'image/gif', or 'video/mp4'. Defaults to 'image/jpeg'
     * @param title Title for the result
     * @param caption Caption of the MPEG-4 file to be sent, 0-1024 characters after entities
     *     parsing
     * @param parseMode Mode for parsing entities in the caption. See formatting options for more
     *     details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the video animation
     */
    @JsonCreator
    public InlineQueryResultMpeg4Gif(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("mpeg4_url") String mpeg4Url,
            @JsonProperty("mpeg4_width") @Nullable Long mpeg4Width,
            @JsonProperty("mpeg4_height") @Nullable Long mpeg4Height,
            @JsonProperty("mpeg4_duration") @Nullable Long mpeg4Duration,
            @JsonProperty("thumbnail_url") String thumbnailUrl,
            @JsonProperty("thumbnail_mime_type") @Nullable ThumbnailMimeType thumbnailMimeType,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.mpeg4Url = mpeg4Url;
        this.mpeg4Width = mpeg4Width;
        this.mpeg4Height = mpeg4Height;
        this.mpeg4Duration = mpeg4Duration;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailMimeType = thumbnailMimeType;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultMpeg4Gif of(String id, String mpeg4Url, String thumbnailUrl) {
        return new InlineQueryResultMpeg4Gif(InlineQueryResultType.MPEG4_GIF, id, mpeg4Url, null, null, null, thumbnailUrl, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be mpeg4_gif
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
     * A valid URL for the MPEG4 file
     */
    public String mpeg4Url() {
        return mpeg4Url;
    }

    /**
     * Video width
     */
    public @Nullable Long mpeg4Width() {
        return mpeg4Width;
    }

    /**
     * Video height
     */
    public @Nullable Long mpeg4Height() {
        return mpeg4Height;
    }

    /**
     * Video duration in seconds
     */
    public @Nullable Long mpeg4Duration() {
        return mpeg4Duration;
    }

    /**
     * URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
     */
    public String thumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * MIME type of the thumbnail, must be one of 'image/jpeg', 'image/gif', or 'video/mp4'.
     * Defaults to 'image/jpeg'
     */
    public @Nullable ThumbnailMimeType thumbnailMimeType() {
        return thumbnailMimeType;
    }

    /**
     * Title for the result
     */
    public @Nullable String title() {
        return title;
    }

    /**
     * Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the caption. See formatting options for more details.
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
     * Content of the message to be sent instead of the video animation
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultMpeg4Gif withId(String id) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withMpeg4Url(String mpeg4Url) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withMpeg4Width(@Nullable Long mpeg4Width) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withMpeg4Height(@Nullable Long mpeg4Height) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withMpeg4Duration(@Nullable Long mpeg4Duration) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withThumbnailUrl(String thumbnailUrl) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withThumbnailMimeType(@Nullable ThumbnailMimeType thumbnailMimeType) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withTitle(@Nullable String title) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withCaption(@Nullable String caption) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultMpeg4Gif withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultMpeg4Gif(type, id, mpeg4Url, mpeg4Width, mpeg4Height, mpeg4Duration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultMpeg4Gif)) {
            return false;
        }
        InlineQueryResultMpeg4Gif that = (InlineQueryResultMpeg4Gif) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.mpeg4Url, that.mpeg4Url)
                && Objects.equals(this.mpeg4Width, that.mpeg4Width)
                && Objects.equals(this.mpeg4Height, that.mpeg4Height)
                && Objects.equals(this.mpeg4Duration, that.mpeg4Duration)
                && Objects.equals(this.thumbnailUrl, that.thumbnailUrl)
                && Objects.equals(this.thumbnailMimeType, that.thumbnailMimeType)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.mpeg4Url, this.mpeg4Width, this.mpeg4Height, this.mpeg4Duration, this.thumbnailUrl, this.thumbnailMimeType, this.title, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultMpeg4Gif[type=" + this.type
                + ", id=" + this.id
                + ", mpeg4Url=" + this.mpeg4Url
                + ", mpeg4Width=" + this.mpeg4Width
                + ", mpeg4Height=" + this.mpeg4Height
                + ", mpeg4Duration=" + this.mpeg4Duration
                + ", thumbnailUrl=" + this.thumbnailUrl
                + ", thumbnailMimeType=" + this.thumbnailMimeType
                + ", title=" + this.title
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
