package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record OwnedGiftRegular(
    @JsonProperty("type") String type,
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
) implements OwnedGift {}
