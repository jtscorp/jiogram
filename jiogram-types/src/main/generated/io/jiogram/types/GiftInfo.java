package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a regular gift that was sent or received.
 *
 * @param gift Information about the gift
 * @param ownedGiftId Unique identifier of the received gift for the bot; only present for gifts
 *     received on behalf of business accounts
 * @param convertStarCount Number of Telegram Stars that can be claimed by the receiver by
 *     converting the gift; omitted if conversion to Telegram Stars is impossible
 * @param prepaidUpgradeStarCount Number of Telegram Stars that were prepaid for the ability to
 *     upgrade the gift
 * @param isUpgradeSeparate True, if the gift's upgrade was purchased after the gift was sent
 * @param canBeUpgraded True, if the gift can be upgraded to a unique gift
 * @param text Text of the message that was added to the gift
 * @param entities Special entities that appear in the text
 * @param isPrivate True, if the sender and gift text are shown only to the gift receiver;
 *     otherwise, everyone will be able to see them
 * @param uniqueGiftNumber Unique number reserved for this gift when upgraded. See the number field
 *     in UniqueGift
 * @see <a href="https://core.telegram.org/bots/api#giftinfo">GiftInfo in the Bot API</a>
 */
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
