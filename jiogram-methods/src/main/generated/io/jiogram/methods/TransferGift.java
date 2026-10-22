package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Transfers an owned unique gift to another user. Requires the can_transfer_and_upgrade_gifts
 * business bot right. Requires can_transfer_stars business bot right if the transfer is paid.
 * Returns True on success.
 *
 * @param businessConnectionId Unique identifier of the business connection
 * @param ownedGiftId Unique identifier of the regular gift that should be transferred
 * @param newOwnerChatId Unique identifier of the chat which will own the gift. The chat must be
 *     active in the last 24 hours.
 * @param starCount The amount of Telegram Stars that will be paid for the transfer from the
 *     business account balance. If positive, then the can_transfer_stars business bot right is
 *     required.
 * @see <a href="https://core.telegram.org/bots/api#transfergift">transferGift in the Bot API</a>
 */
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
