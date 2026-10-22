package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about a payment refund for a suggested post.
 *
 * @param suggestedPostMessage Message containing the suggested post. Note that the Message object
 *     in this field will not contain the reply_to_message field even if it itself is a reply.
 * @param reason Reason for the refund. Currently, one of 'post_deleted' if the post was deleted
 *     within 24 hours of being posted or removed from scheduled messages without being posted, or
 *     'payment_refunded' if the payer refunded their payment.
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostrefunded">SuggestedPostRefunded in the Bot API</a>
 */
public record SuggestedPostRefunded(
    @JsonProperty("suggested_post_message") @Nullable Message suggestedPostMessage,
    @JsonProperty("reason") String reason
) {}
