package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBoostSource;

/**
 * This object represents a boost removed from a chat.
 *
 * @param chat Chat which was boosted
 * @param boostId Unique identifier of the boost
 * @param removeDate Point in time (Unix timestamp) when the boost was removed
 * @param source Source of the removed boost
 * @see <a href="https://core.telegram.org/bots/api#chatboostremoved">ChatBoostRemoved in the Bot API</a>
 */
public record ChatBoostRemoved(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("boost_id") String boostId,
    @JsonProperty("remove_date") long removeDate,
    @JsonProperty("source") ChatBoostSource source
) {}
