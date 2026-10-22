package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGift;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a unique gift that was sent or received.
 *
 * @param gift Information about the gift
 * @param origin Origin of the gift. Currently, either 'upgrade' for gifts upgraded from regular
 *     gifts, 'transfer' for gifts transferred from other users or channels, 'resale' for gifts
 *     bought from other users, 'gifted_upgrade' for upgrades purchased after the gift was sent, or
 *     'offer' for gifts bought or sold through gift purchase offers
 * @param lastResaleCurrency For gifts bought from other users, the currency in which the payment
 *     for the gift was done. Currently, one of 'XTR' for Telegram Stars or 'TON' for toncoins.
 * @param lastResaleAmount For gifts bought from other users, the price paid for the gift in either
 *     Telegram Stars or nanotoncoins
 * @param ownedGiftId Unique identifier of the received gift for the bot; only present for gifts
 *     received on behalf of business accounts
 * @param transferStarCount Number of Telegram Stars that must be paid to transfer the gift; omitted
 *     if the bot cannot transfer the gift
 * @param nextTransferDate Point in time (Unix timestamp) when the gift can be transferred. If it is
 *     in the past, then the gift can be transferred now
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftinfo">UniqueGiftInfo in the Bot API</a>
 */
public record UniqueGiftInfo(
    @JsonProperty("gift") UniqueGift gift,
    @JsonProperty("origin") String origin,
    @JsonProperty("last_resale_currency") @Nullable String lastResaleCurrency,
    @JsonProperty("last_resale_amount") @Nullable Long lastResaleAmount,
    @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
    @JsonProperty("transfer_star_count") @Nullable Long transferStarCount,
    @JsonProperty("next_transfer_date") @Nullable Long nextTransferDate
) {}
