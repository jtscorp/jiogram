package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to stream a partial message to a user while the message is being generated.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendmessagedraft">sendMessageDraft in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendMessageDraft implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final long chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("draft_id")
    private final long draftId;

    @JsonProperty("text")
    private final String text;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("entities")
    private final @Nullable List<MessageEntity> entities;

    /**
     * Creates a new {@code SendMessageDraft} instance.
     *
     * @param chatId Unique identifier for the target private chat
     * @param messageThreadId Unique identifier for the target message thread
     * @param draftId Unique identifier of the message draft; must be non-zero. Changes of drafts
     *     with the same identifier are animated
     * @param text Text of the message to be sent, 1-4096 characters after entities parsing
     * @param parseMode Mode for parsing entities in the message text. See formatting options for
     *     more details.
     * @param entities A JSON-serialized list of special entities that appear in message text, which
     *     can be specified instead of parse_mode
     */
    @JsonCreator
    public SendMessageDraft(
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("draft_id") long draftId,
            @JsonProperty("text") String text,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.draftId = draftId;
        this.text = text;
        this.parseMode = parseMode;
        this.entities = entities;
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

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendMessageDraft answer(Message message, long draftId, String text) {
        return new SendMessageDraft(message.chat().id(), ReplyTarget.messageThreadId(message), draftId, text, null, null);
    }

    /**
     * Unique identifier for the target private chat
     */
    public long chatId() {
        return chatId;
    }

    /**
     * Unique identifier for the target message thread
     */
    public @Nullable Long messageThreadId() {
        return messageThreadId;
    }

    /**
     * Unique identifier of the message draft; must be non-zero. Changes of drafts with the same
     * identifier are animated
     */
    public long draftId() {
        return draftId;
    }

    /**
     * Text of the message to be sent, 1-4096 characters after entities parsing
     */
    public String text() {
        return text;
    }

    /**
     * Mode for parsing entities in the message text. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * A JSON-serialized list of special entities that appear in message text, which can be
     * specified instead of parse_mode
     */
    public @Nullable List<MessageEntity> entities() {
        return entities;
    }

    public SendMessageDraft withChatId(long chatId) {
        return new SendMessageDraft(chatId, messageThreadId, draftId, text, parseMode, entities);
    }

    public SendMessageDraft withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendMessageDraft(chatId, messageThreadId, draftId, text, parseMode, entities);
    }

    public SendMessageDraft withDraftId(long draftId) {
        return new SendMessageDraft(chatId, messageThreadId, draftId, text, parseMode, entities);
    }

    public SendMessageDraft withText(String text) {
        return new SendMessageDraft(chatId, messageThreadId, draftId, text, parseMode, entities);
    }

    public SendMessageDraft withParseMode(@Nullable ParseMode parseMode) {
        return new SendMessageDraft(chatId, messageThreadId, draftId, text, parseMode, entities);
    }

    public SendMessageDraft withEntities(@Nullable List<MessageEntity> entities) {
        return new SendMessageDraft(chatId, messageThreadId, draftId, text, parseMode, entities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendMessageDraft)) {
            return false;
        }
        SendMessageDraft that = (SendMessageDraft) o;
        return this.chatId == that.chatId
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && this.draftId == that.draftId
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.entities, that.entities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageThreadId, this.draftId, this.text, this.parseMode, this.entities);
    }

    @Override
    public String toString() {
        return "SendMessageDraft[chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", draftId=" + this.draftId
                + ", text=" + this.text
                + ", parseMode=" + this.parseMode
                + ", entities=" + this.entities
                + "]";
    }
}
