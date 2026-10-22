package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Upgrades a given regular gift to a unique gift. Requires the can_transfer_and_upgrade_gifts
 * business bot right. Additionally requires the can_transfer_stars business bot right if the
 * upgrade is paid. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#upgradegift">upgradeGift in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UpgradeGift implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("owned_gift_id")
    private final String ownedGiftId;

    @JsonProperty("keep_original_details")
    private final @Nullable Boolean keepOriginalDetails;

    @JsonProperty("star_count")
    private final @Nullable Long starCount;

    /**
     * Creates a new {@code UpgradeGift} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param ownedGiftId Unique identifier of the regular gift that should be upgraded to a unique
     *     one
     * @param keepOriginalDetails Pass True to keep the original gift text, sender and receiver in
     *     the upgraded gift
     * @param starCount The amount of Telegram Stars that will be paid for the upgrade from the
     *     business account balance. If gift.prepaid_upgrade_star_count &gt; 0, then pass 0,
     *     otherwise, the can_transfer_stars business bot right is required and
     *     gift.upgrade_star_count must be passed.
     */
    @JsonCreator
    public UpgradeGift(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("owned_gift_id") String ownedGiftId,
            @JsonProperty("keep_original_details") @Nullable Boolean keepOriginalDetails,
            @JsonProperty("star_count") @Nullable Long starCount) {
        this.businessConnectionId = businessConnectionId;
        this.ownedGiftId = ownedGiftId;
        this.keepOriginalDetails = keepOriginalDetails;
        this.starCount = starCount;
    }

    @Override
    public String apiMethod() {
        return "upgradeGift";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static UpgradeGift of(String businessConnectionId, String ownedGiftId) {
        return new UpgradeGift(businessConnectionId, ownedGiftId, null, null);
    }

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier of the regular gift that should be upgraded to a unique one
     */
    public String ownedGiftId() {
        return ownedGiftId;
    }

    /**
     * Pass True to keep the original gift text, sender and receiver in the upgraded gift
     */
    public @Nullable Boolean keepOriginalDetails() {
        return keepOriginalDetails;
    }

    /**
     * The amount of Telegram Stars that will be paid for the upgrade from the business account
     * balance. If gift.prepaid_upgrade_star_count &gt; 0, then pass 0, otherwise, the
     * can_transfer_stars business bot right is required and gift.upgrade_star_count must be passed.
     */
    public @Nullable Long starCount() {
        return starCount;
    }

    public UpgradeGift withBusinessConnectionId(String businessConnectionId) {
        return new UpgradeGift(businessConnectionId, ownedGiftId, keepOriginalDetails, starCount);
    }

    public UpgradeGift withOwnedGiftId(String ownedGiftId) {
        return new UpgradeGift(businessConnectionId, ownedGiftId, keepOriginalDetails, starCount);
    }

    public UpgradeGift withKeepOriginalDetails(@Nullable Boolean keepOriginalDetails) {
        return new UpgradeGift(businessConnectionId, ownedGiftId, keepOriginalDetails, starCount);
    }

    public UpgradeGift withStarCount(@Nullable Long starCount) {
        return new UpgradeGift(businessConnectionId, ownedGiftId, keepOriginalDetails, starCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UpgradeGift)) {
            return false;
        }
        UpgradeGift that = (UpgradeGift) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.ownedGiftId, that.ownedGiftId)
                && Objects.equals(this.keepOriginalDetails, that.keepOriginalDetails)
                && Objects.equals(this.starCount, that.starCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.ownedGiftId, this.keepOriginalDetails, this.starCount);
    }

    @Override
    public String toString() {
        return "UpgradeGift[businessConnectionId=" + this.businessConnectionId
                + ", ownedGiftId=" + this.ownedGiftId
                + ", keepOriginalDetails=" + this.keepOriginalDetails
                + ", starCount=" + this.starCount
                + "]";
    }
}
