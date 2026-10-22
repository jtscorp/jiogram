package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be
 * sent by the user. Alternatively, you can use input_message_content to send a message with the
 * specified content instead of the sticker.
 *
 * @param type Type of the result, must be sticker
 * @param id Unique identifier for this result, 1-64 bytes
 * @param stickerFileId A valid file identifier of the sticker
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the sticker
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedsticker">InlineQueryResultCachedSticker in the Bot API</a>
 */
public record InlineQueryResultCachedSticker(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("sticker_file_id") String stickerFileId,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {}
