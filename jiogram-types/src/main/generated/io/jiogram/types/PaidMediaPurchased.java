package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

/**
 * This object contains information about a paid media purchase.
 *
 * @param from User who purchased the media
 * @param paidMediaPayload Bot-specified paid media payload
 * @see <a href="https://core.telegram.org/bots/api#paidmediapurchased">PaidMediaPurchased in the Bot API</a>
 */
public record PaidMediaPurchased(
    @JsonProperty("from") User from,
    @JsonProperty("paid_media_payload") String paidMediaPayload
) {}
