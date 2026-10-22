package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes the affiliate program that issued the affiliate commission received via this
 * transaction.
 *
 * @see <a href="https://core.telegram.org/bots/api#transactionpartneraffiliateprogram">TransactionPartnerAffiliateProgram in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransactionPartnerAffiliateProgram implements TransactionPartner {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final TransactionPartnerType type;

    @JsonProperty("sponsor_user")
    private final @Nullable User sponsorUser;

    @JsonProperty("commission_per_mille")
    private final long commissionPerMille;

    /**
     * Creates a new {@code TransactionPartnerAffiliateProgram} instance.
     *
     * @param type Type of the transaction partner, always 'affiliate_program'
     * @param sponsorUser Information about the bot that sponsored the affiliate program
     * @param commissionPerMille The number of Telegram Stars received by the bot for each 1000
     *     Telegram Stars received by the affiliate program sponsor from referred users
     */
    @JsonCreator
    public TransactionPartnerAffiliateProgram(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
            @JsonProperty("sponsor_user") @Nullable User sponsorUser,
            @JsonProperty("commission_per_mille") long commissionPerMille) {
        this.type = type;
        this.sponsorUser = sponsorUser;
        this.commissionPerMille = commissionPerMille;
    }

    public static TransactionPartnerAffiliateProgram of(long commissionPerMille) {
        return new TransactionPartnerAffiliateProgram(TransactionPartnerType.AFFILIATE_PROGRAM, null, commissionPerMille);
    }

    /**
     * Type of the transaction partner, always 'affiliate_program'
     */
    public TransactionPartnerType type() {
        return type;
    }

    /**
     * Information about the bot that sponsored the affiliate program
     */
    public @Nullable User sponsorUser() {
        return sponsorUser;
    }

    /**
     * The number of Telegram Stars received by the bot for each 1000 Telegram Stars received by the
     * affiliate program sponsor from referred users
     */
    public long commissionPerMille() {
        return commissionPerMille;
    }

    public TransactionPartnerAffiliateProgram withSponsorUser(@Nullable User sponsorUser) {
        return new TransactionPartnerAffiliateProgram(type, sponsorUser, commissionPerMille);
    }

    public TransactionPartnerAffiliateProgram withCommissionPerMille(long commissionPerMille) {
        return new TransactionPartnerAffiliateProgram(type, sponsorUser, commissionPerMille);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionPartnerAffiliateProgram)) {
            return false;
        }
        TransactionPartnerAffiliateProgram that = (TransactionPartnerAffiliateProgram) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.sponsorUser, that.sponsorUser)
                && this.commissionPerMille == that.commissionPerMille;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.sponsorUser, this.commissionPerMille);
    }

    @Override
    public String toString() {
        return "TransactionPartnerAffiliateProgram[type=" + this.type
                + ", sponsorUser=" + this.sponsorUser
                + ", commissionPerMille=" + this.commissionPerMille
                + "]";
    }
}
