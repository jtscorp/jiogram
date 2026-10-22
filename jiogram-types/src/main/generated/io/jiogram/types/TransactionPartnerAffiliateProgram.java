package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Describes the affiliate program that issued the affiliate commission received via this
 * transaction.
 *
 * @param type Type of the transaction partner, always 'affiliate_program'
 * @param sponsorUser Information about the bot that sponsored the affiliate program
 * @param commissionPerMille The number of Telegram Stars received by the bot for each 1000 Telegram
 *     Stars received by the affiliate program sponsor from referred users
 * @see <a href="https://core.telegram.org/bots/api#transactionpartneraffiliateprogram">TransactionPartnerAffiliateProgram in the Bot API</a>
 */
public record TransactionPartnerAffiliateProgram(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
    @JsonProperty("sponsor_user") @Nullable User sponsorUser,
    @JsonProperty("commission_per_mille") long commissionPerMille
) implements TransactionPartner {}
