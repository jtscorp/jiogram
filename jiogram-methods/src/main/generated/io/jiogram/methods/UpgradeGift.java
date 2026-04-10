package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class UpgradeGift implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("owned_gift_id") private final String ownedGiftId;
    @JsonProperty("keep_original_details") @Nullable private final Boolean keepOriginalDetails;
    @JsonProperty("star_count") @Nullable private final Long starCount;

    @JsonCreator
    public UpgradeGift(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("owned_gift_id") String ownedGiftId,
            @JsonProperty("keep_original_details") @Nullable Boolean keepOriginalDetails,
            @JsonProperty("star_count") @Nullable Long starCount
    ) {
        this.businessConnectionId = businessConnectionId;
        this.ownedGiftId = ownedGiftId;
        this.keepOriginalDetails = keepOriginalDetails;
        this.starCount = starCount;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public String ownedGiftId() {
        return this.ownedGiftId;
    }

    public Boolean keepOriginalDetails() {
        return this.keepOriginalDetails;
    }

    public Long starCount() {
        return this.starCount;
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
}
