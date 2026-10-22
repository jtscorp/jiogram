package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.GameHighScore;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to get data for high score tables. Will return the score of the specified user
 * and several of their neighbors in a game. Returns an Array of GameHighScore objects.
 * <br>This method will currently return scores for the target user, plus two of their closest
 * neighbors on each side. Will also return the top three users if the user and their neighbors are
 * not among them. Please note that this behavior is subject to change.
 *
 * @param userId Target user id
 * @param chatId Required if inline_message_id is not specified. Unique identifier for the target
 *     chat
 * @param messageId Required if inline_message_id is not specified. Identifier of the sent message
 * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of the
 *     inline message
 * @see <a href="https://core.telegram.org/bots/api#getgamehighscores">getGameHighScores in the Bot API</a>
 */
public record GetGameHighScores(
    @JsonProperty("user_id") long userId,
    @JsonProperty("chat_id") @Nullable Long chatId,
    @JsonProperty("message_id") @Nullable Long messageId,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId
) implements TelegramMethod<List<GameHighScore>> {

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
}
