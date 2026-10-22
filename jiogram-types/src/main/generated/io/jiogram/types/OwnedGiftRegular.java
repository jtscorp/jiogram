package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.OwnedGiftType;
import io.jiogram.types.User;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a regular gift owned by a user or a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#ownedgiftregular">OwnedGiftRegular in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class OwnedGiftRegular implements OwnedGift {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final OwnedGiftType type;

    @JsonProperty("gift")
    private final Gift gift;

    @JsonProperty("owned_gift_id")
    private final @Nullable String ownedGiftId;

    @JsonProperty("sender_user")
    private final @Nullable User senderUser;

    @JsonProperty("send_date")
    private final long sendDate;

    @JsonProperty("text")
    private final @Nullable String text;

    @JsonProperty("entities")
    private final @Nullable List<MessageEntity> entities;

    @JsonProperty("is_private")
    private final @Nullable Boolean isPrivate;

    @JsonProperty("is_saved")
    private final @Nullable Boolean isSaved;

    @JsonProperty("can_be_upgraded")
    private final @Nullable Boolean canBeUpgraded;

    @JsonProperty("was_refunded")
    private final @Nullable Boolean wasRefunded;

    @JsonProperty("convert_star_count")
    private final @Nullable Long convertStarCount;

    @JsonProperty("prepaid_upgrade_star_count")
    private final @Nullable Long prepaidUpgradeStarCount;

    @JsonProperty("is_upgrade_separate")
    private final @Nullable Boolean isUpgradeSeparate;

    @JsonProperty("unique_gift_number")
    private final @Nullable Long uniqueGiftNumber;

    /**
     * Creates a new {@code OwnedGiftRegular} instance.
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
     * @param isSaved True, if the gift is displayed on the account's profile page; for gifts
     *     received on behalf of business accounts only
     * @param canBeUpgraded True, if the gift can be upgraded to a unique gift; for gifts received
     *     on behalf of business accounts only
     * @param wasRefunded True, if the gift was refunded and isn't available anymore
     * @param convertStarCount Number of Telegram Stars that can be claimed by the receiver instead
     *     of the gift; omitted if the gift cannot be converted to Telegram Stars; for gifts
     *     received on behalf of business accounts only
     * @param prepaidUpgradeStarCount Number of Telegram Stars that were paid for the ability to
     *     upgrade the gift
     * @param isUpgradeSeparate True, if the gift's upgrade was purchased after the gift was sent;
     *     for gifts received on behalf of business accounts only
     * @param uniqueGiftNumber Unique number reserved for this gift when upgraded. See the number
     *     field in UniqueGift
     */
    @JsonCreator
    public OwnedGiftRegular(
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
            @JsonProperty("unique_gift_number") @Nullable Long uniqueGiftNumber) {
        this.type = type;
        this.gift = gift;
        this.ownedGiftId = ownedGiftId;
        this.senderUser = senderUser;
        this.sendDate = sendDate;
        this.text = text;
        this.entities = entities;
        this.isPrivate = isPrivate;
        this.isSaved = isSaved;
        this.canBeUpgraded = canBeUpgraded;
        this.wasRefunded = wasRefunded;
        this.convertStarCount = convertStarCount;
        this.prepaidUpgradeStarCount = prepaidUpgradeStarCount;
        this.isUpgradeSeparate = isUpgradeSeparate;
        this.uniqueGiftNumber = uniqueGiftNumber;
    }

    public static OwnedGiftRegular of(Gift gift, long sendDate) {
        return new OwnedGiftRegular(OwnedGiftType.REGULAR, gift, null, null, sendDate, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the gift, always 'regular'
     */
    public OwnedGiftType type() {
        return type;
    }

    /**
     * Information about the regular gift
     */
    public Gift gift() {
        return gift;
    }

    /**
     * Unique identifier of the gift for the bot; for gifts received on behalf of business accounts
     * only
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
     * Text of the message that was added to the gift
     */
    public @Nullable String text() {
        return text;
    }

    /**
     * Special entities that appear in the text
     */
    public @Nullable List<MessageEntity> entities() {
        return entities;
    }

    /**
     * True, if the sender and gift text are shown only to the gift receiver; otherwise, everyone
     * will be able to see them
     */
    public @Nullable Boolean isPrivate() {
        return isPrivate;
    }

    /**
     * True, if the gift is displayed on the account's profile page; for gifts received on behalf of
     * business accounts only
     */
    public @Nullable Boolean isSaved() {
        return isSaved;
    }

    /**
     * True, if the gift can be upgraded to a unique gift; for gifts received on behalf of business
     * accounts only
     */
    public @Nullable Boolean canBeUpgraded() {
        return canBeUpgraded;
    }

    /**
     * True, if the gift was refunded and isn't available anymore
     */
    public @Nullable Boolean wasRefunded() {
        return wasRefunded;
    }

    /**
     * Number of Telegram Stars that can be claimed by the receiver instead of the gift; omitted if
     * the gift cannot be converted to Telegram Stars; for gifts received on behalf of business
     * accounts only
     */
    public @Nullable Long convertStarCount() {
        return convertStarCount;
    }

    /**
     * Number of Telegram Stars that were paid for the ability to upgrade the gift
     */
    public @Nullable Long prepaidUpgradeStarCount() {
        return prepaidUpgradeStarCount;
    }

    /**
     * True, if the gift's upgrade was purchased after the gift was sent; for gifts received on
     * behalf of business accounts only
     */
    public @Nullable Boolean isUpgradeSeparate() {
        return isUpgradeSeparate;
    }

    /**
     * Unique number reserved for this gift when upgraded. See the number field in UniqueGift
     */
    public @Nullable Long uniqueGiftNumber() {
        return uniqueGiftNumber;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OwnedGiftRegular)) {
            return false;
        }
        OwnedGiftRegular that = (OwnedGiftRegular) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.gift, that.gift)
                && Objects.equals(this.ownedGiftId, that.ownedGiftId)
                && Objects.equals(this.senderUser, that.senderUser)
                && this.sendDate == that.sendDate
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.entities, that.entities)
                && Objects.equals(this.isPrivate, that.isPrivate)
                && Objects.equals(this.isSaved, that.isSaved)
                && Objects.equals(this.canBeUpgraded, that.canBeUpgraded)
                && Objects.equals(this.wasRefunded, that.wasRefunded)
                && Objects.equals(this.convertStarCount, that.convertStarCount)
                && Objects.equals(this.prepaidUpgradeStarCount, that.prepaidUpgradeStarCount)
                && Objects.equals(this.isUpgradeSeparate, that.isUpgradeSeparate)
                && Objects.equals(this.uniqueGiftNumber, that.uniqueGiftNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.gift, this.ownedGiftId, this.senderUser, this.sendDate, this.text, this.entities, this.isPrivate, this.isSaved, this.canBeUpgraded, this.wasRefunded, this.convertStarCount, this.prepaidUpgradeStarCount, this.isUpgradeSeparate, this.uniqueGiftNumber);
    }

    @Override
    public String toString() {
        return "OwnedGiftRegular[type=" + this.type
                + ", gift=" + this.gift
                + ", ownedGiftId=" + this.ownedGiftId
                + ", senderUser=" + this.senderUser
                + ", sendDate=" + this.sendDate
                + ", text=" + this.text
                + ", entities=" + this.entities
                + ", isPrivate=" + this.isPrivate
                + ", isSaved=" + this.isSaved
                + ", canBeUpgraded=" + this.canBeUpgraded
                + ", wasRefunded=" + this.wasRefunded
                + ", convertStarCount=" + this.convertStarCount
                + ", prepaidUpgradeStarCount=" + this.prepaidUpgradeStarCount
                + ", isUpgradeSeparate=" + this.isUpgradeSeparate
                + ", uniqueGiftNumber=" + this.uniqueGiftNumber
                + "]";
    }
}
