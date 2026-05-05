package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class SendMessageDraft implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final long chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("draft_id") private final long draftId;
    @JsonProperty("text") private final String text;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("entities") @Nullable private final List<MessageEntity> entities;

    @JsonCreator
    public SendMessageDraft(
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("draft_id") long draftId,
            @JsonProperty("text") String text,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities
    ) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.draftId = draftId;
        this.text = text;
        this.parseMode = parseMode;
        this.entities = entities;
    }

    public long chatId() {
        return this.chatId;
    }

    public Long messageThreadId() {
        return this.messageThreadId;
    }

    public long draftId() {
        return this.draftId;
    }

    public String text() {
        return this.text;
    }

    public ParseMode parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> entities() {
        return this.entities;
    }

    @Override
    public String apiMethod() {
        return "sendMessageDraft";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SendMessageDraft of(long chatId, long draftId, String text) {
        return new SendMessageDraft(chatId, null, draftId, text, null, null);
    }
}
