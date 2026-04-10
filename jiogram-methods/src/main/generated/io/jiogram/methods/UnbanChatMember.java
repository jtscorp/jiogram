package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class UnbanChatMember implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("only_if_banned") @Nullable private final Boolean onlyIfBanned;

    @JsonCreator
    public UnbanChatMember(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("only_if_banned") @Nullable Boolean onlyIfBanned
    ) {
        this.chatId = chatId;
        this.userId = userId;
        this.onlyIfBanned = onlyIfBanned;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long userId() {
        return this.userId;
    }

    public Boolean onlyIfBanned() {
        return this.onlyIfBanned;
    }

    @Override
    public String apiMethod() {
        return "unbanChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static UnbanChatMember of(ChatId chatId, long userId) {
        return new UnbanChatMember(chatId, userId, null);
    }
}
