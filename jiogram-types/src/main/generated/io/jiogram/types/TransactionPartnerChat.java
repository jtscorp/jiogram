package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.Gift;
import io.jiogram.types.TransactionPartnerType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a transaction with a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnerchat">TransactionPartnerChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransactionPartnerChat implements TransactionPartner {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final TransactionPartnerType type;

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("gift")
    private final @Nullable Gift gift;

    /**
     * Creates a new {@code TransactionPartnerChat} instance.
     *
     * @param type Type of the transaction partner, always 'chat'
     * @param chat Information about the chat
     * @param gift The gift sent to the chat by the bot
     */
    @JsonCreator
    public TransactionPartnerChat(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
            @JsonProperty("chat") Chat chat,
            @JsonProperty("gift") @Nullable Gift gift) {
        this.type = type;
        this.chat = chat;
        this.gift = gift;
    }

    public static TransactionPartnerChat of(Chat chat) {
        return new TransactionPartnerChat(TransactionPartnerType.CHAT, chat, null);
    }

    /**
     * Type of the transaction partner, always 'chat'
     */
    public TransactionPartnerType type() {
        return type;
    }

    /**
     * Information about the chat
     */
    public Chat chat() {
        return chat;
    }

    /**
     * The gift sent to the chat by the bot
     */
    public @Nullable Gift gift() {
        return gift;
    }

    public TransactionPartnerChat withChat(Chat chat) {
        return new TransactionPartnerChat(type, chat, gift);
    }

    public TransactionPartnerChat withGift(@Nullable Gift gift) {
        return new TransactionPartnerChat(type, chat, gift);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionPartnerChat)) {
            return false;
        }
        TransactionPartnerChat that = (TransactionPartnerChat) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.chat, that.chat)
                && Objects.equals(this.gift, that.gift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.chat, this.gift);
    }

    @Override
    public String toString() {
        return "TransactionPartnerChat[type=" + this.type
                + ", chat=" + this.chat
                + ", gift=" + this.gift
                + "]";
    }
}
