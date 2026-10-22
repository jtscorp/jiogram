package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to set the score of the specified user in a game message. On success, if the
 * message is not an inline message, the Message is returned, otherwise True is returned. Returns an
 * error, if the new score is not greater than the user's current score in the chat and force is
 * False.
 *
 * @param userId User identifier
 * @param score New score, must be non-negative
 * @param force Pass True if the high score is allowed to decrease. This can be useful when fixing
 *     mistakes or banning cheaters
 * @param disableEditMessage Pass True if the game message should not be automatically edited to
 *     include the current scoreboard
 * @param chatId Required if inline_message_id is not specified. Unique identifier for the target
 *     chat
 * @param messageId Required if inline_message_id is not specified. Identifier of the sent message
 * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of the
 *     inline message
 * @see <a href="https://core.telegram.org/bots/api#setgamescore">setGameScore in the Bot API</a>
 */
public record SetGameScore(
    @JsonProperty("user_id") long userId,
    @JsonProperty("score") long score,
    @JsonProperty("force") @Nullable Boolean force,
    @JsonProperty("disable_edit_message") @Nullable Boolean disableEditMessage,
    @JsonProperty("chat_id") @Nullable Long chatId,
    @JsonProperty("message_id") @Nullable Long messageId,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId
) implements TelegramMethod<Message> {

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
}
