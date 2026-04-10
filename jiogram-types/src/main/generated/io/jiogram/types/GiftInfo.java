package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class GiftInfo {
    @JsonProperty("gift") private final Gift gift;
    @JsonProperty("owned_gift_id") @Nullable private final String ownedGiftId;
    @JsonProperty("convert_star_count") @Nullable private final Long convertStarCount;
    @JsonProperty("prepaid_upgrade_star_count") @Nullable private final Long prepaidUpgradeStarCount;
    @JsonProperty("is_upgrade_separate") @Nullable private final Boolean isUpgradeSeparate;
    @JsonProperty("can_be_upgraded") @Nullable private final Boolean canBeUpgraded;
    @JsonProperty("text") @Nullable private final String text;
    @JsonProperty("entities") @Nullable private final List<MessageEntity> entities;
    @JsonProperty("is_private") @Nullable private final Boolean isPrivate;
    @JsonProperty("unique_gift_number") @Nullable private final Long uniqueGiftNumber;

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
            @JsonProperty("unique_gift_number") @Nullable Long uniqueGiftNumber
    ) {
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

    public Gift gift() {
        return this.gift;
    }

    public String ownedGiftId() {
        return this.ownedGiftId;
    }

    public Long convertStarCount() {
        return this.convertStarCount;
    }

    public Long prepaidUpgradeStarCount() {
        return this.prepaidUpgradeStarCount;
    }

    public Boolean isUpgradeSeparate() {
        return this.isUpgradeSeparate;
    }

    public Boolean canBeUpgraded() {
        return this.canBeUpgraded;
    }

    public String text() {
        return this.text;
    }

    public List<MessageEntity> entities() {
        return this.entities;
    }

    public Boolean isPrivate() {
        return this.isPrivate;
    }

    public Long uniqueGiftNumber() {
        return this.uniqueGiftNumber;
    }
}
