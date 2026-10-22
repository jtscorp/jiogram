package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatInviteLink;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to create a subscription invite link for a channel chat. The bot must have the
 * can_invite_users administrator rights. The link can be edited using the method
 * editChatSubscriptionInviteLink or revoked using the method revokeChatInviteLink. Returns the new
 * invite link as a ChatInviteLink object.
 *
 * @see <a href="https://core.telegram.org/bots/api#createchatsubscriptioninvitelink">createChatSubscriptionInviteLink in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class CreateChatSubscriptionInviteLink implements TelegramMethod<ChatInviteLink> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("name")
    private final @Nullable String name;

    @JsonProperty("subscription_period")
    private final long subscriptionPeriod;

    @JsonProperty("subscription_price")
    private final long subscriptionPrice;

    /**
     * Creates a new {@code CreateChatSubscriptionInviteLink} instance.
     *
     * @param chatId Unique identifier for the target channel chat or username of the target channel
     *     (in the format &#64;channelusername)
     * @param name Invite link name; 0-32 characters
     * @param subscriptionPeriod The number of seconds the subscription will be active for before
     *     the next payment. Currently, it must always be 2592000 (30 days).
     * @param subscriptionPrice The amount of Telegram Stars a user must pay initially and after
     *     each subsequent subscription period to be a member of the chat; 1-10000
     */
    @JsonCreator
    public CreateChatSubscriptionInviteLink(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("subscription_period") long subscriptionPeriod,
            @JsonProperty("subscription_price") long subscriptionPrice) {
        this.chatId = chatId;
        this.name = name;
        this.subscriptionPeriod = subscriptionPeriod;
        this.subscriptionPrice = subscriptionPrice;
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

    /**
     * Unique identifier for the target channel chat or username of the target channel (in the
     * format &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Invite link name; 0-32 characters
     */
    public @Nullable String name() {
        return name;
    }

    /**
     * The number of seconds the subscription will be active for before the next payment. Currently,
     * it must always be 2592000 (30 days).
     */
    public long subscriptionPeriod() {
        return subscriptionPeriod;
    }

    /**
     * The amount of Telegram Stars a user must pay initially and after each subsequent subscription
     * period to be a member of the chat; 1-10000
     */
    public long subscriptionPrice() {
        return subscriptionPrice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreateChatSubscriptionInviteLink)) {
            return false;
        }
        CreateChatSubscriptionInviteLink that = (CreateChatSubscriptionInviteLink) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.name, that.name)
                && this.subscriptionPeriod == that.subscriptionPeriod
                && this.subscriptionPrice == that.subscriptionPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId, this.name, this.subscriptionPeriod, this.subscriptionPrice);
    }

    @Override
    public String toString() {
        return "CreateChatSubscriptionInviteLink[chatId=" + this.chatId
                + ", name=" + this.name
                + ", subscriptionPeriod=" + this.subscriptionPeriod
                + ", subscriptionPrice=" + this.subscriptionPrice
                + "]";
    }
}
