package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record TransferGift(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("owned_gift_id") String ownedGiftId,
    @JsonProperty("new_owner_chat_id") long newOwnerChatId,
    @JsonProperty("star_count") @Nullable Long starCount
) implements TelegramMethod<Boolean> {

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
