package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.GameHighScore;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

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
