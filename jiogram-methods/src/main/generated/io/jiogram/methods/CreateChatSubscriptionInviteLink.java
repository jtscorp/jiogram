package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to create a subscription invite link for a channel chat. The bot must have the
 * can_invite_users administrator rights. The link can be edited using the method
 * editChatSubscriptionInviteLink or revoked using the method revokeChatInviteLink. Returns the new
 * invite link as a ChatInviteLink object.
 *
 * @param chatId Unique identifier for the target channel chat or username of the target channel (in
 *     the format &#64;channelusername)
 * @param name Invite link name; 0-32 characters
 * @param subscriptionPeriod The number of seconds the subscription will be active for before the
 *     next payment. Currently, it must always be 2592000 (30 days).
 * @param subscriptionPrice The amount of Telegram Stars a user must pay initially and after each
 *     subsequent subscription period to be a member of the chat; 1-10000
 * @see <a href="https://core.telegram.org/bots/api#createchatsubscriptioninvitelink">createChatSubscriptionInviteLink in the Bot API</a>
 */
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

    public CreateChatSubscriptionInviteLink withChatId(ChatId chatId) {
        return new CreateChatSubscriptionInviteLink(chatId, name, subscriptionPeriod, subscriptionPrice);
    }

    public CreateChatSubscriptionInviteLink withName(@Nullable String name) {
        return new CreateChatSubscriptionInviteLink(chatId, name, subscriptionPeriod, subscriptionPrice);
    }

    public CreateChatSubscriptionInviteLink withSubscriptionPeriod(long subscriptionPeriod) {
        return new CreateChatSubscriptionInviteLink(chatId, name, subscriptionPeriod, subscriptionPrice);
    }

    public CreateChatSubscriptionInviteLink withSubscriptionPrice(long subscriptionPrice) {
        return new CreateChatSubscriptionInviteLink(chatId, name, subscriptionPeriod, subscriptionPrice);
    }
}
