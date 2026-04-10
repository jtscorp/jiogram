package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class TransferGift implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("owned_gift_id") private final String ownedGiftId;
    @JsonProperty("new_owner_chat_id") private final long newOwnerChatId;
    @JsonProperty("star_count") @Nullable private final Long starCount;

    @JsonCreator
    public TransferGift(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("owned_gift_id") String ownedGiftId,
            @JsonProperty("new_owner_chat_id") long newOwnerChatId,
            @JsonProperty("star_count") @Nullable Long starCount
    ) {
        this.businessConnectionId = businessConnectionId;
        this.ownedGiftId = ownedGiftId;
        this.newOwnerChatId = newOwnerChatId;
        this.starCount = starCount;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public String ownedGiftId() {
        return this.ownedGiftId;
    }

    public long newOwnerChatId() {
        return this.newOwnerChatId;
    }

    public Long starCount() {
        return this.starCount;
    }

    @Override
    public String apiMethod() {
        return "transferGift";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static TransferGift of(String businessConnectionId, String ownedGiftId, long newOwnerChatId) {
        return new TransferGift(businessConnectionId, ownedGiftId, newOwnerChatId, null);
    }
}
