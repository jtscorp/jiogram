package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to decline a suggested post in a direct messages chat. The bot must have the
 * 'can_manage_direct_messages' administrator right in the corresponding channel chat. Returns True
 * on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#declinesuggestedpost">declineSuggestedPost in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeclineSuggestedPost implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final long chatId;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("comment")
    private final @Nullable String comment;

    /**
     * Creates a new {@code DeclineSuggestedPost} instance.
     *
     * @param chatId Unique identifier for the target direct messages chat
     * @param messageId Identifier of a suggested post message to decline
     * @param comment Comment for the creator of the suggested post; 0-128 characters
     */
    @JsonCreator
    public DeclineSuggestedPost(
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("comment") @Nullable String comment) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.comment = comment;
    }

    @Override
    public String apiMethod() {
        return "declineSuggestedPost";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static DeclineSuggestedPost of(long chatId, long messageId) {
        return new DeclineSuggestedPost(chatId, messageId, null);
    }

    /**
     * Unique identifier for the target direct messages chat
     */
    public long chatId() {
        return chatId;
    }

    /**
     * Identifier of a suggested post message to decline
     */
    public long messageId() {
        return messageId;
    }

    /**
     * Comment for the creator of the suggested post; 0-128 characters
     */
    public @Nullable String comment() {
        return comment;
    }

    public DeclineSuggestedPost withChatId(long chatId) {
        return new DeclineSuggestedPost(chatId, messageId, comment);
    }

    public DeclineSuggestedPost withMessageId(long messageId) {
        return new DeclineSuggestedPost(chatId, messageId, comment);
    }

    public DeclineSuggestedPost withComment(@Nullable String comment) {
        return new DeclineSuggestedPost(chatId, messageId, comment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeclineSuggestedPost)) {
            return false;
        }
        DeclineSuggestedPost that = (DeclineSuggestedPost) o;
        return this.chatId == that.chatId
                && this.messageId == that.messageId
                && Objects.equals(this.comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageId, this.comment);
    }

    @Override
    public String toString() {
        return "DeclineSuggestedPost[chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", comment=" + this.comment
                + "]";
    }
}
