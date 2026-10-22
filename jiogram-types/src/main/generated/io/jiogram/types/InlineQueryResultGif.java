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
 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the
 * user with optional caption. Alternatively, you can use input_message_content to send a message
 * with the specified content instead of the animation.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultgif">InlineQueryResultGif in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultGif implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("gif_url")
    private final String gifUrl;

    @JsonProperty("gif_width")
    private final @Nullable Long gifWidth;

    @JsonProperty("gif_height")
    private final @Nullable Long gifHeight;

    @JsonProperty("gif_duration")
    private final @Nullable Long gifDuration;

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
     * Creates a new {@code InlineQueryResultGif} instance.
     *
     * @param type Type of the result, must be gif
     * @param id Unique identifier for this result, 1-64 bytes
     * @param gifUrl A valid URL for the GIF file
     * @param gifWidth Width of the GIF
     * @param gifHeight Height of the GIF
     * @param gifDuration Duration of the GIF in seconds
     * @param thumbnailUrl URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the
     *     result
     * @param thumbnailMimeType MIME type of the thumbnail, must be one of 'image/jpeg',
     *     'image/gif', or 'video/mp4'. Defaults to 'image/jpeg'
     * @param title Title for the result
     * @param caption Caption of the GIF file to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the caption. See formatting options for more
     *     details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the GIF animation
     */
    @JsonCreator
    public InlineQueryResultGif(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("gif_url") String gifUrl,
            @JsonProperty("gif_width") @Nullable Long gifWidth,
            @JsonProperty("gif_height") @Nullable Long gifHeight,
            @JsonProperty("gif_duration") @Nullable Long gifDuration,
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
        this.gifUrl = gifUrl;
        this.gifWidth = gifWidth;
        this.gifHeight = gifHeight;
        this.gifDuration = gifDuration;
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

    public static InlineQueryResultGif of(String id, String gifUrl, String thumbnailUrl) {
        return new InlineQueryResultGif(InlineQueryResultType.GIF, id, gifUrl, null, null, null, thumbnailUrl, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be gif
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
     * A valid URL for the GIF file
     */
    public String gifUrl() {
        return gifUrl;
    }

    /**
     * Width of the GIF
     */
    public @Nullable Long gifWidth() {
        return gifWidth;
    }

    /**
     * Height of the GIF
     */
    public @Nullable Long gifHeight() {
        return gifHeight;
    }

    /**
     * Duration of the GIF in seconds
     */
    public @Nullable Long gifDuration() {
        return gifDuration;
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
     * Caption of the GIF file to be sent, 0-1024 characters after entities parsing
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
     * Content of the message to be sent instead of the GIF animation
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultGif withId(String id) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withGifUrl(String gifUrl) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withGifWidth(@Nullable Long gifWidth) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withGifHeight(@Nullable Long gifHeight) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withGifDuration(@Nullable Long gifDuration) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withThumbnailUrl(String thumbnailUrl) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withThumbnailMimeType(@Nullable ThumbnailMimeType thumbnailMimeType) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withTitle(@Nullable String title) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withCaption(@Nullable String caption) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultGif)) {
            return false;
        }
        InlineQueryResultGif that = (InlineQueryResultGif) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.gifUrl, that.gifUrl)
                && Objects.equals(this.gifWidth, that.gifWidth)
                && Objects.equals(this.gifHeight, that.gifHeight)
                && Objects.equals(this.gifDuration, that.gifDuration)
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
        return Objects.hash(this.type, this.id, this.gifUrl, this.gifWidth, this.gifHeight, this.gifDuration, this.thumbnailUrl, this.thumbnailMimeType, this.title, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultGif[type=" + this.type
                + ", id=" + this.id
                + ", gifUrl=" + this.gifUrl
                + ", gifWidth=" + this.gifWidth
                + ", gifHeight=" + this.gifHeight
                + ", gifDuration=" + this.gifDuration
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
