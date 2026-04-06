package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

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
}
