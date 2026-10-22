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
 * Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio
 * file will be sent by the user. Alternatively, you can use input_message_content to send a message
 * with the specified content instead of the audio.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedaudio">InlineQueryResultCachedAudio in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultCachedAudio implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("audio_file_id")
    private final String audioFileId;

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
     * Creates a new {@code InlineQueryResultCachedAudio} instance.
     *
     * @param type Type of the result, must be audio
     * @param id Unique identifier for this result, 1-64 bytes
     * @param audioFileId A valid file identifier for the audio file
     * @param caption Caption, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the audio caption. See formatting options for
     *     more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the audio
     */
    @JsonCreator
    public InlineQueryResultCachedAudio(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("audio_file_id") String audioFileId,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.audioFileId = audioFileId;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultCachedAudio of(String id, String audioFileId) {
        return new InlineQueryResultCachedAudio(InlineQueryResultType.AUDIO, id, audioFileId, null, null, null, null, null);
    }

    /**
     * Type of the result, must be audio
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
     * A valid file identifier for the audio file
     */
    public String audioFileId() {
        return audioFileId;
    }

    /**
     * Caption, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the audio caption. See formatting options for more details.
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
     * Content of the message to be sent instead of the audio
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedAudio withId(String id) {
        return new InlineQueryResultCachedAudio(type, id, audioFileId, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedAudio withAudioFileId(String audioFileId) {
        return new InlineQueryResultCachedAudio(type, id, audioFileId, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedAudio withCaption(@Nullable String caption) {
        return new InlineQueryResultCachedAudio(type, id, audioFileId, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedAudio withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultCachedAudio(type, id, audioFileId, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedAudio withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultCachedAudio(type, id, audioFileId, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedAudio withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultCachedAudio(type, id, audioFileId, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedAudio withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultCachedAudio(type, id, audioFileId, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultCachedAudio)) {
            return false;
        }
        InlineQueryResultCachedAudio that = (InlineQueryResultCachedAudio) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.audioFileId, that.audioFileId)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.audioFileId, this.caption, this.parseMode, this.captionEntities, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedAudio[type=" + this.type
                + ", id=" + this.id
                + ", audioFileId=" + this.audioFileId
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
