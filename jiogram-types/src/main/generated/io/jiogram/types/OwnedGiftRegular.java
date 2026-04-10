package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class OwnedGiftRegular implements OwnedGift {
    @JsonProperty("type") private final String type;
    @JsonProperty("gift") private final Gift gift;
    @JsonProperty("owned_gift_id") @Nullable private final String ownedGiftId;
    @JsonProperty("sender_user") @Nullable private final User senderUser;
    @JsonProperty("send_date") private final long sendDate;
    @JsonProperty("text") @Nullable private final String text;
    @JsonProperty("entities") @Nullable private final List<MessageEntity> entities;
    @JsonProperty("is_private") @Nullable private final Boolean isPrivate;
    @JsonProperty("is_saved") @Nullable private final Boolean isSaved;
    @JsonProperty("can_be_upgraded") @Nullable private final Boolean canBeUpgraded;
    @JsonProperty("was_refunded") @Nullable private final Boolean wasRefunded;
    @JsonProperty("convert_star_count") @Nullable private final Long convertStarCount;
    @JsonProperty("prepaid_upgrade_star_count") @Nullable private final Long prepaidUpgradeStarCount;
    @JsonProperty("is_upgrade_separate") @Nullable private final Boolean isUpgradeSeparate;
    @JsonProperty("unique_gift_number") @Nullable private final Long uniqueGiftNumber;

    @JsonCreator
    public OwnedGiftRegular(
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
    ) {
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

    public String type() {
        return this.type;
    }

    public Gift gift() {
        return this.gift;
    }

    public String ownedGiftId() {
        return this.ownedGiftId;
    }

    public User senderUser() {
        return this.senderUser;
    }

    public long sendDate() {
        return this.sendDate;
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

    public Boolean isSaved() {
        return this.isSaved;
    }

    public Boolean canBeUpgraded() {
        return this.canBeUpgraded;
    }

    public Boolean wasRefunded() {
        return this.wasRefunded;
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

    public Long uniqueGiftNumber() {
        return this.uniqueGiftNumber;
    }
}
