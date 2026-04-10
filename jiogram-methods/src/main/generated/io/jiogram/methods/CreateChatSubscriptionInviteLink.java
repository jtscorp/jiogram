package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class CreateChatSubscriptionInviteLink implements TelegramMethod<ChatInviteLink> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("name") @Nullable private final String name;
    @JsonProperty("subscription_period") private final long subscriptionPeriod;
    @JsonProperty("subscription_price") private final long subscriptionPrice;

    @JsonCreator
    public CreateChatSubscriptionInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("subscription_period") long subscriptionPeriod,
            @JsonProperty("subscription_price") long subscriptionPrice
    ) {
        this.chatId = chatId;
        this.name = name;
        this.subscriptionPeriod = subscriptionPeriod;
        this.subscriptionPrice = subscriptionPrice;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String name() {
        return this.name;
    }

    public long subscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public long subscriptionPrice() {
        return this.subscriptionPrice;
    }

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
