package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Upgrades a given regular gift to a unique gift. Requires the can_transfer_and_upgrade_gifts
 * business bot right. Additionally requires the can_transfer_stars business bot right if the
 * upgrade is paid. Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param ownedGiftId Unique identifier of the regular gift that should be upgraded to a unique one
 * @param keepOriginalDetails Pass True to keep the original gift text, sender and receiver in the
 *     upgraded gift
 * @param starCount The amount of Telegram Stars that will be paid for the upgrade from the business
 *     account balance. If gift.prepaid_upgrade_star_count &gt; 0, then pass 0, otherwise, the
 *     can_transfer_stars business bot right is required and gift.upgrade_star_count must be passed.
 * @see <a href="https://core.telegram.org/bots/api#upgradegift">upgradeGift in the Bot API</a>
 */
public record UpgradeGift(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("owned_gift_id") String ownedGiftId,
    @JsonProperty("keep_original_details") @Nullable Boolean keepOriginalDetails,
    @JsonProperty("star_count") @Nullable Long starCount
) implements TelegramMethod<Boolean> {

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
}
