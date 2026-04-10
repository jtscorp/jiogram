package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class EditMessageText implements TelegramMethod<Message> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") @Nullable private final ChatId chatId;
    @JsonProperty("message_id") @Nullable private final Long messageId;
    @JsonProperty("inline_message_id") @Nullable private final String inlineMessageId;
    @JsonProperty("text") private final String text;
    @JsonProperty("parse_mode") @Nullable private final String parseMode;
    @JsonProperty("entities") @Nullable private final List<MessageEntity> entities;
    @JsonProperty("link_preview_options") @Nullable private final LinkPreviewOptions linkPreviewOptions;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public EditMessageText(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("text") String text,
            @JsonProperty("parse_mode") @Nullable String parseMode,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities,
            @JsonProperty("link_preview_options") @Nullable LinkPreviewOptions linkPreviewOptions,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.text = text;
        this.parseMode = parseMode;
        this.entities = entities;
        this.linkPreviewOptions = linkPreviewOptions;
        this.replyMarkup = replyMarkup;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageId() {
        return this.messageId;
    }

    public String inlineMessageId() {
        return this.inlineMessageId;
    }

    public String text() {
        return this.text;
    }

    public String parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> entities() {
        return this.entities;
    }

    public LinkPreviewOptions linkPreviewOptions() {
        return this.linkPreviewOptions;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "editMessageText";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageText of(String text) {
        return new EditMessageText(null, null, null, null, text, null, null, null, null);
    }
}
