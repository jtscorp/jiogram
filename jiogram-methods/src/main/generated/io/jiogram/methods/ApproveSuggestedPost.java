package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to approve a suggested post in a direct messages chat. The bot must have the
 * 'can_post_messages' administrator right in the corresponding channel chat. Returns True on
 * success.
 *
 * @see <a href="https://core.telegram.org/bots/api#approvesuggestedpost">approveSuggestedPost in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ApproveSuggestedPost implements TelegramMethod<Boolean> {

    @JsonProperty("chat_id")
    private final long chatId;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("send_date")
    private final @Nullable Long sendDate;

    /**
     * Creates a new {@code ApproveSuggestedPost} instance.
     *
     * @param chatId Unique identifier for the target direct messages chat
     * @param messageId Identifier of a suggested post message to approve
     * @param sendDate Point in time (Unix timestamp) when the post is expected to be published;
     *     omit if the date has already been specified when the suggested post was created. If
     *     specified, then the date must be not more than 2678400 seconds (30 days) in the future
     */
    @JsonCreator
    public ApproveSuggestedPost(
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("send_date") @Nullable Long sendDate) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.sendDate = sendDate;
    }

    @Override
    public String apiMethod() {
        return "approveSuggestedPost";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static ApproveSuggestedPost of(long chatId, long messageId) {
        return new ApproveSuggestedPost(chatId, messageId, null);
    }

    /**
     * Unique identifier for the target direct messages chat
     */
    public long chatId() {
        return chatId;
    }

    /**
     * Identifier of a suggested post message to approve
     */
    public long messageId() {
        return messageId;
    }

    /**
     * Point in time (Unix timestamp) when the post is expected to be published; omit if the date
     * has already been specified when the suggested post was created. If specified, then the date
     * must be not more than 2678400 seconds (30 days) in the future
     */
    public @Nullable Long sendDate() {
        return sendDate;
    }

    public ApproveSuggestedPost withChatId(long chatId) {
        return new ApproveSuggestedPost(chatId, messageId, sendDate);
    }

    public ApproveSuggestedPost withMessageId(long messageId) {
        return new ApproveSuggestedPost(chatId, messageId, sendDate);
    }

    public ApproveSuggestedPost withSendDate(@Nullable Long sendDate) {
        return new ApproveSuggestedPost(chatId, messageId, sendDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApproveSuggestedPost)) {
            return false;
        }
        ApproveSuggestedPost that = (ApproveSuggestedPost) o;
        return this.chatId == that.chatId
                && this.messageId == that.messageId
                && Objects.equals(this.sendDate, that.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.messageId, this.sendDate);
    }

    @Override
    public String toString() {
        return "ApproveSuggestedPost[chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", sendDate=" + this.sendDate
                + "]";
    }
}
