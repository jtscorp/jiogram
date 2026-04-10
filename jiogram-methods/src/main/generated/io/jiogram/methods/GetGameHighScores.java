package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.GameHighScore;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class GetGameHighScores implements TelegramMethod<List<GameHighScore>> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("chat_id") @Nullable private final Long chatId;
    @JsonProperty("message_id") @Nullable private final Long messageId;
    @JsonProperty("inline_message_id") @Nullable private final String inlineMessageId;

    @JsonCreator
    public GetGameHighScores(
            @JsonProperty("user_id") long userId,
            @JsonProperty("chat_id") @Nullable Long chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId
    ) {
        this.userId = userId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
    }

    public long userId() {
        return this.userId;
    }

    public Long chatId() {
        return this.chatId;
    }

    public Long messageId() {
        return this.messageId;
    }

    public String inlineMessageId() {
        return this.inlineMessageId;
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
}
