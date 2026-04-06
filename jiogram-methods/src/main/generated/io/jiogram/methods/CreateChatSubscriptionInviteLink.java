package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record CreateChatSubscriptionInviteLink(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("subscription_period") long subscriptionPeriod,
    @JsonProperty("subscription_price") long subscriptionPrice
) implements TelegramMethod<ChatInviteLink> {

    @Override
    public String apiMethod() {
        return "createChatSubscriptionInviteLink";
    }

    @Override
    public String apiReturnType() {
        return "ChatInviteLink";
    }

    public static CreateChatSubscriptionInviteLink of(ChatId chatId, long subscriptionPeriod, long subscriptionPrice) {
        return new CreateChatSubscriptionInviteLink(chatId, null, subscriptionPeriod, subscriptionPrice);
    }
}
