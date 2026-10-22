package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to set the score of the specified user in a game message. On success, if the
 * message is not an inline message, the Message is returned, otherwise True is returned. Returns an
 * error, if the new score is not greater than the user's current score in the chat and force is
 * False.
 *
 * @see <a href="https://core.telegram.org/bots/api#setgamescore">setGameScore in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetGameScore implements TelegramMethod<Message> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("score")
    private final long score;

    @JsonProperty("force")
    private final @Nullable Boolean force;

    @JsonProperty("disable_edit_message")
    private final @Nullable Boolean disableEditMessage;

    @JsonProperty("chat_id")
    private final @Nullable Long chatId;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    /**
     * Creates a new {@code SetGameScore} instance.
     *
     * @param userId User identifier
     * @param score New score, must be non-negative
     * @param force Pass True if the high score is allowed to decrease. This can be useful when
     *     fixing mistakes or banning cheaters
     * @param disableEditMessage Pass True if the game message should not be automatically edited to
     *     include the current scoreboard
     * @param chatId Required if inline_message_id is not specified. Unique identifier for the
     *     target chat
     * @param messageId Required if inline_message_id is not specified. Identifier of the sent
     *     message
     * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of
     *     the inline message
     */
    @JsonCreator
    public SetGameScore(
            @JsonProperty("user_id") long userId,
            @JsonProperty("score") long score,
            @JsonProperty("force") @Nullable Boolean force,
            @JsonProperty("disable_edit_message") @Nullable Boolean disableEditMessage,
            @JsonProperty("chat_id") @Nullable Long chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId) {
        this.userId = userId;
        this.score = score;
        this.force = force;
        this.disableEditMessage = disableEditMessage;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
    }

    @Override
    public String apiMethod() {
        return "setGameScore";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SetGameScore of(long userId, long score) {
        return new SetGameScore(userId, score, null, null, null, null, null);
    }

    /**
     * User identifier
     */
    public long userId() {
        return userId;
    }

    /**
     * New score, must be non-negative
     */
    public long score() {
        return score;
    }

    /**
     * Pass True if the high score is allowed to decrease. This can be useful when fixing mistakes
     * or banning cheaters
     */
    public @Nullable Boolean force() {
        return force;
    }

    /**
     * Pass True if the game message should not be automatically edited to include the current
     * scoreboard
     */
    public @Nullable Boolean disableEditMessage() {
        return disableEditMessage;
    }

    /**
     * Required if inline_message_id is not specified. Unique identifier for the target chat
     */
    public @Nullable Long chatId() {
        return chatId;
    }

    /**
     * Required if inline_message_id is not specified. Identifier of the sent message
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

    public SetGameScore withUserId(long userId) {
        return new SetGameScore(userId, score, force, disableEditMessage, chatId, messageId, inlineMessageId);
    }

    public SetGameScore withScore(long score) {
        return new SetGameScore(userId, score, force, disableEditMessage, chatId, messageId, inlineMessageId);
    }

    public SetGameScore withForce(@Nullable Boolean force) {
        return new SetGameScore(userId, score, force, disableEditMessage, chatId, messageId, inlineMessageId);
    }

    public SetGameScore withDisableEditMessage(@Nullable Boolean disableEditMessage) {
        return new SetGameScore(userId, score, force, disableEditMessage, chatId, messageId, inlineMessageId);
    }

    public SetGameScore withChatId(@Nullable Long chatId) {
        return new SetGameScore(userId, score, force, disableEditMessage, chatId, messageId, inlineMessageId);
    }

    public SetGameScore withMessageId(@Nullable Long messageId) {
        return new SetGameScore(userId, score, force, disableEditMessage, chatId, messageId, inlineMessageId);
    }

    public SetGameScore withInlineMessageId(@Nullable String inlineMessageId) {
        return new SetGameScore(userId, score, force, disableEditMessage, chatId, messageId, inlineMessageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetGameScore)) {
            return false;
        }
        SetGameScore that = (SetGameScore) o;
        return this.userId == that.userId
                && this.score == that.score
                && Objects.equals(this.force, that.force)
                && Objects.equals(this.disableEditMessage, that.disableEditMessage)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageId, that.messageId)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.score, this.force, this.disableEditMessage, this.chatId, this.messageId, this.inlineMessageId);
    }

    @Override
    public String toString() {
        return "SetGameScore[userId=" + this.userId
                + ", score=" + this.score
                + ", force=" + this.force
                + ", disableEditMessage=" + this.disableEditMessage
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", inlineMessageId=" + this.inlineMessageId
                + "]";
    }
}
