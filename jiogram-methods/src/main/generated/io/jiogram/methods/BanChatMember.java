package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class BanChatMember implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("until_date") @Nullable private final Long untilDate;
    @JsonProperty("revoke_messages") @Nullable private final Boolean revokeMessages;

    @JsonCreator
    public BanChatMember(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId,
            @JsonProperty("until_date") @Nullable Long untilDate,
            @JsonProperty("revoke_messages") @Nullable Boolean revokeMessages
    ) {
        this.chatId = chatId;
        this.userId = userId;
        this.untilDate = untilDate;
        this.revokeMessages = revokeMessages;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long userId() {
        return this.userId;
    }

    public Long untilDate() {
        return this.untilDate;
    }

    public Boolean revokeMessages() {
        return this.revokeMessages;
    }

    @Override
    public String apiMethod() {
        return "banChatMember";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static BanChatMember of(ChatId chatId, long userId) {
        return new BanChatMember(chatId, userId, null, null);
    }
}
