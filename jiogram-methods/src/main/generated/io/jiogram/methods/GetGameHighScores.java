package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.GameHighScore;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get data for high score tables. Will return the score of the specified user
 * and several of their neighbors in a game. Returns an Array of GameHighScore objects.
 * <br>This method will currently return scores for the target user, plus two of their closest
 * neighbors on each side. Will also return the top three users if the user and their neighbors are
 * not among them. Please note that this behavior is subject to change.
 *
 * @see <a href="https://core.telegram.org/bots/api#getgamehighscores">getGameHighScores in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetGameHighScores implements TelegramMethod<List<GameHighScore>> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("chat_id")
    private final @Nullable Long chatId;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    /**
     * Creates a new {@code GetGameHighScores} instance.
     *
     * @param userId Target user id
     * @param chatId Required if inline_message_id is not specified. Unique identifier for the
     *     target chat
     * @param messageId Required if inline_message_id is not specified. Identifier of the sent
     *     message
     * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of
     *     the inline message
     */
    @JsonCreator
    public GetGameHighScores(
            @JsonProperty("user_id") long userId,
            @JsonProperty("chat_id") @Nullable Long chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId) {
        this.userId = userId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
    }

    @Override
    public String apiMethod() {
        return "getGameHighScores";
    }

    @Override
    public String apiReturnType() {
        return "Array of GameHighScore";
    }

    public static GetGameHighScores of(long userId) {
        return new GetGameHighScores(userId, null, null, null);
    }

    /**
     * Target user id
     */
    public long userId() {
        return userId;
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

    public GetGameHighScores withUserId(long userId) {
        return new GetGameHighScores(userId, chatId, messageId, inlineMessageId);
    }

    public GetGameHighScores withChatId(@Nullable Long chatId) {
        return new GetGameHighScores(userId, chatId, messageId, inlineMessageId);
    }

    public GetGameHighScores withMessageId(@Nullable Long messageId) {
        return new GetGameHighScores(userId, chatId, messageId, inlineMessageId);
    }

    public GetGameHighScores withInlineMessageId(@Nullable String inlineMessageId) {
        return new GetGameHighScores(userId, chatId, messageId, inlineMessageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetGameHighScores)) {
            return false;
        }
        GetGameHighScores that = (GetGameHighScores) o;
        return this.userId == that.userId
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageId, that.messageId)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.chatId, this.messageId, this.inlineMessageId);
    }

    @Override
    public String toString() {
        return "GetGameHighScores[userId=" + this.userId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", inlineMessageId=" + this.inlineMessageId
                + "]";
    }
}
