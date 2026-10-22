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
 * Represents a link to an animated GIF file stored on the Telegram servers. By default, this
 * animated GIF file will be sent by the user with an optional caption. Alternatively, you can use
 * input_message_content to send a message with specified content instead of the animation.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedgif">InlineQueryResultCachedGif in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultCachedGif implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("gif_file_id")
    private final String gifFileId;

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
     * Creates a new {@code InlineQueryResultCachedGif} instance.
     *
     * @param type Type of the result, must be gif
     * @param id Unique identifier for this result, 1-64 bytes
     * @param gifFileId A valid file identifier for the GIF file
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
    public InlineQueryResultCachedGif(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("gif_file_id") String gifFileId,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.gifFileId = gifFileId;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultCachedGif of(String id, String gifFileId) {
        return new InlineQueryResultCachedGif(InlineQueryResultType.GIF, id, gifFileId, null, null, null, null, null, null, null);
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
     * A valid file identifier for the GIF file
     */
    public String gifFileId() {
        return gifFileId;
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

    public InlineQueryResultCachedGif withId(String id) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedGif withGifFileId(String gifFileId) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedGif withTitle(@Nullable String title) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedGif withCaption(@Nullable String caption) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedGif withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedGif withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedGif withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedGif withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedGif withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultCachedGif(type, id, gifFileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultCachedGif)) {
            return false;
        }
        InlineQueryResultCachedGif that = (InlineQueryResultCachedGif) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.gifFileId, that.gifFileId)
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
        return Objects.hash(this.type, this.id, this.gifFileId, this.title, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedGif[type=" + this.type
                + ", id=" + this.id
                + ", gifFileId=" + this.gifFileId
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
