package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGift;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record OwnedGiftUnique(
    @JsonProperty("type") String type,
    @JsonProperty("gift") UniqueGift gift,
    @JsonProperty("owned_gift_id") @Nullable String ownedGiftId,
    @JsonProperty("sender_user") @Nullable User senderUser,
    @JsonProperty("send_date") long sendDate,
    @JsonProperty("is_saved") @Nullable Boolean isSaved,
    @JsonProperty("can_be_transferred") @Nullable Boolean canBeTransferred,
    @JsonProperty("transfer_star_count") @Nullable Long transferStarCount,
    @JsonProperty("next_transfer_date") @Nullable Long nextTransferDate
) implements OwnedGift {}
