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
 * Represents a link to a voice recording in an .OGG container encoded with OPUS. By default, this
 * voice recording will be sent by the user. Alternatively, you can use input_message_content to
 * send a message with the specified content instead of the the voice message.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultvoice">InlineQueryResultVoice in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultVoice implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("voice_url")
    private final String voiceUrl;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("voice_duration")
    private final @Nullable Long voiceDuration;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    /**
     * Creates a new {@code InlineQueryResultVoice} instance.
     *
     * @param type Type of the result, must be voice
     * @param id Unique identifier for this result, 1-64 bytes
     * @param voiceUrl A valid URL for the voice recording
     * @param title Recording title
     * @param caption Caption, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the voice message caption. See formatting
     *     options for more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param voiceDuration Recording duration in seconds
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the voice recording
     */
    @JsonCreator
    public InlineQueryResultVoice(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("voice_url") String voiceUrl,
            @JsonProperty("title") String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("voice_duration") @Nullable Long voiceDuration,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.voiceUrl = voiceUrl;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.voiceDuration = voiceDuration;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultVoice of(String id, String voiceUrl, String title) {
        return new InlineQueryResultVoice(InlineQueryResultType.VOICE, id, voiceUrl, title, null, null, null, null, null, null);
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
     * A valid URL for the voice recording
     */
    public String voiceUrl() {
        return voiceUrl;
    }

    /**
     * Recording title
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
     * Recording duration in seconds
     */
    public @Nullable Long voiceDuration() {
        return voiceDuration;
    }

    /**
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the voice recording
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultVoice withId(String id) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVoice withVoiceUrl(String voiceUrl) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVoice withTitle(String title) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVoice withCaption(@Nullable String caption) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVoice withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVoice withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVoice withVoiceDuration(@Nullable Long voiceDuration) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVoice withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultVoice withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultVoice(type, id, voiceUrl, title, caption, parseMode, captionEntities, voiceDuration, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultVoice)) {
            return false;
        }
        InlineQueryResultVoice that = (InlineQueryResultVoice) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.voiceUrl, that.voiceUrl)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.voiceDuration, that.voiceDuration)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.voiceUrl, this.title, this.caption, this.parseMode, this.captionEntities, this.voiceDuration, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultVoice[type=" + this.type
                + ", id=" + this.id
                + ", voiceUrl=" + this.voiceUrl
                + ", title=" + this.title
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", voiceDuration=" + this.voiceDuration
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
