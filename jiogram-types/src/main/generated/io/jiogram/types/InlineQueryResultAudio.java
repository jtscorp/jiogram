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
 * Represents a link to an MP3 audio file. By default, this audio file will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content
 * instead of the audio.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultaudio">InlineQueryResultAudio in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultAudio implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("audio_url")
    private final String audioUrl;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("performer")
    private final @Nullable String performer;

    @JsonProperty("audio_duration")
    private final @Nullable Long audioDuration;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    /**
     * Creates a new {@code InlineQueryResultAudio} instance.
     *
     * @param type Type of the result, must be audio
     * @param id Unique identifier for this result, 1-64 bytes
     * @param audioUrl A valid URL for the audio file
     * @param title Title
     * @param caption Caption, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the audio caption. See formatting options for
     *     more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param performer Performer
     * @param audioDuration Audio duration in seconds
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the audio
     */
    @JsonCreator
    public InlineQueryResultAudio(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("audio_url") String audioUrl,
            @JsonProperty("title") String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("performer") @Nullable String performer,
            @JsonProperty("audio_duration") @Nullable Long audioDuration,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.audioUrl = audioUrl;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.performer = performer;
        this.audioDuration = audioDuration;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultAudio of(String id, String audioUrl, String title) {
        return new InlineQueryResultAudio(InlineQueryResultType.AUDIO, id, audioUrl, title, null, null, null, null, null, null, null);
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
     * A valid URL for the audio file
     */
    public String audioUrl() {
        return audioUrl;
    }

    /**
     * Title
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
     * Performer
     */
    public @Nullable String performer() {
        return performer;
    }

    /**
     * Audio duration in seconds
     */
    public @Nullable Long audioDuration() {
        return audioDuration;
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

    public InlineQueryResultAudio withId(String id) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withAudioUrl(String audioUrl) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withTitle(String title) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withCaption(@Nullable String caption) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withPerformer(@Nullable String performer) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withAudioDuration(@Nullable Long audioDuration) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultAudio withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultAudio(type, id, audioUrl, title, caption, parseMode, captionEntities, performer, audioDuration, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultAudio)) {
            return false;
        }
        InlineQueryResultAudio that = (InlineQueryResultAudio) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.audioUrl, that.audioUrl)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.performer, that.performer)
                && Objects.equals(this.audioDuration, that.audioDuration)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.audioUrl, this.title, this.caption, this.parseMode, this.captionEntities, this.performer, this.audioDuration, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultAudio[type=" + this.type
                + ", id=" + this.id
                + ", audioUrl=" + this.audioUrl
                + ", title=" + this.title
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", performer=" + this.performer
                + ", audioDuration=" + this.audioDuration
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
