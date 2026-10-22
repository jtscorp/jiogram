package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to stream a partial message to a user while the message is being generated.
 * Returns True on success.
 *
 * @param chatId Unique identifier for the target private chat
 * @param messageThreadId Unique identifier for the target message thread
 * @param draftId Unique identifier of the message draft; must be non-zero. Changes of drafts with
 *     the same identifier are animated
 * @param text Text of the message to be sent, 1-4096 characters after entities parsing
 * @param parseMode Mode for parsing entities in the message text. See formatting options for more
 *     details.
 * @param entities A JSON-serialized list of special entities that appear in message text, which can
 *     be specified instead of parse_mode
 * @see <a href="https://core.telegram.org/bots/api#sendmessagedraft">sendMessageDraft in the Bot API</a>
 */
public record SendMessageDraft(
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("draft_id") long draftId,
    @JsonProperty("text") String text,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
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

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendMessageDraft answer(Message message, long draftId, String text) {
        return new SendMessageDraft(message.chat().id(), ReplyTarget.messageThreadId(message), draftId, text, null, null);
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
}
