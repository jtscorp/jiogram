package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputMedia;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit animation, audio, document, photo, or video messages, or to add media to
 * text messages. If a message is part of a message album, then it can be edited only to an audio
 * for audio albums, only to a document for document albums and to a photo or a video otherwise.
 * When an inline message is edited, a new file can't be uploaded; use a previously uploaded file
 * via its file_id or specify a URL. On success, if the edited message is not an inline message, the
 * edited Message is returned, otherwise True is returned. Note that business messages that were not
 * sent by the bot and do not contain an inline keyboard can only be edited within 48 hours from the
 * time they were sent.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message to be edited was sent
 * @param chatId Required if inline_message_id is not specified. Unique identifier for the target
 *     chat or username of the target channel (in the format &#64;channelusername)
 * @param messageId Required if inline_message_id is not specified. Identifier of the message to
 *     edit
 * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of the
 *     inline message
 * @param media A JSON-serialized object for a new media content of the message
 * @param replyMarkup A JSON-serialized object for a new inline keyboard.
 * @see <a href="https://core.telegram.org/bots/api#editmessagemedia">editMessageMedia in the Bot API</a>
 */
public record EditMessageMedia(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("message_id") @Nullable Long messageId,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("media") InputMedia media,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "editMessageMedia";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageMedia of(InputMedia media) {
        return new EditMessageMedia(null, null, null, null, media, null);
    }
}
