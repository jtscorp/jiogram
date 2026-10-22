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
 * Represents a link to a photo. By default, this photo will be sent by the user with optional
 * caption. Alternatively, you can use input_message_content to send a message with the specified
 * content instead of the photo.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultphoto">InlineQueryResultPhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultPhoto implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("photo_url")
    private final String photoUrl;

    @JsonProperty("thumbnail_url")
    private final String thumbnailUrl;

    @JsonProperty("photo_width")
    private final @Nullable Long photoWidth;

    @JsonProperty("photo_height")
    private final @Nullable Long photoHeight;

    @JsonProperty("title")
    private final @Nullable String title;

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
     * Creates a new {@code InlineQueryResultPhoto} instance.
     *
     * @param type Type of the result, must be photo
     * @param id Unique identifier for this result, 1-64 bytes
     * @param photoUrl A valid URL of the photo. Photo must be in JPEG format. Photo size must not
     *     exceed 5MB
     * @param thumbnailUrl URL of the thumbnail for the photo
     * @param photoWidth Width of the photo
     * @param photoHeight Height of the photo
     * @param title Title for the result
     * @param description Short description of the result
     * @param caption Caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the photo caption. See formatting options for
     *     more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the photo
     */
    @JsonCreator
    public InlineQueryResultPhoto(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("photo_url") String photoUrl,
            @JsonProperty("thumbnail_url") String thumbnailUrl,
            @JsonProperty("photo_width") @Nullable Long photoWidth,
            @JsonProperty("photo_height") @Nullable Long photoHeight,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.photoUrl = photoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.photoWidth = photoWidth;
        this.photoHeight = photoHeight;
        this.title = title;
        this.description = description;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultPhoto of(String id, String photoUrl, String thumbnailUrl) {
        return new InlineQueryResultPhoto(InlineQueryResultType.PHOTO, id, photoUrl, thumbnailUrl, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be photo
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
     * A valid URL of the photo. Photo must be in JPEG format. Photo size must not exceed 5MB
     */
    public String photoUrl() {
        return photoUrl;
    }

    /**
     * URL of the thumbnail for the photo
     */
    public String thumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Width of the photo
     */
    public @Nullable Long photoWidth() {
        return photoWidth;
    }

    /**
     * Height of the photo
     */
    public @Nullable Long photoHeight() {
        return photoHeight;
    }

    /**
     * Title for the result
     */
    public @Nullable String title() {
        return title;
    }

    /**
     * Short description of the result
     */
    public @Nullable String description() {
        return description;
    }

    /**
     * Caption of the photo to be sent, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the photo caption. See formatting options for more details.
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
     * Content of the message to be sent instead of the photo
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultPhoto withId(String id) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withPhotoUrl(String photoUrl) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withThumbnailUrl(String thumbnailUrl) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withPhotoWidth(@Nullable Long photoWidth) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withPhotoHeight(@Nullable Long photoHeight) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withTitle(@Nullable String title) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withDescription(@Nullable String description) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withCaption(@Nullable String caption) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultPhoto withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultPhoto(type, id, photoUrl, thumbnailUrl, photoWidth, photoHeight, title, description, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultPhoto)) {
            return false;
        }
        InlineQueryResultPhoto that = (InlineQueryResultPhoto) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.photoUrl, that.photoUrl)
                && Objects.equals(this.thumbnailUrl, that.thumbnailUrl)
                && Objects.equals(this.photoWidth, that.photoWidth)
                && Objects.equals(this.photoHeight, that.photoHeight)
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
        return Objects.hash(this.type, this.id, this.photoUrl, this.thumbnailUrl, this.photoWidth, this.photoHeight, this.title, this.description, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultPhoto[type=" + this.type
                + ", id=" + this.id
                + ", photoUrl=" + this.photoUrl
                + ", thumbnailUrl=" + this.thumbnailUrl
                + ", photoWidth=" + this.photoWidth
                + ", photoHeight=" + this.photoHeight
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
