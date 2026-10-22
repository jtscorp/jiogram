package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGiftType;
import io.jiogram.types.UniqueGift;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a unique gift received and owned by a user or a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#ownedgiftunique">OwnedGiftUnique in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class OwnedGiftUnique implements OwnedGift {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final OwnedGiftType type;

    @JsonProperty("gift")
    private final UniqueGift gift;

    @JsonProperty("owned_gift_id")
    private final @Nullable String ownedGiftId;

    @JsonProperty("sender_user")
    private final @Nullable User senderUser;

    @JsonProperty("send_date")
    private final long sendDate;

    @JsonProperty("is_saved")
    private final @Nullable Boolean isSaved;

    @JsonProperty("can_be_transferred")
    private final @Nullable Boolean canBeTransferred;

    @JsonProperty("transfer_star_count")
    private final @Nullable Long transferStarCount;

    @JsonProperty("next_transfer_date")
    private final @Nullable Long nextTransferDate;

    /**
     * Creates a new {@code OwnedGiftUnique} instance.
     *
     * @param type Type of the gift, always 'unique'
     * @param gift Information about the unique gift
     * @param ownedGiftId Unique identifier of the received gift for the bot; for gifts received on
     *     behalf of business accounts only
     * @param senderUser Sender of the gift if it is a known user
     * @param sendDate Date the gift was sent in Unix time
     * @param isSaved True, if the gift is displayed on the account's profile page; for gifts
     *     received on behalf of business accounts only
     * @param canBeTransferred True, if the gift can be transferred to another owner; for gifts
     *     received on behalf of business accounts only
     * @param transferStarCount Number of Telegram Stars that must be paid to transfer the gift;
     *     omitted if the bot cannot transfer the gift
     * @param nextTransferDate Point in time (Unix timestamp) when the gift can be transferred. If
     *     it is in the past, then the gift can be transferred now
     */
    @JsonCreator
    public OwnedGiftUnique(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) OwnedGiftType type,
            @JsonProperty("gift") UniqueGift gift,
            @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
            @JsonProperty("sender_user") @Nullable User senderUser,
            @JsonProperty("send_date") long sendDate,
            @JsonProperty("is_saved") @Nullable Boolean isSaved,
            @JsonProperty("can_be_transferred") @Nullable Boolean canBeTransferred,
            @JsonProperty("transfer_star_count") @Nullable Long transferStarCount,
            @JsonProperty("next_transfer_date") @Nullable Long nextTransferDate) {
        this.type = type;
        this.gift = gift;
        this.ownedGiftId = ownedGiftId;
        this.senderUser = senderUser;
        this.sendDate = sendDate;
        this.isSaved = isSaved;
        this.canBeTransferred = canBeTransferred;
        this.transferStarCount = transferStarCount;
        this.nextTransferDate = nextTransferDate;
    }

    public static OwnedGiftUnique of(UniqueGift gift, long sendDate) {
        return new OwnedGiftUnique(OwnedGiftType.UNIQUE, gift, null, null, sendDate, null, null, null, null);
    }

    /**
     * Type of the gift, always 'unique'
     */
    public OwnedGiftType type() {
        return type;
    }

    /**
     * Information about the unique gift
     */
    public UniqueGift gift() {
        return gift;
    }

    /**
     * Unique identifier of the received gift for the bot; for gifts received on behalf of business
     * accounts only
     */
    public @Nullable String ownedGiftId() {
        return ownedGiftId;
    }

    /**
     * Sender of the gift if it is a known user
     */
    public @Nullable User senderUser() {
        return senderUser;
    }

    /**
     * Date the gift was sent in Unix time
     */
    public long sendDate() {
        return sendDate;
    }

    /**
     * True, if the gift is displayed on the account's profile page; for gifts received on behalf of
     * business accounts only
     */
    public @Nullable Boolean isSaved() {
        return isSaved;
    }

    /**
     * True, if the gift can be transferred to another owner; for gifts received on behalf of
     * business accounts only
     */
    public @Nullable Boolean canBeTransferred() {
        return canBeTransferred;
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

    public OwnedGiftUnique withGift(UniqueGift gift) {
        return new OwnedGiftUnique(type, gift, ownedGiftId, senderUser, sendDate, isSaved, canBeTransferred, transferStarCount, nextTransferDate);
    }

    public OwnedGiftUnique withOwnedGiftId(@Nullable String ownedGiftId) {
        return new OwnedGiftUnique(type, gift, ownedGiftId, senderUser, sendDate, isSaved, canBeTransferred, transferStarCount, nextTransferDate);
    }

    public OwnedGiftUnique withSenderUser(@Nullable User senderUser) {
        return new OwnedGiftUnique(type, gift, ownedGiftId, senderUser, sendDate, isSaved, canBeTransferred, transferStarCount, nextTransferDate);
    }

    public OwnedGiftUnique withSendDate(long sendDate) {
        return new OwnedGiftUnique(type, gift, ownedGiftId, senderUser, sendDate, isSaved, canBeTransferred, transferStarCount, nextTransferDate);
    }

    public OwnedGiftUnique withIsSaved(@Nullable Boolean isSaved) {
        return new OwnedGiftUnique(type, gift, ownedGiftId, senderUser, sendDate, isSaved, canBeTransferred, transferStarCount, nextTransferDate);
    }

    public OwnedGiftUnique withCanBeTransferred(@Nullable Boolean canBeTransferred) {
        return new OwnedGiftUnique(type, gift, ownedGiftId, senderUser, sendDate, isSaved, canBeTransferred, transferStarCount, nextTransferDate);
    }

    public OwnedGiftUnique withTransferStarCount(@Nullable Long transferStarCount) {
        return new OwnedGiftUnique(type, gift, ownedGiftId, senderUser, sendDate, isSaved, canBeTransferred, transferStarCount, nextTransferDate);
    }

    public OwnedGiftUnique withNextTransferDate(@Nullable Long nextTransferDate) {
        return new OwnedGiftUnique(type, gift, ownedGiftId, senderUser, sendDate, isSaved, canBeTransferred, transferStarCount, nextTransferDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OwnedGiftUnique)) {
            return false;
        }
        OwnedGiftUnique that = (OwnedGiftUnique) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.gift, that.gift)
                && Objects.equals(this.ownedGiftId, that.ownedGiftId)
                && Objects.equals(this.senderUser, that.senderUser)
                && this.sendDate == that.sendDate
                && Objects.equals(this.isSaved, that.isSaved)
                && Objects.equals(this.canBeTransferred, that.canBeTransferred)
                && Objects.equals(this.transferStarCount, that.transferStarCount)
                && Objects.equals(this.nextTransferDate, that.nextTransferDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.gift, this.ownedGiftId, this.senderUser, this.sendDate, this.isSaved, this.canBeTransferred, this.transferStarCount, this.nextTransferDate);
    }

    @Override
    public String toString() {
        return "OwnedGiftUnique[type=" + this.type
                + ", gift=" + this.gift
                + ", ownedGiftId=" + this.ownedGiftId
                + ", senderUser=" + this.senderUser
                + ", sendDate=" + this.sendDate
                + ", isSaved=" + this.isSaved
                + ", canBeTransferred=" + this.canBeTransferred
                + ", transferStarCount=" + this.transferStarCount
                + ", nextTransferDate=" + this.nextTransferDate
                + "]";
    }
}
