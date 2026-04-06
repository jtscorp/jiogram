package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

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
}
