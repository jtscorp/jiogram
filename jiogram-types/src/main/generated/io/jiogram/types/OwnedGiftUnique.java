package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGiftType;
import io.jiogram.types.UniqueGift;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class OwnedGiftUnique implements OwnedGift {
    @JsonProperty("type") private final OwnedGiftType type;
    @JsonProperty("gift") private final UniqueGift gift;
    @JsonProperty("owned_gift_id") @Nullable private final String ownedGiftId;
    @JsonProperty("sender_user") @Nullable private final User senderUser;
    @JsonProperty("send_date") private final long sendDate;
    @JsonProperty("is_saved") @Nullable private final Boolean isSaved;
    @JsonProperty("can_be_transferred") @Nullable private final Boolean canBeTransferred;
    @JsonProperty("transfer_star_count") @Nullable private final Long transferStarCount;
    @JsonProperty("next_transfer_date") @Nullable private final Long nextTransferDate;

    @JsonCreator
    public OwnedGiftUnique(
            @JsonProperty("type") OwnedGiftType type,
            @JsonProperty("gift") UniqueGift gift,
            @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
            @JsonProperty("sender_user") @Nullable User senderUser,
            @JsonProperty("send_date") long sendDate,
            @JsonProperty("is_saved") @Nullable Boolean isSaved,
            @JsonProperty("can_be_transferred") @Nullable Boolean canBeTransferred,
            @JsonProperty("transfer_star_count") @Nullable Long transferStarCount,
            @JsonProperty("next_transfer_date") @Nullable Long nextTransferDate
    ) {
        this.type = type;
        this.gift = gift;
        this.ownedGiftId = ownedGiftId;
        this.senderUser = senderUser;
        this.sendDate = sendDate;
        this.isSaved = isSaved;
        this.canBeTransferred = canBeTransferred;
        this.transferStarCount = transferStarCount;
        this.nextTransferDate = nextTransferDate;
    }

    public OwnedGiftType type() {
        return this.type;
    }

    public UniqueGift gift() {
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

    public Boolean isSaved() {
        return this.isSaved;
    }

    public Boolean canBeTransferred() {
        return this.canBeTransferred;
    }

    public Long transferStarCount() {
        return this.transferStarCount;
    }

    public Long nextTransferDate() {
        return this.nextTransferDate;
    }
}
