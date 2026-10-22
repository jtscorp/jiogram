package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Describes why a request was unsuccessful.
 *
 * @param migrateToChatId The group has been migrated to a supergroup with the specified identifier.
 *     This number may have more than 32 significant bits and some programming languages may have
 *     difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
 *     signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @param retryAfter In case of exceeding flood control, the number of seconds left to wait before
 *     the request can be repeated
 * @see <a href="https://core.telegram.org/bots/api#responseparameters">ResponseParameters in the Bot API</a>
 */
public record ResponseParameters(
    @JsonProperty("migrate_to_chat_id") @Nullable Long migrateToChatId,
    @JsonProperty("retry_after") @Nullable Long retryAfter
) {

    public ResponseParameters withMigrateToChatId(@Nullable Long migrateToChatId) {
        return new ResponseParameters(migrateToChatId, retryAfter);
    }

    public ResponseParameters withRetryAfter(@Nullable Long retryAfter) {
        return new ResponseParameters(migrateToChatId, retryAfter);
    }
}
