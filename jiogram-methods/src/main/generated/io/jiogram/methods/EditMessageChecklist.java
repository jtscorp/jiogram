package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputChecklist;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit a checklist on behalf of a connected business account. On success, the
 * edited Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagechecklist">editMessageChecklist in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditMessageChecklist implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("chat_id")
    private final long chatId;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("checklist")
    private final InputChecklist checklist;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code EditMessageChecklist} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat
     * @param messageId Unique identifier for the target message
     * @param checklist A JSON-serialized object for the new checklist
     * @param replyMarkup A JSON-serialized object for the new inline keyboard for the message
     */
    @JsonCreator
    public EditMessageChecklist(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("checklist") InputChecklist checklist,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.checklist = checklist;
        this.replyMarkup = replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "editMessageChecklist";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageChecklist of(String businessConnectionId, long chatId, long messageId, InputChecklist checklist) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, null);
    }

    /**
     * Unique identifier of the business connection on behalf of which the message will be sent
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier for the target chat
     */
    public long chatId() {
        return chatId;
    }

    /**
     * Unique identifier for the target message
     */
    public long messageId() {
        return messageId;
    }

    /**
     * A JSON-serialized object for the new checklist
     */
    public InputChecklist checklist() {
        return checklist;
    }

    /**
     * A JSON-serialized object for the new inline keyboard for the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public EditMessageChecklist withBusinessConnectionId(String businessConnectionId) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    public EditMessageChecklist withChatId(long chatId) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    public EditMessageChecklist withMessageId(long messageId) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    public EditMessageChecklist withChecklist(InputChecklist checklist) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    public EditMessageChecklist withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditMessageChecklist)) {
            return false;
        }
        EditMessageChecklist that = (EditMessageChecklist) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.chatId == that.chatId
                && this.messageId == that.messageId
                && Objects.equals(this.checklist, that.checklist)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId, this.checklist, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "EditMessageChecklist[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", checklist=" + this.checklist
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
