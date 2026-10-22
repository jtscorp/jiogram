package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to an MP3 audio file. By default, this audio file will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content
 * instead of the audio.
 *
 * @param type Type of the result, must be audio
 * @param id Unique identifier for this result, 1-64 bytes
 * @param audioUrl A valid URL for the audio file
 * @param title Title
 * @param caption Caption, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the audio caption. See formatting options for more
 *     details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param performer Performer
 * @param audioDuration Audio duration in seconds
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the audio
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultaudio">InlineQueryResultAudio in the Bot API</a>
 */
public record InlineQueryResultAudio(
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
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {}
