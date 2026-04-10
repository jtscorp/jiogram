package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetGameScore implements TelegramMethod<Message> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("score") private final long score;
    @JsonProperty("force") @Nullable private final Boolean force;
    @JsonProperty("disable_edit_message") @Nullable private final Boolean disableEditMessage;
    @JsonProperty("chat_id") @Nullable private final Long chatId;
    @JsonProperty("message_id") @Nullable private final Long messageId;
    @JsonProperty("inline_message_id") @Nullable private final String inlineMessageId;

    @JsonCreator
    public SetGameScore(
            @JsonProperty("user_id") long userId,
            @JsonProperty("score") long score,
            @JsonProperty("force") @Nullable Boolean force,
            @JsonProperty("disable_edit_message") @Nullable Boolean disableEditMessage,
            @JsonProperty("chat_id") @Nullable Long chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId
    ) {
        this.userId = userId;
        this.score = score;
        this.force = force;
        this.disableEditMessage = disableEditMessage;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
    }

    public long userId() {
        return this.userId;
    }

    public long score() {
        return this.score;
    }

    public Boolean force() {
        return this.force;
    }

    public Boolean disableEditMessage() {
        return this.disableEditMessage;
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
