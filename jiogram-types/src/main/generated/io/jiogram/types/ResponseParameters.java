package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes why a request was unsuccessful.
 *
 * @see <a href="https://core.telegram.org/bots/api#responseparameters">ResponseParameters in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ResponseParameters {

    @JsonProperty("migrate_to_chat_id")
    private final @Nullable Long migrateToChatId;

    @JsonProperty("retry_after")
    private final @Nullable Long retryAfter;

    /**
     * Creates a new {@code ResponseParameters} instance.
     *
     * @param migrateToChatId The group has been migrated to a supergroup with the specified
     *     identifier. This number may have more than 32 significant bits and some programming
     *     languages may have difficulty/silent defects in interpreting it. But it has at most 52
     *     significant bits, so a signed 64-bit integer or double-precision float type are safe for
     *     storing this identifier.
     * @param retryAfter In case of exceeding flood control, the number of seconds left to wait
     *     before the request can be repeated
     */
    @JsonCreator
    public ResponseParameters(
            @JsonProperty("migrate_to_chat_id") @Nullable Long migrateToChatId,
            @JsonProperty("retry_after") @Nullable Long retryAfter) {
        this.migrateToChatId = migrateToChatId;
        this.retryAfter = retryAfter;
    }

    public static ResponseParameters of() {
        return new ResponseParameters(null, null);
    }

    /**
     * The group has been migrated to a supergroup with the specified identifier. This number may
     * have more than 32 significant bits and some programming languages may have difficulty/silent
     * defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit
     * integer or double-precision float type are safe for storing this identifier.
     */
    public @Nullable Long migrateToChatId() {
        return migrateToChatId;
    }

    /**
     * In case of exceeding flood control, the number of seconds left to wait before the request can
     * be repeated
     */
    public @Nullable Long retryAfter() {
        return retryAfter;
    }

    public ResponseParameters withMigrateToChatId(@Nullable Long migrateToChatId) {
        return new ResponseParameters(migrateToChatId, retryAfter);
    }

    public ResponseParameters withRetryAfter(@Nullable Long retryAfter) {
        return new ResponseParameters(migrateToChatId, retryAfter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResponseParameters)) {
            return false;
        }
        ResponseParameters that = (ResponseParameters) o;
        return Objects.equals(this.migrateToChatId, that.migrateToChatId)
                && Objects.equals(this.retryAfter, that.retryAfter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.migrateToChatId, this.retryAfter);
    }

    @Override
    public String toString() {
        return "ResponseParameters[migrateToChatId=" + this.migrateToChatId
                + ", retryAfter=" + this.retryAfter
                + "]";
    }
}
