package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Transfers an owned unique gift to another user. Requires the can_transfer_and_upgrade_gifts
 * business bot right. Requires can_transfer_stars business bot right if the transfer is paid.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#transfergift">transferGift in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransferGift implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("owned_gift_id")
    private final String ownedGiftId;

    @JsonProperty("new_owner_chat_id")
    private final long newOwnerChatId;

    @JsonProperty("star_count")
    private final @Nullable Long starCount;

    /**
     * Creates a new {@code TransferGift} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection
     * @param ownedGiftId Unique identifier of the regular gift that should be transferred
     * @param newOwnerChatId Unique identifier of the chat which will own the gift. The chat must be
     *     active in the last 24 hours.
     * @param starCount The amount of Telegram Stars that will be paid for the transfer from the
     *     business account balance. If positive, then the can_transfer_stars business bot right is
     *     required.
     */
    @JsonCreator
    public TransferGift(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("owned_gift_id") String ownedGiftId,
            @JsonProperty("new_owner_chat_id") long newOwnerChatId,
            @JsonProperty("star_count") @Nullable Long starCount) {
        this.businessConnectionId = businessConnectionId;
        this.ownedGiftId = ownedGiftId;
        this.newOwnerChatId = newOwnerChatId;
        this.starCount = starCount;
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

    /**
     * Unique identifier of the business connection
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier of the regular gift that should be transferred
     */
    public String ownedGiftId() {
        return ownedGiftId;
    }

    /**
     * Unique identifier of the chat which will own the gift. The chat must be active in the last 24
     * hours.
     */
    public long newOwnerChatId() {
        return newOwnerChatId;
    }

    /**
     * The amount of Telegram Stars that will be paid for the transfer from the business account
     * balance. If positive, then the can_transfer_stars business bot right is required.
     */
    public @Nullable Long starCount() {
        return starCount;
    }

    public TransferGift withBusinessConnectionId(String businessConnectionId) {
        return new TransferGift(businessConnectionId, ownedGiftId, newOwnerChatId, starCount);
    }

    public TransferGift withOwnedGiftId(String ownedGiftId) {
        return new TransferGift(businessConnectionId, ownedGiftId, newOwnerChatId, starCount);
    }

    public TransferGift withNewOwnerChatId(long newOwnerChatId) {
        return new TransferGift(businessConnectionId, ownedGiftId, newOwnerChatId, starCount);
    }

    public TransferGift withStarCount(@Nullable Long starCount) {
        return new TransferGift(businessConnectionId, ownedGiftId, newOwnerChatId, starCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransferGift)) {
            return false;
        }
        TransferGift that = (TransferGift) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.ownedGiftId, that.ownedGiftId)
                && this.newOwnerChatId == that.newOwnerChatId
                && Objects.equals(this.starCount, that.starCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.ownedGiftId, this.newOwnerChatId, this.starCount);
    }

    @Override
    public String toString() {
        return "TransferGift[businessConnectionId=" + this.businessConnectionId
                + ", ownedGiftId=" + this.ownedGiftId
                + ", newOwnerChatId=" + this.newOwnerChatId
                + ", starCount=" + this.starCount
                + "]";
    }
}
