package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.OwnedGiftType;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a regular gift owned by a user or a chat.
 *
 * @param type Type of the gift, always 'regular'
 * @param gift Information about the regular gift
 * @param ownedGiftId Unique identifier of the gift for the bot; for gifts received on behalf of
 *     business accounts only
 * @param senderUser Sender of the gift if it is a known user
 * @param sendDate Date the gift was sent in Unix time
 * @param text Text of the message that was added to the gift
 * @param entities Special entities that appear in the text
 * @param isPrivate True, if the sender and gift text are shown only to the gift receiver;
 *     otherwise, everyone will be able to see them
 * @param isSaved True, if the gift is displayed on the account's profile page; for gifts received
 *     on behalf of business accounts only
 * @param canBeUpgraded True, if the gift can be upgraded to a unique gift; for gifts received on
 *     behalf of business accounts only
 * @param wasRefunded True, if the gift was refunded and isn't available anymore
 * @param convertStarCount Number of Telegram Stars that can be claimed by the receiver instead of
 *     the gift; omitted if the gift cannot be converted to Telegram Stars; for gifts received on
 *     behalf of business accounts only
 * @param prepaidUpgradeStarCount Number of Telegram Stars that were paid for the ability to upgrade
 *     the gift
 * @param isUpgradeSeparate True, if the gift's upgrade was purchased after the gift was sent; for
 *     gifts received on behalf of business accounts only
 * @param uniqueGiftNumber Unique number reserved for this gift when upgraded. See the number field
 *     in UniqueGift
 * @see <a href="https://core.telegram.org/bots/api#ownedgiftregular">OwnedGiftRegular in the Bot API</a>
 */
public record OwnedGiftRegular(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) OwnedGiftType type,
    @JsonProperty("gift") Gift gift,
    @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
    @JsonProperty("sender_user") @Nullable User senderUser,
    @JsonProperty("send_date") long sendDate,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("entities") @Nullable List<MessageEntity> entities,
    @JsonProperty("is_private") @Nullable Boolean isPrivate,
    @JsonProperty("is_saved") @Nullable Boolean isSaved,
    @JsonProperty("can_be_upgraded") @Nullable Boolean canBeUpgraded,
    @JsonProperty("was_refunded") @Nullable Boolean wasRefunded,
    @JsonProperty("convert_star_count") @Nullable Long convertStarCount,
    @JsonProperty("prepaid_upgrade_star_count") @Nullable Long prepaidUpgradeStarCount,
    @JsonProperty("is_upgrade_separate") @Nullable Boolean isUpgradeSeparate,
    @JsonProperty("unique_gift_number") @Nullable Long uniqueGiftNumber
) implements OwnedGift {

    public OwnedGiftRegular withGift(Gift gift) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withOwnedGiftId(@Nullable String ownedGiftId) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withSenderUser(@Nullable User senderUser) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withSendDate(long sendDate) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withText(@Nullable String text) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withEntities(@Nullable List<MessageEntity> entities) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withIsPrivate(@Nullable Boolean isPrivate) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withIsSaved(@Nullable Boolean isSaved) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withCanBeUpgraded(@Nullable Boolean canBeUpgraded) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withWasRefunded(@Nullable Boolean wasRefunded) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withConvertStarCount(@Nullable Long convertStarCount) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withPrepaidUpgradeStarCount(@Nullable Long prepaidUpgradeStarCount) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withIsUpgradeSeparate(@Nullable Boolean isUpgradeSeparate) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }

    public OwnedGiftRegular withUniqueGiftNumber(@Nullable Long uniqueGiftNumber) {
        return new OwnedGiftRegular(type, gift, ownedGiftId, senderUser, sendDate, text, entities, isPrivate, isSaved, canBeUpgraded, wasRefunded, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, uniqueGiftNumber);
    }
}
