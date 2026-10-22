package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGift;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a unique gift that was sent or received.
 *
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftinfo">UniqueGiftInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UniqueGiftInfo {

    @JsonProperty("gift")
    private final UniqueGift gift;

    @JsonProperty("origin")
    private final String origin;

    @JsonProperty("last_resale_currency")
    private final @Nullable String lastResaleCurrency;

    @JsonProperty("last_resale_amount")
    private final @Nullable Long lastResaleAmount;

    @JsonProperty("owned_gift_id")
    private final @Nullable String ownedGiftId;

    @JsonProperty("transfer_star_count")
    private final @Nullable Long transferStarCount;

    @JsonProperty("next_transfer_date")
    private final @Nullable Long nextTransferDate;

    /**
     * Creates a new {@code UniqueGiftInfo} instance.
     *
     * @param gift Information about the gift
     * @param origin Origin of the gift. Currently, either 'upgrade' for gifts upgraded from regular
     *     gifts, 'transfer' for gifts transferred from other users or channels, 'resale' for gifts
     *     bought from other users, 'gifted_upgrade' for upgrades purchased after the gift was sent,
     *     or 'offer' for gifts bought or sold through gift purchase offers
     * @param lastResaleCurrency For gifts bought from other users, the currency in which the
     *     payment for the gift was done. Currently, one of 'XTR' for Telegram Stars or 'TON' for
     *     toncoins.
     * @param lastResaleAmount For gifts bought from other users, the price paid for the gift in
     *     either Telegram Stars or nanotoncoins
     * @param ownedGiftId Unique identifier of the received gift for the bot; only present for gifts
     *     received on behalf of business accounts
     * @param transferStarCount Number of Telegram Stars that must be paid to transfer the gift;
     *     omitted if the bot cannot transfer the gift
     * @param nextTransferDate Point in time (Unix timestamp) when the gift can be transferred. If
     *     it is in the past, then the gift can be transferred now
     */
    @JsonCreator
    public UniqueGiftInfo(
            @JsonProperty("gift") UniqueGift gift,
            @JsonProperty("origin") String origin,
            @JsonProperty("last_resale_currency") @Nullable String lastResaleCurrency,
            @JsonProperty("last_resale_amount") @Nullable Long lastResaleAmount,
            @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
            @JsonProperty("transfer_star_count") @Nullable Long transferStarCount,
            @JsonProperty("next_transfer_date") @Nullable Long nextTransferDate) {
        this.gift = gift;
        this.origin = origin;
        this.lastResaleCurrency = lastResaleCurrency;
        this.lastResaleAmount = lastResaleAmount;
        this.ownedGiftId = ownedGiftId;
        this.transferStarCount = transferStarCount;
        this.nextTransferDate = nextTransferDate;
    }

    public static UniqueGiftInfo of(UniqueGift gift, String origin) {
        return new UniqueGiftInfo(gift, origin, null, null, null, null, null);
    }

    /**
     * Information about the gift
     */
    public UniqueGift gift() {
        return gift;
    }

    /**
     * Origin of the gift. Currently, either 'upgrade' for gifts upgraded from regular gifts,
     * 'transfer' for gifts transferred from other users or channels, 'resale' for gifts bought from
     * other users, 'gifted_upgrade' for upgrades purchased after the gift was sent, or 'offer' for
     * gifts bought or sold through gift purchase offers
     */
    public String origin() {
        return origin;
    }

    /**
     * For gifts bought from other users, the currency in which the payment for the gift was done.
     * Currently, one of 'XTR' for Telegram Stars or 'TON' for toncoins.
     */
    public @Nullable String lastResaleCurrency() {
        return lastResaleCurrency;
    }

    /**
     * For gifts bought from other users, the price paid for the gift in either Telegram Stars or
     * nanotoncoins
     */
    public @Nullable Long lastResaleAmount() {
        return lastResaleAmount;
    }

    /**
     * Unique identifier of the received gift for the bot; only present for gifts received on behalf
     * of business accounts
     */
    public @Nullable String ownedGiftId() {
        return ownedGiftId;
    }

    /**
     * Number of Telegram Stars that must be paid to transfer the gift; omitted if the bot cannot
     * transfer the gift
     */
    public @Nullable Long transferStarCount() {
        return transferStarCount;
    }

    /**
     * Point in time (Unix timestamp) when the gift can be transferred. If it is in the past, then
     * the gift can be transferred now
     */
    public @Nullable Long nextTransferDate() {
        return nextTransferDate;
    }

    public UniqueGiftInfo withGift(UniqueGift gift) {
        return new UniqueGiftInfo(gift, origin, lastResaleCurrency, lastResaleAmount, ownedGiftId, transferStarCount, nextTransferDate);
    }

    public UniqueGiftInfo withOrigin(String origin) {
        return new UniqueGiftInfo(gift, origin, lastResaleCurrency, lastResaleAmount, ownedGiftId, transferStarCount, nextTransferDate);
    }

    public UniqueGiftInfo withLastResaleCurrency(@Nullable String lastResaleCurrency) {
        return new UniqueGiftInfo(gift, origin, lastResaleCurrency, lastResaleAmount, ownedGiftId, transferStarCount, nextTransferDate);
    }

    public UniqueGiftInfo withLastResaleAmount(@Nullable Long lastResaleAmount) {
        return new UniqueGiftInfo(gift, origin, lastResaleCurrency, lastResaleAmount, ownedGiftId, transferStarCount, nextTransferDate);
    }

    public UniqueGiftInfo withOwnedGiftId(@Nullable String ownedGiftId) {
        return new UniqueGiftInfo(gift, origin, lastResaleCurrency, lastResaleAmount, ownedGiftId, transferStarCount, nextTransferDate);
    }

    public UniqueGiftInfo withTransferStarCount(@Nullable Long transferStarCount) {
        return new UniqueGiftInfo(gift, origin, lastResaleCurrency, lastResaleAmount, ownedGiftId, transferStarCount, nextTransferDate);
    }

    public UniqueGiftInfo withNextTransferDate(@Nullable Long nextTransferDate) {
        return new UniqueGiftInfo(gift, origin, lastResaleCurrency, lastResaleAmount, ownedGiftId, transferStarCount, nextTransferDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniqueGiftInfo)) {
            return false;
        }
        UniqueGiftInfo that = (UniqueGiftInfo) o;
        return Objects.equals(this.gift, that.gift)
                && Objects.equals(this.origin, that.origin)
                && Objects.equals(this.lastResaleCurrency, that.lastResaleCurrency)
                && Objects.equals(this.lastResaleAmount, that.lastResaleAmount)
                && Objects.equals(this.ownedGiftId, that.ownedGiftId)
                && Objects.equals(this.transferStarCount, that.transferStarCount)
                && Objects.equals(this.nextTransferDate, that.nextTransferDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.gift, this.origin, this.lastResaleCurrency, this.lastResaleAmount, this.ownedGiftId, this.transferStarCount, this.nextTransferDate);
    }

    @Override
    public String toString() {
        return "UniqueGiftInfo[gift=" + this.gift
                + ", origin=" + this.origin
                + ", lastResaleCurrency=" + this.lastResaleCurrency
                + ", lastResaleAmount=" + this.lastResaleAmount
                + ", ownedGiftId=" + this.ownedGiftId
                + ", transferStarCount=" + this.transferStarCount
                + ", nextTransferDate=" + this.nextTransferDate
                + "]";
    }
}
