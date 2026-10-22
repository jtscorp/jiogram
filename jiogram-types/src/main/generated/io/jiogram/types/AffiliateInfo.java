package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Contains information about the affiliate that received a commission via this transaction.
 *
 * @see <a href="https://core.telegram.org/bots/api#affiliateinfo">AffiliateInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class AffiliateInfo {

    @JsonProperty("affiliate_user")
    private final @Nullable User affiliateUser;

    @JsonProperty("affiliate_chat")
    private final @Nullable Chat affiliateChat;

    @JsonProperty("commission_per_mille")
    private final long commissionPerMille;

    @JsonProperty("amount")
    private final long amount;

    @JsonProperty("nanostar_amount")
    private final @Nullable Long nanostarAmount;

    /**
     * Creates a new {@code AffiliateInfo} instance.
     *
     * @param affiliateUser The bot or the user that received an affiliate commission if it was
     *     received by a bot or a user
     * @param affiliateChat The chat that received an affiliate commission if it was received by a
     *     chat
     * @param commissionPerMille The number of Telegram Stars received by the affiliate for each
     *     1000 Telegram Stars received by the bot from referred users
     * @param amount Integer amount of Telegram Stars received by the affiliate from the
     *     transaction, rounded to 0; can be negative for refunds
     * @param nanostarAmount The number of 1/1000000000 shares of Telegram Stars received by the
     *     affiliate; from -999999999 to 999999999; can be negative for refunds
     */
    @JsonCreator
    public AffiliateInfo(
            @JsonProperty("affiliate_user") @Nullable User affiliateUser,
            @JsonProperty("affiliate_chat") @Nullable Chat affiliateChat,
            @JsonProperty("commission_per_mille") long commissionPerMille,
            @JsonProperty("amount") long amount,
            @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount) {
        this.affiliateUser = affiliateUser;
        this.affiliateChat = affiliateChat;
        this.commissionPerMille = commissionPerMille;
        this.amount = amount;
        this.nanostarAmount = nanostarAmount;
    }

    public static AffiliateInfo of(long commissionPerMille, long amount) {
        return new AffiliateInfo(null, null, commissionPerMille, amount, null);
    }

    /**
     * The bot or the user that received an affiliate commission if it was received by a bot or a
     * user
     */
    public @Nullable User affiliateUser() {
        return affiliateUser;
    }

    /**
     * The chat that received an affiliate commission if it was received by a chat
     */
    public @Nullable Chat affiliateChat() {
        return affiliateChat;
    }

    /**
     * The number of Telegram Stars received by the affiliate for each 1000 Telegram Stars received
     * by the bot from referred users
     */
    public long commissionPerMille() {
        return commissionPerMille;
    }

    /**
     * Integer amount of Telegram Stars received by the affiliate from the transaction, rounded to
     * 0; can be negative for refunds
     */
    public long amount() {
        return amount;
    }

    /**
     * The number of 1/1000000000 shares of Telegram Stars received by the affiliate; from
     * -999999999 to 999999999; can be negative for refunds
     */
    public @Nullable Long nanostarAmount() {
        return nanostarAmount;
    }

    public AffiliateInfo withAffiliateUser(@Nullable User affiliateUser) {
        return new AffiliateInfo(affiliateUser, affiliateChat, commissionPerMille, amount, nanostarAmount);
    }

    public AffiliateInfo withAffiliateChat(@Nullable Chat affiliateChat) {
        return new AffiliateInfo(affiliateUser, affiliateChat, commissionPerMille, amount, nanostarAmount);
    }

    public AffiliateInfo withCommissionPerMille(long commissionPerMille) {
        return new AffiliateInfo(affiliateUser, affiliateChat, commissionPerMille, amount, nanostarAmount);
    }

    public AffiliateInfo withAmount(long amount) {
        return new AffiliateInfo(affiliateUser, affiliateChat, commissionPerMille, amount, nanostarAmount);
    }

    public AffiliateInfo withNanostarAmount(@Nullable Long nanostarAmount) {
        return new AffiliateInfo(affiliateUser, affiliateChat, commissionPerMille, amount, nanostarAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AffiliateInfo)) {
            return false;
        }
        AffiliateInfo that = (AffiliateInfo) o;
        return Objects.equals(this.affiliateUser, that.affiliateUser)
                && Objects.equals(this.affiliateChat, that.affiliateChat)
                && this.commissionPerMille == that.commissionPerMille
                && this.amount == that.amount
                && Objects.equals(this.nanostarAmount, that.nanostarAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.affiliateUser, this.affiliateChat, this.commissionPerMille, this.amount, this.nanostarAmount);
    }

    @Override
    public String toString() {
        return "AffiliateInfo[affiliateUser=" + this.affiliateUser
                + ", affiliateChat=" + this.affiliateChat
                + ", commissionPerMille=" + this.commissionPerMille
                + ", amount=" + this.amount
                + ", nanostarAmount=" + this.nanostarAmount
                + "]";
    }
}
