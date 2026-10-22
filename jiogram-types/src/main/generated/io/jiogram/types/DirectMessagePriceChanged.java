package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a change in the price of direct messages sent to a channel
 * chat.
 *
 * @param areDirectMessagesEnabled True, if direct messages are enabled for the channel chat; false
 *     otherwise
 * @param directMessageStarCount The new number of Telegram Stars that must be paid by users for
 *     each direct message sent to the channel. Does not apply to users who have been exempted by
 *     administrators. Defaults to 0.
 * @see <a href="https://core.telegram.org/bots/api#directmessagepricechanged">DirectMessagePriceChanged in the Bot API</a>
 */
public record DirectMessagePriceChanged(
    @JsonProperty("are_direct_messages_enabled") boolean areDirectMessagesEnabled,
    @JsonProperty("direct_message_star_count") @Nullable Long directMessageStarCount
) {

    public static DirectMessagePriceChanged of(boolean areDirectMessagesEnabled) {
        return new DirectMessagePriceChanged(areDirectMessagesEnabled, null);
    }

    public DirectMessagePriceChanged withAreDirectMessagesEnabled(boolean areDirectMessagesEnabled) {
        return new DirectMessagePriceChanged(areDirectMessagesEnabled, directMessageStarCount);
    }

    public DirectMessagePriceChanged withDirectMessageStarCount(@Nullable Long directMessageStarCount) {
        return new DirectMessagePriceChanged(areDirectMessagesEnabled, directMessageStarCount);
    }
}
