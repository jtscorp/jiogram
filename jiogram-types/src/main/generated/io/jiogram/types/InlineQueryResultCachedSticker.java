package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be
 * sent by the user. Alternatively, you can use input_message_content to send a message with the
 * specified content instead of the sticker.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedsticker">InlineQueryResultCachedSticker in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultCachedSticker implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("sticker_file_id")
    private final String stickerFileId;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    /**
     * Creates a new {@code InlineQueryResultCachedSticker} instance.
     *
     * @param type Type of the result, must be sticker
     * @param id Unique identifier for this result, 1-64 bytes
     * @param stickerFileId A valid file identifier of the sticker
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the sticker
     */
    @JsonCreator
    public InlineQueryResultCachedSticker(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("sticker_file_id") String stickerFileId,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.stickerFileId = stickerFileId;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultCachedSticker of(String id, String stickerFileId) {
        return new InlineQueryResultCachedSticker(InlineQueryResultType.STICKER, id, stickerFileId, null, null);
    }

    /**
     * Type of the result, must be sticker
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
     * A valid file identifier of the sticker
     */
    public String stickerFileId() {
        return stickerFileId;
    }

    /**
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the sticker
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    public InlineQueryResultCachedSticker withId(String id) {
        return new InlineQueryResultCachedSticker(type, id, stickerFileId, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedSticker withStickerFileId(String stickerFileId) {
        return new InlineQueryResultCachedSticker(type, id, stickerFileId, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedSticker withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultCachedSticker(type, id, stickerFileId, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedSticker withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultCachedSticker(type, id, stickerFileId, replyMarkup, inputMessageContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultCachedSticker)) {
            return false;
        }
        InlineQueryResultCachedSticker that = (InlineQueryResultCachedSticker) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.stickerFileId, that.stickerFileId)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.stickerFileId, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedSticker[type=" + this.type
                + ", id=" + this.id
                + ", stickerFileId=" + this.stickerFileId
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
