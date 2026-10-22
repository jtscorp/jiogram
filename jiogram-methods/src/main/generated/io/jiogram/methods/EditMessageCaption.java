package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit captions of messages. On success, if the edited message is not an inline
 * message, the edited Message is returned, otherwise True is returned. Note that business messages
 * that were not sent by the bot and do not contain an inline keyboard can only be edited within 48
 * hours from the time they were sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagecaption">editMessageCaption in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditMessageCaption implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final @Nullable ChatId chatId;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("show_caption_above_media")
    private final @Nullable Boolean showCaptionAboveMedia;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code EditMessageCaption} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message to be edited was sent
     * @param chatId Required if inline_message_id is not specified. Unique identifier for the
     *     target chat or username of the target channel (in the format &#64;channelusername)
     * @param messageId Required if inline_message_id is not specified. Identifier of the message to
     *     edit
     * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of
     *     the inline message
     * @param caption New caption of the message, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the message caption. See formatting options for
     *     more details.
     * @param captionEntities A JSON-serialized list of special entities that appear in the caption,
     *     which can be specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media.
     *     Supported only for animation, photo and video messages.
     * @param replyMarkup A JSON-serialized object for an inline keyboard.
     */
    @JsonCreator
    public EditMessageCaption(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.replyMarkup = replyMarkup;
    }

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

    /**
     * Unique identifier of the business connection on behalf of which the message to be edited was
     * sent
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Required if inline_message_id is not specified. Unique identifier for the target chat or
     * username of the target channel (in the format &#64;channelusername)
     */
    public @Nullable ChatId chatId() {
        return chatId;
    }

    /**
     * Required if inline_message_id is not specified. Identifier of the message to edit
     */
    public @Nullable Long messageId() {
        return messageId;
    }

    /**
     * Required if chat_id and message_id are not specified. Identifier of the inline message
     */
    public @Nullable String inlineMessageId() {
        return inlineMessageId;
    }

    /**
     * New caption of the message, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the message caption. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * A JSON-serialized list of special entities that appear in the caption, which can be specified
     * instead of parse_mode
     */
    public @Nullable List<MessageEntity> captionEntities() {
        return captionEntities;
    }

    /**
     * Pass True, if the caption must be shown above the message media. Supported only for
     * animation, photo and video messages.
     */
    public @Nullable Boolean showCaptionAboveMedia() {
        return showCaptionAboveMedia;
    }

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditMessageCaption)) {
            return false;
        }
        EditMessageCaption that = (EditMessageCaption) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageId, that.messageId)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId, this.inlineMessageId, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "EditMessageCaption[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", inlineMessageId=" + this.inlineMessageId
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
