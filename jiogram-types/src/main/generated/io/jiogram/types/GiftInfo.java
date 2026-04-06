package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record GiftInfo(
    @JsonProperty("gift") Gift gift,
    @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
    @JsonProperty("convert_star_count") @Nullable Long convertStarCount,
    @JsonProperty("prepaid_upgrade_star_count") @Nullable Long prepaidUpgradeStarCount,
    @JsonProperty("is_upgrade_separate") @Nullable Boolean isUpgradeSeparate,
    @JsonProperty("can_be_upgraded") @Nullable Boolean canBeUpgraded,
    @JsonProperty("text") @Nullable String text,
    @JsonProperty("entities") @Nullable List<MessageEntity> entities,
    @JsonProperty("is_private") @Nullable Boolean isPrivate,
    @JsonProperty("unique_gift_number") @Nullable Long uniqueGiftNumber
) {}
