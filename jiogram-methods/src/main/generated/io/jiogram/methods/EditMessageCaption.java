package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit captions of messages. On success, if the edited message is not an inline
 * message, the edited Message is returned, otherwise True is returned. Note that business messages
 * that were not sent by the bot and do not contain an inline keyboard can only be edited within 48
 * hours from the time they were sent.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message to be edited was sent
 * @param chatId Required if inline_message_id is not specified. Unique identifier for the target
 *     chat or username of the target channel (in the format &#64;channelusername)
 * @param messageId Required if inline_message_id is not specified. Identifier of the message to
 *     edit
 * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of the
 *     inline message
 * @param caption New caption of the message, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the message caption. See formatting options for
 *     more details.
 * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
 *     which can be specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media.
 *     Supported only for animation, photo and video messages.
 * @param replyMarkup A JSON-serialized object for an inline keyboard.
 * @see <a href="https://core.telegram.org/bots/api#editmessagecaption">editMessageCaption in the Bot API</a>
 */
public record EditMessageCaption(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("message_id") @Nullable Long messageId,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "editMessageCaption";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageCaption of() {
        return new EditMessageCaption(null, null, null, null, null, null, null, null, null);
    }

    public EditMessageCaption withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }

    public EditMessageCaption withChatId(@Nullable ChatId chatId) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }

    public EditMessageCaption withMessageId(@Nullable Long messageId) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }

    public EditMessageCaption withInlineMessageId(@Nullable String inlineMessageId) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }

    public EditMessageCaption withCaption(@Nullable String caption) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }

    public EditMessageCaption withParseMode(@Nullable ParseMode parseMode) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }

    public EditMessageCaption withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }

    public EditMessageCaption withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }

    public EditMessageCaption withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new EditMessageCaption(businessConnectionId, chatId, messageId, inlineMessageId, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup);
    }
}
