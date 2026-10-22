package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes an inline message to be sent by a user of a Mini App.
 *
 * @param id Unique identifier of the prepared message
 * @param expirationDate Expiration date of the prepared message, in Unix time. Expired prepared
 *     messages can no longer be used
 * @see <a href="https://core.telegram.org/bots/api#preparedinlinemessage">PreparedInlineMessage in the Bot API</a>
 */
public record PreparedInlineMessage(
    @JsonProperty("id") String id,
    @JsonProperty("expiration_date") long expirationDate
) {}
