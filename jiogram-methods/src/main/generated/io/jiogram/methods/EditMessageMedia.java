package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputMedia;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
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
 * @see <a href="https://core.telegram.org/bots/api#editmessagemedia">editMessageMedia in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditMessageMedia implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final @Nullable ChatId chatId;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    @JsonProperty("media")
    private final InputMedia media;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code EditMessageMedia} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message to be edited was sent
     * @param chatId Required if inline_message_id is not specified. Unique identifier for the
     *     target chat or username of the target channel (in the format &#64;channelusername)
     * @param messageId Required if inline_message_id is not specified. Identifier of the message to
     *     edit
     * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of
     *     the inline message
     * @param media A JSON-serialized object for a new media content of the message
     * @param replyMarkup A JSON-serialized object for a new inline keyboard.
     */
    @JsonCreator
    public EditMessageMedia(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("media") InputMedia media,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.media = media;
        this.replyMarkup = replyMarkup;
    }

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
     * A JSON-serialized object for a new media content of the message
     */
    public InputMedia media() {
        return media;
    }

    /**
     * A JSON-serialized object for a new inline keyboard.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public EditMessageMedia withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new EditMessageMedia(businessConnectionId, chatId, messageId, inlineMessageId, media, replyMarkup);
    }

    public EditMessageMedia withChatId(@Nullable ChatId chatId) {
        return new EditMessageMedia(businessConnectionId, chatId, messageId, inlineMessageId, media, replyMarkup);
    }

    public EditMessageMedia withMessageId(@Nullable Long messageId) {
        return new EditMessageMedia(businessConnectionId, chatId, messageId, inlineMessageId, media, replyMarkup);
    }

    public EditMessageMedia withInlineMessageId(@Nullable String inlineMessageId) {
        return new EditMessageMedia(businessConnectionId, chatId, messageId, inlineMessageId, media, replyMarkup);
    }

    public EditMessageMedia withMedia(InputMedia media) {
        return new EditMessageMedia(businessConnectionId, chatId, messageId, inlineMessageId, media, replyMarkup);
    }

    public EditMessageMedia withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new EditMessageMedia(businessConnectionId, chatId, messageId, inlineMessageId, media, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditMessageMedia)) {
            return false;
        }
        EditMessageMedia that = (EditMessageMedia) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageId, that.messageId)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId)
                && Objects.equals(this.media, that.media)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId, this.inlineMessageId, this.media, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "EditMessageMedia[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", inlineMessageId=" + this.inlineMessageId
                + ", media=" + this.media
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
