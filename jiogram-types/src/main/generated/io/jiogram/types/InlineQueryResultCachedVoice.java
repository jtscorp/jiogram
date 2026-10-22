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
 * Represents a link to a voice message stored on the Telegram servers. By default, this voice
 * message will be sent by the user. Alternatively, you can use input_message_content to send a
 * message with the specified content instead of the voice message.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedvoice">InlineQueryResultCachedVoice in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultCachedVoice implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("voice_file_id")
    private final String voiceFileId;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    /**
     * Creates a new {@code InlineQueryResultCachedVoice} instance.
     *
     * @param type Type of the result, must be voice
     * @param id Unique identifier for this result, 1-64 bytes
     * @param voiceFileId A valid file identifier for the voice message
     * @param title Voice message title
     * @param caption Caption, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the voice message caption. See formatting
     *     options for more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the voice message
     */
    @JsonCreator
    public InlineQueryResultCachedVoice(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("voice_file_id") String voiceFileId,
            @JsonProperty("title") String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.voiceFileId = voiceFileId;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultCachedVoice of(String id, String voiceFileId, String title) {
        return new InlineQueryResultCachedVoice(InlineQueryResultType.VOICE, id, voiceFileId, title, null, null, null, null, null);
    }

    /**
     * Type of the result, must be voice
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
     * A valid file identifier for the voice message
     */
    public String voiceFileId() {
        return voiceFileId;
    }

    /**
     * Voice message title
     */
    public String title() {
        return title;
    }

    /**
     * Caption, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the voice message caption. See formatting options for more
     * details.
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
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the voice message
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedVoice withId(String id) {
        return new InlineQueryResultCachedVoice(type, id, voiceFileId, title, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVoice withVoiceFileId(String voiceFileId) {
        return new InlineQueryResultCachedVoice(type, id, voiceFileId, title, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVoice withTitle(String title) {
        return new InlineQueryResultCachedVoice(type, id, voiceFileId, title, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVoice withCaption(@Nullable String caption) {
        return new InlineQueryResultCachedVoice(type, id, voiceFileId, title, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVoice withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultCachedVoice(type, id, voiceFileId, title, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVoice withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultCachedVoice(type, id, voiceFileId, title, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVoice withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultCachedVoice(type, id, voiceFileId, title, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedVoice withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultCachedVoice(type, id, voiceFileId, title, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultCachedVoice)) {
            return false;
        }
        InlineQueryResultCachedVoice that = (InlineQueryResultCachedVoice) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.voiceFileId, that.voiceFileId)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.voiceFileId, this.title, this.caption, this.parseMode, this.captionEntities, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedVoice[type=" + this.type
                + ", id=" + this.id
                + ", voiceFileId=" + this.voiceFileId
                + ", title=" + this.title
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
