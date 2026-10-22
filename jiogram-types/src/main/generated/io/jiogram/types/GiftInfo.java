package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import io.jiogram.types.MessageEntity;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a regular gift that was sent or received.
 *
 * @see <a href="https://core.telegram.org/bots/api#giftinfo">GiftInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GiftInfo {

    @JsonProperty("gift")
    private final Gift gift;

    @JsonProperty("owned_gift_id")
    private final @Nullable String ownedGiftId;

    @JsonProperty("convert_star_count")
    private final @Nullable Long convertStarCount;

    @JsonProperty("prepaid_upgrade_star_count")
    private final @Nullable Long prepaidUpgradeStarCount;

    @JsonProperty("is_upgrade_separate")
    private final @Nullable Boolean isUpgradeSeparate;

    @JsonProperty("can_be_upgraded")
    private final @Nullable Boolean canBeUpgraded;

    @JsonProperty("text")
    private final @Nullable String text;

    @JsonProperty("entities")
    private final @Nullable List<MessageEntity> entities;

    @JsonProperty("is_private")
    private final @Nullable Boolean isPrivate;

    @JsonProperty("unique_gift_number")
    private final @Nullable Long uniqueGiftNumber;

    /**
     * Creates a new {@code GiftInfo} instance.
     *
     * @param gift Information about the gift
     * @param ownedGiftId Unique identifier of the received gift for the bot; only present for gifts
     *     received on behalf of business accounts
     * @param convertStarCount Number of Telegram Stars that can be claimed by the receiver by
     *     converting the gift; omitted if conversion to Telegram Stars is impossible
     * @param prepaidUpgradeStarCount Number of Telegram Stars that were prepaid for the ability to
     *     upgrade the gift
     * @param isUpgradeSeparate True, if the gift's upgrade was purchased after the gift was sent
     * @param canBeUpgraded True, if the gift can be upgraded to a unique gift
     * @param text Text of the message that was added to the gift
     * @param entities Special entities that appear in the text
     * @param isPrivate True, if the sender and gift text are shown only to the gift receiver;
     *     otherwise, everyone will be able to see them
     * @param uniqueGiftNumber Unique number reserved for this gift when upgraded. See the number
     *     field in UniqueGift
     */
    @JsonCreator
    public GiftInfo(
            @JsonProperty("gift") Gift gift,
            @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
            @JsonProperty("convert_star_count") @Nullable Long convertStarCount,
            @JsonProperty("prepaid_upgrade_star_count") @Nullable Long prepaidUpgradeStarCount,
            @JsonProperty("is_upgrade_separate") @Nullable Boolean isUpgradeSeparate,
            @JsonProperty("can_be_upgraded") @Nullable Boolean canBeUpgraded,
            @JsonProperty("text") @Nullable String text,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities,
            @JsonProperty("is_private") @Nullable Boolean isPrivate,
            @JsonProperty("unique_gift_number") @Nullable Long uniqueGiftNumber) {
        this.gift = gift;
        this.ownedGiftId = ownedGiftId;
        this.convertStarCount = convertStarCount;
        this.prepaidUpgradeStarCount = prepaidUpgradeStarCount;
        this.isUpgradeSeparate = isUpgradeSeparate;
        this.canBeUpgraded = canBeUpgraded;
        this.text = text;
        this.entities = entities;
        this.isPrivate = isPrivate;
        this.uniqueGiftNumber = uniqueGiftNumber;
    }

    public static GiftInfo of(Gift gift) {
        return new GiftInfo(gift, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Information about the gift
     */
    public Gift gift() {
        return gift;
    }

    /**
     * Unique identifier of the received gift for the bot; only present for gifts received on behalf
     * of business accounts
     */
    public @Nullable String ownedGiftId() {
        return ownedGiftId;
    }

    /**
     * Number of Telegram Stars that can be claimed by the receiver by converting the gift; omitted
     * if conversion to Telegram Stars is impossible
     */
    public @Nullable Long convertStarCount() {
        return convertStarCount;
    }

    /**
     * Number of Telegram Stars that were prepaid for the ability to upgrade the gift
     */
    public @Nullable Long prepaidUpgradeStarCount() {
        return prepaidUpgradeStarCount;
    }

    /**
     * True, if the gift's upgrade was purchased after the gift was sent
     */
    public @Nullable Boolean isUpgradeSeparate() {
        return isUpgradeSeparate;
    }

    /**
     * True, if the gift can be upgraded to a unique gift
     */
    public @Nullable Boolean canBeUpgraded() {
        return canBeUpgraded;
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
     * Unique number reserved for this gift when upgraded. See the number field in UniqueGift
     */
    public @Nullable Long uniqueGiftNumber() {
        return uniqueGiftNumber;
    }

    public GiftInfo withGift(Gift gift) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withOwnedGiftId(@Nullable String ownedGiftId) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withConvertStarCount(@Nullable Long convertStarCount) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withPrepaidUpgradeStarCount(@Nullable Long prepaidUpgradeStarCount) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withIsUpgradeSeparate(@Nullable Boolean isUpgradeSeparate) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withCanBeUpgraded(@Nullable Boolean canBeUpgraded) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withText(@Nullable String text) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withEntities(@Nullable List<MessageEntity> entities) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withIsPrivate(@Nullable Boolean isPrivate) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    public GiftInfo withUniqueGiftNumber(@Nullable Long uniqueGiftNumber) {
        return new GiftInfo(gift, ownedGiftId, convertStarCount, prepaidUpgradeStarCount, isUpgradeSeparate, canBeUpgraded, text, entities, isPrivate, uniqueGiftNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GiftInfo)) {
            return false;
        }
        GiftInfo that = (GiftInfo) o;
        return Objects.equals(this.gift, that.gift)
                && Objects.equals(this.ownedGiftId, that.ownedGiftId)
                && Objects.equals(this.convertStarCount, that.convertStarCount)
                && Objects.equals(this.prepaidUpgradeStarCount, that.prepaidUpgradeStarCount)
                && Objects.equals(this.isUpgradeSeparate, that.isUpgradeSeparate)
                && Objects.equals(this.canBeUpgraded, that.canBeUpgraded)
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.entities, that.entities)
                && Objects.equals(this.isPrivate, that.isPrivate)
                && Objects.equals(this.uniqueGiftNumber, that.uniqueGiftNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.gift, this.ownedGiftId, this.convertStarCount, this.prepaidUpgradeStarCount, this.isUpgradeSeparate, this.canBeUpgraded, this.text, this.entities, this.isPrivate, this.uniqueGiftNumber);
    }

    @Override
    public String toString() {
        return "GiftInfo[gift=" + this.gift
                + ", ownedGiftId=" + this.ownedGiftId
                + ", convertStarCount=" + this.convertStarCount
                + ", prepaidUpgradeStarCount=" + this.prepaidUpgradeStarCount
                + ", isUpgradeSeparate=" + this.isUpgradeSeparate
                + ", canBeUpgraded=" + this.canBeUpgraded
                + ", text=" + this.text
                + ", entities=" + this.entities
                + ", isPrivate=" + this.isPrivate
                + ", uniqueGiftNumber=" + this.uniqueGiftNumber
                + "]";
    }
}
