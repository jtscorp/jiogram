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
 * Represents a link to a voice message stored on the Telegram servers. By default, this voice
 * message will be sent by the user. Alternatively, you can use input_message_content to send a
 * message with the specified content instead of the voice message.
 *
 * @param type Type of the result, must be voice
 * @param id Unique identifier for this result, 1-64 bytes
 * @param voiceFileId A valid file identifier for the voice message
 * @param title Voice message title
 * @param caption Caption, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the voice message caption. See formatting options
 *     for more details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the voice message
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedvoice">InlineQueryResultCachedVoice in the Bot API</a>
 */
public record InlineQueryResultCachedVoice(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("voice_file_id") String voiceFileId,
    @JsonProperty("title") String title,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {}
