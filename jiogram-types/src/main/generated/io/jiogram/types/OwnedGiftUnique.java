package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGiftType;
import io.jiogram.types.UniqueGift;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Describes a unique gift received and owned by a user or a chat.
 *
 * @param type Type of the gift, always 'unique'
 * @param gift Information about the unique gift
 * @param ownedGiftId Unique identifier of the received gift for the bot; for gifts received on
 *     behalf of business accounts only
 * @param senderUser Sender of the gift if it is a known user
 * @param sendDate Date the gift was sent in Unix time
 * @param isSaved True, if the gift is displayed on the account's profile page; for gifts received
 *     on behalf of business accounts only
 * @param canBeTransferred True, if the gift can be transferred to another owner; for gifts received
 *     on behalf of business accounts only
 * @param transferStarCount Number of Telegram Stars that must be paid to transfer the gift; omitted
 *     if the bot cannot transfer the gift
 * @param nextTransferDate Point in time (Unix timestamp) when the gift can be transferred. If it is
 *     in the past, then the gift can be transferred now
 * @see <a href="https://core.telegram.org/bots/api#ownedgiftunique">OwnedGiftUnique in the Bot API</a>
 */
public record OwnedGiftUnique(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) OwnedGiftType type,
    @JsonProperty("gift") UniqueGift gift,
    @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
    @JsonProperty("sender_user") @Nullable User senderUser,
    @JsonProperty("send_date") long sendDate,
    @JsonProperty("is_saved") @Nullable Boolean isSaved,
    @JsonProperty("can_be_transferred") @Nullable Boolean canBeTransferred,
    @JsonProperty("transfer_star_count") @Nullable Long transferStarCount,
    @JsonProperty("next_transfer_date") @Nullable Long nextTransferDate
) implements OwnedGift {

    public static OwnedGiftUnique of(UniqueGift gift, long sendDate) {
        return new OwnedGiftUnique(OwnedGiftType.UNIQUE, gift, null, null, sendDate, null, null, null, null);
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
}
