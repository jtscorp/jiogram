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
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the
 * Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional
 * caption. Alternatively, you can use input_message_content to send a message with the specified
 * content instead of the animation.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedmpeg4gif">InlineQueryResultCachedMpeg4Gif in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultCachedMpeg4Gif implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("mpeg4_file_id")
    private final String mpeg4FileId;

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
     * Creates a new {@code InlineQueryResultCachedMpeg4Gif} instance.
     *
     * @param type Type of the result, must be mpeg4_gif
     * @param id Unique identifier for this result, 1-64 bytes
     * @param mpeg4FileId A valid file identifier for the MPEG4 file
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
    public InlineQueryResultCachedMpeg4Gif(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("mpeg4_file_id") String mpeg4FileId,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.mpeg4FileId = mpeg4FileId;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultCachedMpeg4Gif of(String id, String mpeg4FileId) {
        return new InlineQueryResultCachedMpeg4Gif(InlineQueryResultType.MPEG4_GIF, id, mpeg4FileId, null, null, null, null, null, null, null);
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
     * A valid file identifier for the MPEG4 file
     */
    public String mpeg4FileId() {
        return mpeg4FileId;
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

    public InlineQueryResultCachedMpeg4Gif withId(String id) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withMpeg4FileId(String mpeg4FileId) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withTitle(@Nullable String title) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withCaption(@Nullable String caption) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultCachedMpeg4Gif)) {
            return false;
        }
        InlineQueryResultCachedMpeg4Gif that = (InlineQueryResultCachedMpeg4Gif) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.mpeg4FileId, that.mpeg4FileId)
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
        return Objects.hash(this.type, this.id, this.mpeg4FileId, this.title, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedMpeg4Gif[type=" + this.type
                + ", id=" + this.id
                + ", mpeg4FileId=" + this.mpeg4FileId
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
