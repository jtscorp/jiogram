package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class ReplyParameters {
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("chat_id") @Nullable private final ChatId chatId;
    @JsonProperty("allow_sending_without_reply") @Nullable private final Boolean allowSendingWithoutReply;
    @JsonProperty("quote") @Nullable private final String quote;
    @JsonProperty("quote_parse_mode") @Nullable private final ParseMode quoteParseMode;
    @JsonProperty("quote_entities") @Nullable private final List<MessageEntity> quoteEntities;
    @JsonProperty("quote_position") @Nullable private final Long quotePosition;
    @JsonProperty("checklist_task_id") @Nullable private final Long checklistTaskId;
    @JsonProperty("poll_option_id") @Nullable private final String pollOptionId;

    @JsonCreator
    public ReplyParameters(
            @JsonProperty("message_id") long messageId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("allow_sending_without_reply") @Nullable Boolean allowSendingWithoutReply,
            @JsonProperty("quote") @Nullable String quote,
            @JsonProperty("quote_parse_mode") @Nullable ParseMode quoteParseMode,
            @JsonProperty("quote_entities") @Nullable List<MessageEntity> quoteEntities,
            @JsonProperty("quote_position") @Nullable Long quotePosition,
            @JsonProperty("checklist_task_id") @Nullable Long checklistTaskId,
            @JsonProperty("poll_option_id") @Nullable String pollOptionId
    ) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.allowSendingWithoutReply = allowSendingWithoutReply;
        this.quote = quote;
        this.quoteParseMode = quoteParseMode;
        this.quoteEntities = quoteEntities;
        this.quotePosition = quotePosition;
        this.checklistTaskId = checklistTaskId;
        this.pollOptionId = pollOptionId;
    }

    public long messageId() {
        return this.messageId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Boolean allowSendingWithoutReply() {
        return this.allowSendingWithoutReply;
    }

    public String quote() {
        return this.quote;
    }

    public ParseMode quoteParseMode() {
        return this.quoteParseMode;
    }

    public List<MessageEntity> quoteEntities() {
        return this.quoteEntities;
    }

    public Long quotePosition() {
        return this.quotePosition;
    }

    public Long checklistTaskId() {
        return this.checklistTaskId;
    }

    public String pollOptionId() {
        return this.pollOptionId;
    }
}
