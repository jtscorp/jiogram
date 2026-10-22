package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Contains information about the affiliate that received a commission via this transaction.
 *
 * @param affiliateUser The bot or the user that received an affiliate commission if it was received
 *     by a bot or a user
 * @param affiliateChat The chat that received an affiliate commission if it was received by a chat
 * @param commissionPerMille The number of Telegram Stars received by the affiliate for each 1000
 *     Telegram Stars received by the bot from referred users
 * @param amount Integer amount of Telegram Stars received by the affiliate from the transaction,
 *     rounded to 0; can be negative for refunds
 * @param nanostarAmount The number of 1/1000000000 shares of Telegram Stars received by the
 *     affiliate; from -999999999 to 999999999; can be negative for refunds
 * @see <a href="https://core.telegram.org/bots/api#affiliateinfo">AffiliateInfo in the Bot API</a>
 */
public record AffiliateInfo(
    @JsonProperty("affiliate_user") @Nullable User affiliateUser,
    @JsonProperty("affiliate_chat") @Nullable Chat affiliateChat,
    @JsonProperty("commission_per_mille") long commissionPerMille,
    @JsonProperty("amount") long amount,
    @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount
) {}
