package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record SendMessageDraft(
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("draft_id") long draftId,
    @JsonProperty("text") String text,
    @JsonProperty("parse_mode") @Nullable String parseMode,
    @JsonProperty("entities") @Nullable List<MessageEntity> entities
) implements TelegramMethod<Boolean> {

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
