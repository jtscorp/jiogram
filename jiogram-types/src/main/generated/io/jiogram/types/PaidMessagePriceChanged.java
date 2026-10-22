package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a service message about a change in the price of paid messages within a chat.
 *
 * @param paidMessageStarCount The new number of Telegram Stars that must be paid by
 *     non-administrator users of the supergroup chat for each sent message
 * @see <a href="https://core.telegram.org/bots/api#paidmessagepricechanged">PaidMessagePriceChanged in the Bot API</a>
 */
public record PaidMessagePriceChanged(
    @JsonProperty("paid_message_star_count") long paidMessageStarCount
) {}
